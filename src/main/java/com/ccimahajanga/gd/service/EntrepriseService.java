package com.ccimahajanga.gd.service;

import com.ccimahajanga.gd.domain.Entreprise;

public interface EntrepriseService {
	public Iterable<Entreprise> get();
	public void save(Entreprise entreprise);
}
