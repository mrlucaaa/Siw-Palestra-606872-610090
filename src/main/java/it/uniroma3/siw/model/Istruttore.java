package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Istruttore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long codiceTessera;
	private String nome;
	private String cognome;
	private String specializzazione;
	
	@OneToMany(mappedBy = "istruttore")
	private List<Corso> corso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodiceTessera() {
		return codiceTessera;
	}

	public void setCodiceTessera(Long codiceTessera) {
		this.codiceTessera = codiceTessera;
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

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public List<Corso> getCorso() {
		return corso;
	}

	public void setCorso(List<Corso> corso) {
		this.corso = corso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceTessera);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Istruttore other = (Istruttore) obj;
		return Objects.equals(codiceTessera, other.codiceTessera);
	}
	
	
	
	
}
