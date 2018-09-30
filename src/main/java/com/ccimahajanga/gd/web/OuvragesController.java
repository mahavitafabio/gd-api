package com.ccimahajanga.gd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccimahajanga.gd.domain.Ouvrages;
import com.ccimahajanga.gd.service.OuvragesRepository;

@RestController
public class OuvragesController {
	@Autowired
	private OuvragesRepository ouvragesRepositoryNew;
	@RequestMapping("/Ouvrages")
    public Iterable<Ouvrages> index() {
        return ouvragesRepositoryNew.findAll();
    }

}
