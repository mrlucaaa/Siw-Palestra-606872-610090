package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.repository.CredentialsRepository;

@Service
public class CredentialsService {
	private CredentialsRepository credentialsRepository;

	public CredentialsService(CredentialsRepository credentialsRepository) {
		this.credentialsRepository = credentialsRepository;
	}
}
