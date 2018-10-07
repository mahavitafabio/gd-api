package com.ccimahajanga.gd.service;

import com.ccimahajanga.gd.domain.CertificatOrigine;

public interface CertificatOrigineService {
	public Iterable<CertificatOrigine> get();
	public void save(CertificatOrigine certificatOrigine);
}
