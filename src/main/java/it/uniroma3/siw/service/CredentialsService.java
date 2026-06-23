package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.repository.CredentialsRepository;

@Service
public class CredentialsService {
	private CredentialsRepository credentialsRepository;

	public CredentialsService(CredentialsRepository credentialsRepository) {
		this.credentialsRepository = credentialsRepository;
	}
	
	public Credentials findCredentialsById(Long id) {
		return this.credentialsRepository.findById(id).orElse(null);
	}
	
	public Credentials findCredentialsByUsername(String username) {
		return this.credentialsRepository.findByUsername(username).orElse(null);
	}
	
	public void saveCredentials(Credentials credentials) {
		this.credentialsRepository.save(credentials);
	}
}
