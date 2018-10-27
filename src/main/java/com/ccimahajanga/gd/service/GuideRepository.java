package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Guide;


public interface GuideRepository extends CrudRepository<Guide, Integer>{ 
	List<Guide> findByTitreOuvragesContaining(String q);

}
