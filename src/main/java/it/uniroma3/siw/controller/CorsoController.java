package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;

import it.uniroma3.siw.service.CorsoService;

@Controller
public class CorsoController {
	private CorsoService controllerService;

	public CorsoController(CorsoService controllerService) {
		this.controllerService = controllerService;
	}
}
