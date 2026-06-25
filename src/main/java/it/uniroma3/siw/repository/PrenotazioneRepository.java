package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.model.Utente;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.StatoPrenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{
	@Query("SELECT p FROM Prenotazione p LEFT JOIN FETCH p.corso WHERE p.utente = :utente")
	List<Prenotazione> findByUtente(@Param("utente") Utente utente);
	
	@Query("SELECT p FROM Prenotazione p LEFT JOIN FETCH p.utente WHERE p.corso = :corso")
	List<Prenotazione> findByCorso(@Param("corso") Corso corso);
	boolean existsByUtenteAndCorso(Utente utente, Corso corso);
	long countByCorsoAndStato(Corso corso, StatoPrenotazione stato);
}
