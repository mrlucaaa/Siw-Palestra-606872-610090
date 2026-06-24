package it.uniroma3.siw.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.dto.CorsoDTO;
import it.uniroma3.siw.exception.CorsoNotFoundException;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.service.CorsoService;

@RestController
@RequestMapping("/api/corsi")
public class CorsoRestController {

	@Autowired
	private CorsoService corsoService;

	/**
	 * Ritorna tutti i corsi sotto forma di DTO per evitare dipendenze cicliche.
	 */
	@GetMapping
	public List<CorsoDTO> getAllCorsi() {
		List<CorsoDTO> corsiDTO = new ArrayList<>();
		
		for (Corso corso : corsoService.findAll()) {
			corsiDTO.add(convertToDTO(corso));
		}
		
		return corsiDTO;
	}

	/**
	 * Ritorna un singolo corso dato l'ID, mappato nel DTO.
	 */
	@GetMapping("/{id}")
	public CorsoDTO getCorso(@PathVariable Long id) {
		try {
			Corso corso = corsoService.findById(id);
			return convertToDTO(corso);
		} catch (CorsoNotFoundException e) {
			// Solitamente si gestisce ritornando un ResponseEntity con 404
			return null;
		}
	}

	/**
	 * Metodo di utilità per mappare l'Entity Corso nel suo DTO.
	 */
	private CorsoDTO convertToDTO(Corso corso) {
		CorsoDTO dto = new CorsoDTO();
		dto.setId(corso.getId());
		dto.setNome(corso.getNome());
		dto.setDescrizione(corso.getDescrizione());
		dto.setCapienzaMax(corso.getCapienzaMax());
		dto.setDataOra(corso.getDataOra());
		
		// Gestiamo in sicurezza la relazione con Istruttore
		if (corso.getIstruttore() != null) {
			dto.setIstruttoreId(corso.getIstruttore().getId());
			dto.setIstruttoreNome(corso.getIstruttore().getNome());
			dto.setIstruttoreCognome(corso.getIstruttore().getCognome());
		}
		
		return dto;
	}

}
