package com.ccimahajanga.gd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccimahajanga.gd.domain.Ouvrages;
import com.ccimahajanga.gd.service.OuvrageService;

@RestController
@RequestMapping("/ouvrage")
public class OuvragesController {
	
	@Autowired
	private OuvrageService ouvrageService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Ouvrages> getOuvrage() {
        return ouvrageService.get();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void postOuvrage(@RequestBody Ouvrages ouvrages) {
		System.out.println(ouvrages);
		ouvrageService.save(ouvrages);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putOuvrage(@RequestBody Ouvrages ouvrages) {
		System.out.println(ouvrages);
		ouvrageService.save(ouvrages);
    }

}
