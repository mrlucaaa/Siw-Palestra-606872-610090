package it.uniroma3.siw.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.CorsoService;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.RecensioneService;
import jakarta.validation.Valid;

@Controller
public class RecensioneController {
	private CredentialsService credentialsService;
	private RecensioneService recensioneService;
	private CorsoService corsoService;
	
	public RecensioneController(RecensioneService recensioneService, CorsoService corsoService, CredentialsService credentialsService) {
		this.recensioneService = recensioneService;
		this.corsoService = corsoService;
		this.credentialsService = credentialsService;
	}
	
	@PostMapping("/utente/corsi/{idCorso}/recensioni")
	public String newRecensione(@PathVariable("idCorso") Long idCorso, @Valid @ModelAttribute("recensione") Recensione recensione, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("corsi", corsoService.findById(idCorso));
			return "corsi/show.html";
		}
		Corso corso = corsoService.findById(idCorso);
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = this.credentialsService.findCredentialsByUsername(userDetails.getUsername());
		this.recensioneService.save(corso, recensione, credentials.getUtente());
		return "redirect:/corsi/" + idCorso;
	}
	
}
