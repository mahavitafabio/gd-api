package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.FichierConsulaire;

public interface FichierConsulaireRepository extends CrudRepository<FichierConsulaire, Integer>{
	List<FichierConsulaire> findByNumeroRegistre(Integer NumeroRegistre);

}
