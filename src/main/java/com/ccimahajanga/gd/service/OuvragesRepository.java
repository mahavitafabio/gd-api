package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Ouvrages;
public interface OuvragesRepository extends CrudRepository<Ouvrages, Integer>{ 
	List<Ouvrages> findByCodeOuvrages(String codeOuvrages);

}
