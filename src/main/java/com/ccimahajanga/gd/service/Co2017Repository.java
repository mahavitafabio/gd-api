package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Co2017;

public interface Co2017Repository extends CrudRepository<Co2017, Integer>{
	List<Co2017> findByProduitContaining(String q);

}
