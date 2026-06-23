package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.UtenteRepository;

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
	
	public Utente findUtente(Long id) {
		return this.utenteRepository.findById(id).orElse(null);
	}
	
	public void saveUtente(Utente utente) {
		this.utenteRepository.save(utente);
	}
}
