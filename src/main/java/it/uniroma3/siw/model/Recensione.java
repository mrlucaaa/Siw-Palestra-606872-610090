package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Recensione {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String testo;
	@Min(1)
	@Max(5)
	@NotNull
	private Long numeroStelle;
	@NotNull
	private LocalDateTime dataOra;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Corso corso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public Long getNumeroStelle() {
		return numeroStelle;
	}
	public void setNumeroStelle(Long numeroStelle) {
		this.numeroStelle = numeroStelle;
	}
	public LocalDateTime getDataOra() {
		return dataOra;
	}
	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}
	public Corso getCorso() {
		return corso;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dataOra, utente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
		return Objects.equals(dataOra, other.dataOra) && Objects.equals(utente, other.utente);
	}
	
	
}
