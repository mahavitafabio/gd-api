package com.ccimahajanga.gd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccimahajanga.gd.domain.FichierConsulaire;
import com.ccimahajanga.gd.service.FichierConsulaireRepository;

@RestController
public class FichierConsulaireController {
	@Autowired
	private FichierConsulaireRepository fichierConsulaireRepositoryNew;
	@RequestMapping("/FichierConsulaire")
    public Iterable<FichierConsulaire> index() {
        return fichierConsulaireRepositoryNew.findAll();
    }
}
