package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Chervice;

public interface CherviceRepository extends CrudRepository<Chervice, Integer > {
	List<Chervice> findByNomEntrepriseContaining(String q);

}
