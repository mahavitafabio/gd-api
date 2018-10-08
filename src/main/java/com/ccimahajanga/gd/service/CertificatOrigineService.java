package com.ccimahajanga.gd.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.ccimahajanga.gd.domain.CertificatOrigine;

public interface CertificatOrigineService {
	public Iterable<CertificatOrigine> get();
	public void save(CertificatOrigine certificatOrigine);
	public void delete(List<Integer> idList);
	public void export(OutputStream outputStream) throws IOException;
}
