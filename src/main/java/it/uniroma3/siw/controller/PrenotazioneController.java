package it.uniroma3.siw.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.service.CorsoService;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.PrenotazioneService;

@Controller
public class PrenotazioneController {
	private PrenotazioneService prenotazioneService;
	private CorsoService corsoService;
	private CredentialsService credentialsService;
	public PrenotazioneController(PrenotazioneService prenotazioneService, CorsoService corsoService, CredentialsService credentialsService) {
		this.prenotazioneService = prenotazioneService;
		this.corsoService = corsoService;
	}
	
	@GetMapping("/utente/prenotazioni")
	public String showPrenotazioni(Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Credentials credentials = this.credentialsService.findCredentialsByUsername(userDetails.getUsername());
		model.addAttribute("prenotazioni", this.prenotazioneService.findByUtente(credentials.getUtente()));
		return "prenotazioni/list.html";
	}
	
	@GetMapping("/utente/prenotazioni/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("prenotazione", this.prenotazioneService.findById(id));
		return "prenotazioni/show.html";
	}
	
	@PostMapping("/utente/prenotazioni/{id}")
	public String disdiciPrenotazione(@PathVariable("id") Long id) {
		Prenotazione prenotazione = this.prenotazioneService.findById(id);
		this.prenotazioneService.disdiciPrenotazione(prenotazione);
		return "redirect:/prenotazioni";
	}
	
	@PostMapping("/utente/corsi/{idCorso}/prenotazioni")
	public String newPrenotazione(@PathVariable("idCorso") Long idCorso, @ModelAttribute("prenotazione") Prenotazione prenotazione) {
		Corso corso = corsoService.findById(idCorso);
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = this.credentialsService.findCredentialsByUsername(userDetails.getUsername());
		this.prenotazioneService.save(corso, credentials.getUtente());
		return "prenotazioni/successo";
	}
	
	
	
}
