package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class Utente {
	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String email;
	
	@OneToOne
	private Credentials credentials;
	
	@OneToMany(mappedBy = "utente")
	private Prenotazione prenotazione;
	
	@OneToMany(mappedBy = "utente")
	private Recensione recensione;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Recensione getRecensione() {
		return recensione;
	}

	public void setRecensione(Recensione recensione) {
		this.recensione = recensione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceFiscale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(codiceFiscale, other.codiceFiscale);
	}
	
	
}
