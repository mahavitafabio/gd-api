package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Revue;


public interface RevueRepository extends CrudRepository<Revue, Integer>{ 
	List<Revue> findByTitreOuvragesContaining(String q); 
}
