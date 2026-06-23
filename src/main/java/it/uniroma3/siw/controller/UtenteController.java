package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.UtenteService;

@Controller
public class UtenteController {
	private UtenteService utenteService;

	public UtenteController(UtenteService utenteService) {
		this.utenteService = utenteService;
	}
	
	@GetMapping("/istruttore/iscritti")
	public String showIscritti(Model model) {
		model.addAttribute("iscritti", this.utenteService.findAll());
		return "utenti/list.html";
	}
	
	
}
