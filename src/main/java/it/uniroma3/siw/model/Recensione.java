package it.uniroma3.siw.model;

import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;

public class Recensione {
	private Long id;
	private String testo;
	private Long numeroStelle;
	private LocalDateTime dataOra;
	
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
	
	
}
