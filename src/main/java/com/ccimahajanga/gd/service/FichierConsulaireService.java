package com.ccimahajanga.gd.service;

import com.ccimahajanga.gd.domain.FichierConsulaire;

public interface FichierConsulaireService {
	public Iterable<FichierConsulaire> get();
	public void save(FichierConsulaire fichierConsulaire);
}
