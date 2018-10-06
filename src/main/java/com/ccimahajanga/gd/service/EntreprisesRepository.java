package com.ccimahajanga.gd.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccimahajanga.gd.domain.Entreprise;

public interface EntreprisesRepository extends CrudRepository<Entreprise, Integer > {
 List<Entreprise> findByNomEntreprise(String nomEntreprise);
}
