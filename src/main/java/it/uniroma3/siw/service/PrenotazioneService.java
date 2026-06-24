package it.uniroma3.siw.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.exception.PrenotazioneNotFoundException;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.model.StatoPrenotazione;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.PrenotazioneRepository;
import it.uniroma3.siw.exception.PrenotazioneDuplicataException;
import it.uniroma3.siw.exception.CorsoAlCompletoException;

@Service
@Transactional(readOnly = true)
public class PrenotazioneService {
	private PrenotazioneRepository prenotazioneRepository;
	private CredentialsService credentialsService;

	public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, CredentialsService credentialsService) {
		this.prenotazioneRepository = prenotazioneRepository;
		this.credentialsService = credentialsService;
	}
	
	public Iterable<Prenotazione> findAll(){
		return this.prenotazioneRepository.findAll();
	}
	
	public Prenotazione findById(Long id) throws PrenotazioneNotFoundException {
		Prenotazione prenotazione = prenotazioneRepository.findById(id).orElse(null);
		if(prenotazione==null) {
			throw new PrenotazioneNotFoundException();
		}
		return prenotazione;
	}
	
	@Transactional
	public void disdiciPrenotazione(Prenotazione prenotazione) {
		prenotazione.setStato(StatoPrenotazione.DISDETTA);
		this.prenotazioneRepository.save(prenotazione);
	}
	
	@Transactional
	public void save(Corso corso, Utente utente) throws CorsoAlCompletoException, PrenotazioneDuplicataException {
		if (this.prenotazioneRepository.existsByUtenteAndCorso(utente, corso)) {
			throw new PrenotazioneDuplicataException();
		}
		
		long prenotazioniAttive = this.prenotazioneRepository.countByCorsoAndStato(corso, StatoPrenotazione.ATTIVA);
		if (corso.getCapienzaMax() != null && prenotazioniAttive >= corso.getCapienzaMax()) {
			throw new CorsoAlCompletoException();
		}
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCorso(corso);
		prenotazione.setDataCreazione(LocalDateTime.now());
		prenotazione.setStato(StatoPrenotazione.ATTIVA);
		prenotazione.setUtente(utente);
		this.prenotazioneRepository.save(prenotazione);
	}
	
	public Iterable<Prenotazione> findByUtente(Utente utente){
		return this.prenotazioneRepository.findByUtente(utente);
	}
	
}
