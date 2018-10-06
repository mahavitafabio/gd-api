package com.ccimahajanga.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccimahajanga.gd.domain.Entreprise;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

	@Autowired
	private EntreprisesRepository entreprisesRepository;
	
	@Override
	public Iterable<Entreprise> get() {
		// TODO Auto-generated method stub
		return entreprisesRepository.findAll();
	}

	@Override
	public void save(Entreprise entreprise) {
		// TODO Auto-generated method stub
		entreprisesRepository.save(entreprise);
	}
}
