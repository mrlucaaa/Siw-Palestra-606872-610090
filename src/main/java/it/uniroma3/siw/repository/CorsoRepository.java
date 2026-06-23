package it.uniroma3.siw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Corso;

public interface CorsoRepository extends CrudRepository<Corso, Long>{
	
	@Query("SELECT c FROM Corso c LEFT JOIN FETCH c.istruttori LEFT JOIN FETCH c.iscritti WHERE c.id = :id")
	Optional<Corso> findByIdWithIstruttoreAndUtenti(@Param("id") Long id);

}
