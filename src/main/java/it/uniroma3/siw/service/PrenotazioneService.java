package it.uniroma3.siw.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.model.StatoPrenotazione;
import it.uniroma3.siw.repository.PrenotazioneRepository;

@Service
@Transactional(readOnly = true)
public class PrenotazioneService {
	private PrenotazioneRepository prenotazioneRepository;

	public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
		this.prenotazioneRepository = prenotazioneRepository;
	}
	
	public Iterable<Prenotazione> findAll(){
		return this.prenotazioneRepository.findAll();
	}
	
	public Prenotazione findById(Long id) {
		return prenotazioneRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public void disdiciPrenotazione(Prenotazione prenotazione) {
		prenotazione.setStato(StatoPrenotazione.DISDETTA);
		this.prenotazioneRepository.save(prenotazione);
	}
	
	@Transactional
	public void save(Corso corso) {
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setCorso(corso);
		prenotazione.setDataCreazione(LocalDateTime.now());
		prenotazione.setStato(StatoPrenotazione.ATTIVA);
		this.prenotazioneRepository.save(prenotazione);
	}
	
}
