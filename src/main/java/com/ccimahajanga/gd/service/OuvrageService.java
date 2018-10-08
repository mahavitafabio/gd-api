package com.ccimahajanga.gd.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.ccimahajanga.gd.domain.Ouvrages;

public interface OuvrageService {
	public Iterable<Ouvrages> get();
	public void save(Ouvrages ouvrages);
	public void delete(List<Integer> idList);
	public void export(OutputStream outputStream) throws IOException;
}
