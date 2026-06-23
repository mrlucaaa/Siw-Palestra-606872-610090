package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.service.CorsoService;
import it.uniroma3.siw.service.IstruttoreService;

@Controller
public class CorsoController {
	private CorsoService corsoService;
	private IstruttoreService istruttoreService;

	public CorsoController(CorsoService corsoService, IstruttoreService istruttoreService) {
		this.corsoService = corsoService;
		this.istruttoreService = istruttoreService;
	}
	
	@GetMapping("/corsi")
	public String showCorsi(Model model) {
		model.addAttribute("corsi", this.corsoService.findAll());
		return "corsi/list.html";
	}
	
	@GetMapping("/corsi/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("corsi", this.corsoService.findByIdWithIstruttoreAndUtenti(id));
		return "corsi/show.html";
	}
	
	@GetMapping("/admin/corsi/new")
	public String formNewCorso(Model model) {
		model.addAttribute("corso", new Corso());
		model.addAttribute("istruttori", this.istruttoreService.findAll());
		return "corsi/form";
	}
	
	@PostMapping("/admin/corsi")
	public String newCorso(@ModelAttribute("corso") Corso corso) {
		this.corsoService.save(corso);
		return "redirect:/corsi";
	}
	
	@GetMapping("/admin/corsi/{id}")
	public String deleteCorso(@PathVariable("id") Long id) {
		this.corsoService.deleteById(id);
		return "redirect:/corsi";
	}
	
	@GetMapping("/istruttore/corsi/edit/{id}")
	public String formEditCorso(@PathVariable("id") Long id, Model model) {
		model.addAttribute("corsi", this.corsoService.findById(id));
		return "corsi/edit";
	}
	
	@PostMapping("/istruttore/corsi/edit/{id}")
	public String editCorso(@ModelAttribute("corso") Corso corso) {
		this.corsoService.update(corso);
		return "redirect:/corsi/" + corso.getId();
	}
}
