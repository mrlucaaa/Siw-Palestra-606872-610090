package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.model.StatoPrenotazione;
import it.uniroma3.siw.repository.PrenotazioneRepository;

@Service
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
	
	public void disdiciPrenotazione(Prenotazione prenotazione) {
		prenotazione.setStato(StatoPrenotazione.DISDETTA);
		this.prenotazioneRepository.save(prenotazione);
	}
}
