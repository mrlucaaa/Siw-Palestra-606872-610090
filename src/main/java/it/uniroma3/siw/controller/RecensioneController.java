package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.CorsoService;
import it.uniroma3.siw.service.RecensioneService;

@Controller
public class RecensioneController {
	private RecensioneService recensioneService;
	private CorsoService corsoService;
	public RecensioneController(RecensioneService recensioneService, CorsoService corsoService) {
		this.recensioneService = recensioneService;
		this.corsoService = corsoService;
	}
	
	@PostMapping("/utente/corsi/{idCorso}/recensioni")
	public String Recensione(@PathVariable("idCorso") Long idCorso, @ModelAttribute("recensione") Recensione recensione) {
		Corso corso = corsoService.findById(idCorso);
		//utente da implementare
		this.recensioneService.save(corso, recensione);
		return "redirect:/corsi/" + idCorso;
	}
	
}
