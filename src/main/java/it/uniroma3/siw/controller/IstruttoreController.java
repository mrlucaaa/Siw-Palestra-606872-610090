package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;

import it.uniroma3.siw.service.IstruttoreService;

@Controller
public class IstruttoreController {
	private IstruttoreService istruttoreService;

	public IstruttoreController(IstruttoreService istruttoreService) {
		this.istruttoreService = istruttoreService;
	}
}
