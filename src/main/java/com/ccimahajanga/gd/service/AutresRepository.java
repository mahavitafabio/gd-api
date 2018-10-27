package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Autres;


public interface AutresRepository extends CrudRepository<Autres, Integer>{ 
	List<Autres> findByTitreOuvragesContaining(String q); 

}
