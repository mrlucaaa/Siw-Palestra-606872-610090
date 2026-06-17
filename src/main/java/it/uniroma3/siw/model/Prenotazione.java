package it.uniroma3.siw.model;

import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;

public class Prenotazione {
	private Long id;
	private LocalDateTime dataCreazione;
	private StatoPrenotazione stato;

	@ManyToOne
	private Utente utente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public StatoPrenotazione getStato() {
		return stato;
	}
	public void setStato(StatoPrenotazione stato) {
		this.stato = stato;
	}

}
