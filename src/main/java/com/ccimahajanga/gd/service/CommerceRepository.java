package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Commerce;


public interface CommerceRepository extends CrudRepository<Commerce, Integer >{
	List<Commerce> findByNomEntrepriseContaining(String q);

}
