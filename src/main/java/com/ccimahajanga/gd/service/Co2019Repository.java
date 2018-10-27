package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Co2019;

public interface Co2019Repository extends CrudRepository<Co2019, Integer>{
	List<Co2019> findByProduitContaining(String q);

}
