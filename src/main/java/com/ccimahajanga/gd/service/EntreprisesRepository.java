package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Entreprises;

public interface EntreprisesRepository extends CrudRepository<Entreprises, Integer > {
 List<Entreprises> findByNomEntreprise(String nomEntreprise);
}
