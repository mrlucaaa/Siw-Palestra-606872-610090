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
public class AuthController {
	private CredentialsService credentialsService;
	private UtenteService utenteService;
	private PasswordEncoder passwordEncoder;
	
	public AuthController(CredentialsService credentialsService, UtenteService utenteService, PasswordEncoder passwordEncoder) {
		this.credentialsService = credentialsService;
		this.utenteService = utenteService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/register")
	public String formRegister(Model model) {
		model.addAttribute("utente", new Utente());
		model.addAttribute("credentials", new Credentials());
		return "register.html";
	}
	
	@GetMapping("/login")
	public String formLogin(Model model) {
		return "login.html";
	}
	
	@GetMapping("/success")
	public String defaultAfterLogin(Model model) {
		return "redirect:/";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("utente") Utente utente, 
							   BindingResult utenteBindingResult, 
							   @Valid @ModelAttribute("credentials") Credentials credentials, 
							   BindingResult credentialsBindingResult, 
							   Model model) {
							   
		if(this.credentialsService.findCredentialsByUsername(credentials.getUsername()) != null) {
			credentialsBindingResult.rejectValue("username", "duplicate", "Username già in uso");
		}
		
		if(utenteBindingResult.hasErrors() || credentialsBindingResult.hasErrors()) {
			return "register.html";
		}
		
		credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
		credentials.setRuolo(RuoloUtente.CLIENTE);
		
		// Fix for TransientPropertyValueException
		this.utenteService.saveUtente(utente);
		
		credentials.setUtente(utente);
		this.credentialsService.saveCredentials(credentials);
		
		utente.setCredentials(credentials);
		this.utenteService.saveUtente(utente);
		
		model.addAttribute("utente", utente);
		return "registrationSuccessful.html";
	}
}
