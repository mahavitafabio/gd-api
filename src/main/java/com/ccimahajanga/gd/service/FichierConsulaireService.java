package com.ccimahajanga.gd.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.ccimahajanga.gd.domain.FichierConsulaire;

public interface FichierConsulaireService {
	public Iterable<FichierConsulaire> get(String q);
	public void save(FichierConsulaire fichierConsulaire);
	public void delete(List<Integer> idList);
	public void export(OutputStream outputStream) throws IOException, ParseException;
	public void upload(MultipartFile file) throws IllegalStateException, IOException, InvalidFormatException;
}
