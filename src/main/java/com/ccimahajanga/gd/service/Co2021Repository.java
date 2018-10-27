package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Co2021;

public interface Co2021Repository extends CrudRepository<Co2021, Integer>{
	List<Co2021> findByProduitContaining(String q);

}
