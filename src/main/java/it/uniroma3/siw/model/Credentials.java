package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.OneToOne;

public class Credentials {
	private Long id;
	private String password;
	private String Username;
	private RuoloUtente ruolo;

	@OneToOne
	private Utente utente;
	@OneToOne
	private Istruttore istruttore;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public RuoloUtente getRuolo() {
		return ruolo;
	}
	public void setRuolo(RuoloUtente ruolo) {
		this.ruolo = ruolo;
	}
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Istruttore getIstruttore() {
		return istruttore;
	}
	public void setIstruttore(Istruttore istruttore) {
		this.istruttore = istruttore;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		return Objects.equals(Username, other.Username);
	}
	
}
