package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.UtenteRepository;
import it.uniroma3.siw.exception.UtenteNotFoundException;

@Service
@Transactional(readOnly = true)
public class UtenteService {
	private UtenteRepository utenteRepository;

	public UtenteService(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
	}
	
	public Iterable<Utente> findAll(){
		return utenteRepository.findAll();
	}
	
	public Utente findUtente(Long id) throws UtenteNotFoundException {
		Utente utente = this.utenteRepository.findById(id).orElse(null);
		if(utente == null) {
			throw new UtenteNotFoundException();
		}
		return utente;
	}
	
	@Transactional
	public void saveUtente(Utente utente) {
		this.utenteRepository.save(utente);
	}
}
