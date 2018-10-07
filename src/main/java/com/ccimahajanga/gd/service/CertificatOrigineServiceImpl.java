package com.ccimahajanga.gd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccimahajanga.gd.domain.CertificatOrigine;

@Service
public class CertificatOrigineServiceImpl implements CertificatOrigineService {

	@Autowired
	private CertificatOrigineRepository certificatOrigineRepository;
	
	@Override
	public Iterable<CertificatOrigine> get() {
		// TODO Auto-generated method stub
		return certificatOrigineRepository.findAll();
	}

	@Override
	public void save(CertificatOrigine certificatOrigine) {
		// TODO Auto-generated method stub
		certificatOrigineRepository.save(certificatOrigine);
	}
}
