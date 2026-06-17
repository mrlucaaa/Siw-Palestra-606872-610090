package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.CorsoRepository;

@Service
public class CorsoService {
	private CorsoRepository corsoRepository;

	public CorsoService(CorsoRepository corsoRepository) {
		this.corsoRepository = corsoRepository;
	}
}
