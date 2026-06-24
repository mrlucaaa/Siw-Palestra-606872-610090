package it.uniroma3.siw.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.RuoloUtente;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.UtenteService;
import jakarta.validation.Valid;

@Controller
public class CredentialsController {
	private CredentialsService credentialsService;
	private UtenteService utenteService;
	private PasswordEncoder passwordEncoder;

	public CredentialsController(CredentialsService credentialsService, UtenteService utenteService, PasswordEncoder passwordEncoder) {
		this.credentialsService = credentialsService;
		this.utenteService = utenteService;
		this.passwordEncoder = passwordEncoder;
	}
	
}
