package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;

import it.uniroma3.siw.service.RecensioneService;

@Controller
public class RecensioneController {
	private RecensioneService recensioneService;

	public RecensioneController(RecensioneService recensioneService) {
		this.recensioneService = recensioneService;
	}
	
}
