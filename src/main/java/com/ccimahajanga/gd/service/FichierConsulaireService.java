package com.ccimahajanga.gd.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.ccimahajanga.gd.domain.FichierConsulaire;

public interface FichierConsulaireService {
	public Iterable<FichierConsulaire> get();
	public void save(FichierConsulaire fichierConsulaire);
	public void delete(List<Integer> idList);
	public void export(OutputStream outputStream) throws IOException;
}
