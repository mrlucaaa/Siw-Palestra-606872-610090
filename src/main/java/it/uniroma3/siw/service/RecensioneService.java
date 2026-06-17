package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.RecensioneRepository;

@Service
public class RecensioneService {
	private RecensioneRepository recensioneRepository;

	public RecensioneService(RecensioneRepository recensioneRepository) {
		this.recensioneRepository = recensioneRepository;
	}
}
