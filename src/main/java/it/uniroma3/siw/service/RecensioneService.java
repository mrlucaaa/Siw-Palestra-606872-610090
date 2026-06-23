package it.uniroma3.siw.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.repository.RecensioneRepository;

@Service
@Transactional(readOnly = true)
public class RecensioneService {
	private RecensioneRepository recensioneRepository;

	public RecensioneService(RecensioneRepository recensioneRepository) {
		this.recensioneRepository = recensioneRepository;
	}
	
	
	@Transactional
	public void save(Corso corso, Recensione recensione) {
		recensione.setDataOra(LocalDateTime.now());
		recensione.setCorso(corso);
		//agganciare utente
		recensioneRepository.save(recensione);
	}
}
