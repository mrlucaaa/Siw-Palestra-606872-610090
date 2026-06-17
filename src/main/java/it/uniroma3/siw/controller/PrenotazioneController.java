package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.service.PrenotazioneService;

@Controller
public class PrenotazioneController {
	private PrenotazioneService prenotazioneService;

	public PrenotazioneController(PrenotazioneService prenotazioneService) {
		this.prenotazioneService = prenotazioneService;
	}
	
	@GetMapping("/prenotazioni")
	public String showPrenotazioni(Model model) {
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
}
