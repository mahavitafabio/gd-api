package com.ccimahajanga.gd.service;

import com.ccimahajanga.gd.domain.Ouvrages;

public interface OuvrageService {
	public Iterable<Ouvrages> get();
	public void save(Ouvrages ouvrages);
}
