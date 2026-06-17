package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;

import it.uniroma3.siw.service.PrenotazioneService;

@Controller
public class PrenotazioneController {
	private PrenotazioneService prenotazioneService;

	public PrenotazioneController(PrenotazioneService prenotazioneService) {
		this.prenotazioneService = prenotazioneService;
	}
}
