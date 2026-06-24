package it.uniroma3.siw.dto;

import java.time.LocalDateTime;

/**
 * Data Transfer Object per la classe Corso.
 * Questa classe spezza le dipendenze cicliche rimuovendo i riferimenti ad
 * altri oggetti complessi (es. Istruttore, Liste di Prenotazioni) e portando
 * fuori solo i dati "primitivi" che ci interessano restituire in JSON.
 */
public class CorsoDTO {
	
	private Long id;
	private String nome;
	private String descrizione;
	private Long capienzaMax;
	private LocalDateTime dataOra;
	
	// Al posto dell'intero oggetto Istruttore, passiamo solo le informazioni necessarie
	private Long istruttoreId;
	private String istruttoreNome;
	private String istruttoreCognome;
	
	// Costruttore vuoto necessario per Jackson
	public CorsoDTO() {
	}

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getCapienzaMax() {
		return capienzaMax;
	}

	public void setCapienzaMax(Long capienzaMax) {
		this.capienzaMax = capienzaMax;
	}

	public LocalDateTime getDataOra() {
		return dataOra;
	}

	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}

	public Long getIstruttoreId() {
		return istruttoreId;
	}

	public void setIstruttoreId(Long istruttoreId) {
		this.istruttoreId = istruttoreId;
	}

	public String getIstruttoreNome() {
		return istruttoreNome;
	}

	public void setIstruttoreNome(String istruttoreNome) {
		this.istruttoreNome = istruttoreNome;
	}

	public String getIstruttoreCognome() {
		return istruttoreCognome;
	}

	public void setIstruttoreCognome(String istruttoreCognome) {
		this.istruttoreCognome = istruttoreCognome;
	}
	
}
