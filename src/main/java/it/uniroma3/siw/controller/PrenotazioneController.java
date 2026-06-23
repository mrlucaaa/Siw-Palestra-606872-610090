package it.uniroma3.siw.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.model.StatoPrenotazione;
import it.uniroma3.siw.service.CorsoService;
import it.uniroma3.siw.service.PrenotazioneService;

@Controller
public class PrenotazioneController {
	private PrenotazioneService prenotazioneService;
	private CorsoService corsoService;
	public PrenotazioneController(PrenotazioneService prenotazioneService, CorsoService corsoService) {
		this.prenotazioneService = prenotazioneService;
		this.corsoService = corsoService;
	}
	
	@GetMapping("/prenotazioni")
	public String showPrenotazioni(Model model) {
		//recuperare informazioni utente
		model.addAttribute("prenotazioni", this.prenotazioneService.findAll());
		return "prenotazioni/list.html";
	}
	
	@GetMapping("/prenotazioni/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("prenotazione", this.prenotazioneService.findById(id));
		return "prenotazioni/show.html";
	}
	
	@PostMapping("/prenotazioni/{id}")
	public String disdiciPrenotazione(@PathVariable("id") Long id) {
		Prenotazione prenotazione = this.prenotazioneService.findById(id);
		this.prenotazioneService.disdiciPrenotazione(prenotazione);
		return "redirect:/prenotazioni";
	}
	
	@PostMapping("/utente/corsi/{idCorso}/prenotazioni")
	public String newPrenotazione(@PathVariable("idCorso") Long idCorso, @ModelAttribute("prenotazione") Prenotazione prenotazione) {
		Corso corso = corsoService.findById(idCorso);
		
		//nome utente da implementare
		this.prenotazioneService.save(corso);
		return "prenotazioni/successo";
	}
	
	
	
}
