package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Co2023;

public interface Co2023Repository extends CrudRepository<Co2023, Integer>{
	List<Co2023> findByProduitContaining(String q);

}
