package com.ccimahajanga.gd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccimahajanga.gd.domain.Entreprise;
import com.ccimahajanga.gd.service.EntrepriseService;

@RestController
@RequestMapping("/enterprise")
public class EntreprisesController {
	
	@Autowired
	private EntrepriseService entrepriseService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Entreprise> getEntreprises() {
        return entrepriseService.get();
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
    public void postEntreprises(@RequestBody Entreprise entreprise) {
		System.out.println(entreprise);
		entrepriseService.save(entreprise);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putEntreprises(@RequestBody Entreprise entreprise) {
		System.out.println(entreprise);
		entrepriseService.save(entreprise);
    }
	
	
}
