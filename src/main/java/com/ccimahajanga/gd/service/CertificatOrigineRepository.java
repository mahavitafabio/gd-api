package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.CertificatOrigine;

public interface CertificatOrigineRepository extends CrudRepository<CertificatOrigine, Integer>{
	List<CertificatOrigine> findByProduitContaining(String q);

}
