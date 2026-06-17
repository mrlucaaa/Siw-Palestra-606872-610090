package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	private PrenotazioneRepository prenotazioneRepository;

	public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
		this.prenotazioneRepository = prenotazioneRepository;
	}
}
