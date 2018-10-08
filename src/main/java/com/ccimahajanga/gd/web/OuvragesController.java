package com.ccimahajanga.gd.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteOuvrage(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		ouvrageService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportOuvrage(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=ouvrages.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		ouvrageService.export(response.getOutputStream());
    }

}
