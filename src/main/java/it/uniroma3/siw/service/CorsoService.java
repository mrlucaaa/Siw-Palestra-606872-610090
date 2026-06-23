package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.repository.CorsoRepository;

@Service
@Transactional(readOnly = true)
public class CorsoService {
	private CorsoRepository corsoRepository;

	public CorsoService(CorsoRepository corsoRepository) {
		this.corsoRepository = corsoRepository;
	}
	
	public Iterable<Corso> findAll(){
		return this.corsoRepository.findAll();
	}
	
	public Corso findById(Long id) {
		return this.corsoRepository.findById(id).orElse(null);
	}
	
	public Corso findByIdWithIstruttoreAndUtenti(Long id) {
		return this.corsoRepository.findByIdWithIstruttoreAndUtenti(id).orElse(null);
	}
	
	@Transactional
	public void save(Corso corso) {
		this.corsoRepository.save(corso);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.corsoRepository.deleteById(id);
	}
	
	@Transactional
	public void update(Corso corsoNuovo) {
		Corso corsoVecchio = this.corsoRepository.findById(corsoNuovo.getId()).orElse(null);
		corsoVecchio.setNome(corsoNuovo.getNome());
		corsoVecchio.setDescrizione(corsoNuovo.getDescrizione());
		corsoVecchio.setDataOra(corsoNuovo.getDataOra());
		corsoVecchio.setCapienzaMax(corsoNuovo.getCapienzaMax());
		
	}
}
