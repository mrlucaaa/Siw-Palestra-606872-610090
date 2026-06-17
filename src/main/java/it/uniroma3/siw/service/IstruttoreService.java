package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.IstruttoreRepository;

@Service
public class IstruttoreService {
	private IstruttoreRepository istruttoreRepository;

	public IstruttoreService(IstruttoreRepository istruttoreRepository) {
		this.istruttoreRepository = istruttoreRepository;
	}
}
