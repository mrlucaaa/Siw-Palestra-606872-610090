package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Corso {
	private Long id;
	private String nome;
	private String descrizione;
	private Long capienzaMax;
	private LocalDateTime dataOra;
	
	public Corso(Long id, String nome, String descrizione, Long capienzaMax, LocalDateTime dataOra) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.capienzaMax = capienzaMax;
		this.dataOra = dataOra;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataOra, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(dataOra, other.dataOra) && Objects.equals(nome, other.nome);
	}
	
	
	
	
}
