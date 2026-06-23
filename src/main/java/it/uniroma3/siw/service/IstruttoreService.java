package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Istruttore;
import it.uniroma3.siw.repository.IstruttoreRepository;

@Service
@Transactional(readOnly = true)
public class IstruttoreService {
	private IstruttoreRepository istruttoreRepository;

	public IstruttoreService(IstruttoreRepository istruttoreRepository) {
		this.istruttoreRepository = istruttoreRepository;
	}
	
	public Iterable<Istruttore> findAll(){
		return this.istruttoreRepository.findAll();
	}
}
