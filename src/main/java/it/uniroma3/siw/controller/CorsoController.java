package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.exception.DuplicateCorsoException;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.CorsoService;
import it.uniroma3.siw.service.IstruttoreService;
import it.uniroma3.siw.service.PrenotazioneService;
import jakarta.validation.Valid;

import it.uniroma3.siw.service.RecensioneService;

@Controller
public class CorsoController {
	private CorsoService corsoService;
	private IstruttoreService istruttoreService;
	private RecensioneService recensioneService;
	private PrenotazioneService prenotazioneService;

	public CorsoController(CorsoService corsoService, IstruttoreService istruttoreService, RecensioneService recensioneService, PrenotazioneService prenotazioneService) {
		this.corsoService = corsoService;
		this.istruttoreService = istruttoreService;
		this.recensioneService = recensioneService;
		this.prenotazioneService = prenotazioneService;
	}
	
	@GetMapping("/corsi")
	public String showCorsi(Model model) {
		model.addAttribute("corsi", this.corsoService.findAll());
		return "corsi/list.html";
	}
	
	@GetMapping("/corsi/{id}")
	public String show(@PathVariable("id") Long id, Model model){
		Corso corso = this.corsoService.findByIdWithIstruttoreAndUtenti(id);
		model.addAttribute("corso", corso);
		model.addAttribute("recensioni", this.recensioneService.findByCorso(corso));
		model.addAttribute("recensione", new Recensione());
		return "corsi/show.html";
	}
	
	@GetMapping("/admin/corsi/new")
	public String formNewCorso(Model model) {
		model.addAttribute("corso", new Corso());
		model.addAttribute("istruttori", this.istruttoreService.findAll());
		return "corsi/form";
	}
	
	@PostMapping("/admin/corsi")
	public String newCorso(@Valid @ModelAttribute("corso") Corso corso, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("istruttori", this.istruttoreService.findAll());
			return "corsi/form.html";
		}
		
		try {
			this.corsoService.save(corso);
			return "redirect:/corsi";
		}
		catch(DuplicateCorsoException e) {
			bindingResult.reject("corso.duplicate");
			return "corsi/form";
		}
		
	}
	
	@GetMapping("/admin/corsi/{id}")
	public String deleteCorso(@PathVariable("id") Long id) {
		this.corsoService.deleteById(id);
		return "redirect:/corsi";
	}
	
	@GetMapping("/istruttore/corsi/edit/{id}")
	public String formEditCorso(@PathVariable("id") Long id, Model model) {
		model.addAttribute("corso", this.corsoService.findById(id));
		model.addAttribute("istruttori", this.istruttoreService.findAll());
		return "corsi/edit";
	}
	
	@GetMapping("/istruttore/corsi/{id}/iscritti")
	public String showIscrittiAlCorso(@PathVariable("id") Long id, Model model) {
		Corso corso = this.corsoService.findByIdWithIstruttoreAndUtenti(id);
		model.addAttribute("corso", corso);
		model.addAttribute("prenotazioni", this.prenotazioneService.findByCorso(corso));
		return "prenotazioni/iscritti.html";
	}
	
	@PostMapping("/istruttore/corsi/edit/{id}")
	public String editCorso(@Valid @ModelAttribute("corso") Corso corso, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("istruttori", this.istruttoreService.findAll());
			return "corsi/form.html";
		}
		try {
			this.corsoService.update(corso);
			return "redirect:/corsi";
		}
		catch(DuplicateCorsoException e) {
			bindingResult.reject("corso.duplicate");
			return "corsi/form";
		}
	}
}
