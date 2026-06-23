package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.exception.CorsoNotFoundException;
import it.uniroma3.siw.exception.DuplicateCorsoException;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.repository.CorsoRepository;

@Service
@Transactional(readOnly = true)
public class CorsoService {
	private CorsoRepository corsoRepository;

	public CorsoService(CorsoRepository corsoRepository) {
		this.corsoRepository = corsoRepository;
	}

	public Iterable<Corso> findAll(){
		return this.corsoRepository.findAll();
	}

	public Corso findById(Long id) throws CorsoNotFoundException{
		Corso corso = corsoRepository.findById(id).orElse(null);
		if(corso==null) {
			throw new CorsoNotFoundException();
		}
		return corso;
	}

	public Corso findByIdWithIstruttoreAndUtenti(Long id) throws CorsoNotFoundException{
		Corso corso = this.corsoRepository.findByIdWithIstruttoreAndPrenotazioni(id).orElse(null);
		if(corso==null) {
			throw new CorsoNotFoundException();
		}
		return corso;
	}

	@Transactional
	public void save(Corso corso) throws DuplicateCorsoException{
		if(corsoRepository.existsByDataOraAndNome(corso.getDataOra(), corso.getNome())) {
			throw new DuplicateCorsoException();
		}
		this.corsoRepository.save(corso);
	}

	@Transactional
	public void deleteById(Long id) {
		this.corsoRepository.deleteById(id);
	}

	@Transactional
	public void update(Corso corsoNuovo) throws CorsoNotFoundException, DuplicateCorsoException {
		Corso corsoVecchio = this.findById(corsoNuovo.getId());
//		lanciamo l'eccezione solo se l'utente cambia il nome o la data (e.g. se cambia descrizione e lascia il resto uguale
//		senza if lancerebbe eccezione)
		
		if(!corsoVecchio.getNome().equals(corsoNuovo.getNome()) || !corsoVecchio.getDataOra().equals(corsoNuovo.getDataOra())) { 
			if(corsoRepository.existsByDataOraAndNome(corsoNuovo.getDataOra(), corsoNuovo.getNome())) {
				throw new DuplicateCorsoException();
		}
		
		}
		corsoVecchio.setNome(corsoNuovo.getNome());
		corsoVecchio.setDescrizione(corsoNuovo.getDescrizione());
		corsoVecchio.setDataOra(corsoNuovo.getDataOra());
		corsoVecchio.setCapienzaMax(corsoNuovo.getCapienzaMax());

	}
}
