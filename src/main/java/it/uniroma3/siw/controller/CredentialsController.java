package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;

import it.uniroma3.siw.service.CredentialsService;

@Controller
public class CredentialsController {
	private CredentialsService credentialsService;

	public CredentialsController(CredentialsService credentialsService) {
		this.credentialsService = credentialsService;
	}
	
	
}
