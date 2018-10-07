package com.ccimahajanga.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccimahajanga.gd.domain.Ouvrages;

@Service
public class OuvrageServiceImpl implements OuvrageService {
	
	@Autowired
	private OuvragesRepository ouvragesRepository;
	
	@Override
	public Iterable<Ouvrages> get() {
		// TODO Auto-generated method stub
		return ouvragesRepository.findAll();
	}

	@Override
	public void save(Ouvrages ouvrages) {
		// TODO Auto-generated method stub
		ouvragesRepository.save(ouvrages);
	}

}
