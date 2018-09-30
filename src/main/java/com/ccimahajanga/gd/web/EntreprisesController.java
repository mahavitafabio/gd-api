package com.ccimahajanga.gd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccimahajanga.gd.domain.Entreprises;
import com.ccimahajanga.gd.service.EntreprisesRepository;

@RestController
public class EntreprisesController {
	@Autowired
	private EntreprisesRepository entreprisesRepository;
	@RequestMapping("/enterprise")
    public Iterable<Entreprises> index() {
        return entreprisesRepository.findAll();
    }
}
