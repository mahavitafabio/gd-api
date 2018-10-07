package com.ccimahajanga.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccimahajanga.gd.domain.FichierConsulaire;

@Service
public class FichierConsulaireServiceImpl implements FichierConsulaireService { 
	
	@Autowired
	private FichierConsulaireRepository fichierConsulaireRepository;
	
	@Override
	public Iterable<FichierConsulaire> get() {
		// TODO Auto-generated method stub
		return fichierConsulaireRepository.findAll();
	}

	@Override
	public void save(FichierConsulaire fichierConsulaire) {
		// TODO Auto-generated method stub
		fichierConsulaireRepository.save(fichierConsulaire);
	}

}
