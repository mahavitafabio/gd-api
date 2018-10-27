package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Co2020;

public interface Co2020Repository extends CrudRepository<Co2020, Integer>{
	List<Co2020> findByProduitContaining(String q);

}
