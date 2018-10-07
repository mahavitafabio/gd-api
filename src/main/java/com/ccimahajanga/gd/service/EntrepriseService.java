package com.ccimahajanga.gd.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.ccimahajanga.gd.domain.Entreprise;

public interface EntrepriseService {
	public Iterable<Entreprise> get();
	public void save(Entreprise entreprises);
	public void delete(List<Integer> idList);
	public void export(OutputStream outputStream) throws IOException;
}
