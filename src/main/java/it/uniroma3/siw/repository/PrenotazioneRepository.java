package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.model.Utente;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.StatoPrenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{
	List<Prenotazione> findByUtente(Utente utente);
	boolean existsByUtenteAndCorso(Utente utente, Corso corso);
	long countByCorsoAndStato(Corso corso, StatoPrenotazione stato);
}
