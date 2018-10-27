package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Co2022;

public interface Co2022Repository extends CrudRepository<Co2022, Integer>{
	List<Co2022> findByProduitContaining(String q);

}
