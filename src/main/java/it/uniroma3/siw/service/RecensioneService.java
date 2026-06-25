package it.uniroma3.siw.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.RecensioneRepository;
import it.uniroma3.siw.exception.RecensioneDuplicataException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RecensioneService {
	private RecensioneRepository recensioneRepository;
	private CredentialsService credentialsService;

	public RecensioneService(RecensioneRepository recensioneRepository, CredentialsService credentialsService) {
		this.recensioneRepository = recensioneRepository;
		this.credentialsService = credentialsService;
	}
	
	public List<Recensione> findByCorso(Corso corso) {
		return this.recensioneRepository.findByCorsoWithUtente(corso);
	}
	
	@Transactional
	public void save(Corso corso, Recensione recensione, Utente utente) throws RecensioneDuplicataException {
		if (this.recensioneRepository.existsByUtenteAndCorso(utente, corso)) {
			throw new RecensioneDuplicataException();
		}
		recensione.setDataOra(LocalDateTime.now());
		recensione.setCorso(corso);
		recensione.setUtente(utente);
		recensioneRepository.save(recensione);
	}
}
