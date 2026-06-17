package it.uniroma3.siw.model;

import java.util.Objects;

public class Credentials {
	private Long id;
	private String password;
	private String Username;
	
	
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
	private RuoloUtente ruolo;
	
}
