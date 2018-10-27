package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Co2018;

public interface Co2018Repository extends CrudRepository<Co2018, Integer>{
	List<Co2018> findByProduitContaining(String q);

}
