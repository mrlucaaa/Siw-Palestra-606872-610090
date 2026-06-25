package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Utente;

public interface RecensioneRepository extends CrudRepository<Recensione, Long>{
	boolean existsByUtenteAndCorso(Utente utente, Corso corso);
	
	@Query("SELECT r FROM Recensione r LEFT JOIN FETCH r.utente WHERE r.corso = :corso")
	List<Recensione> findByCorsoWithUtente(@Param("corso") Corso corso);
}
