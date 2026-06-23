package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private LocalDateTime dataCreazione;
	@Enumerated(EnumType.STRING)
	private StatoPrenotazione stato;
	
	@ManyToOne
	private Corso corso;
	
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
		return Objects.hash(corso, dataCreazione, utente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenotazione other = (Prenotazione) obj;
		return Objects.equals(corso, other.corso) && Objects.equals(dataCreazione, other.dataCreazione)
				&& Objects.equals(utente, other.utente);
	}

}
