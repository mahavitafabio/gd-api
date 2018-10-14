package com.ccimahajanga.gd.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccimahajanga.gd.domain.Ouvrages;
import com.ccimahajanga.gd.service.OuvrageService;

@RestController
@RequestMapping("/ouvrage")
public class OuvragesController {
	
	@Autowired
	private OuvrageService ouvrageService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Ouvrages> getOuvrage(
       @RequestParam(value = "q", required = false) String q) {
        return ouvrageService.get(q);
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
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadEntreprises(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		ouvrageService.upload(file);
    }

}
