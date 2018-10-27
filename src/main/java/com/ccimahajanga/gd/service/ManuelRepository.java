package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Manuel;

public interface ManuelRepository extends CrudRepository<Manuel, Integer>{ 
	List<Manuel> findByTitreOuvragesContaining(String q);

}
