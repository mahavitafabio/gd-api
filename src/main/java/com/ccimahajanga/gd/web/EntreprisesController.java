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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteEntreprises(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		entrepriseService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportEntreprises(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=entreprises.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		entrepriseService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadEntreprises(MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		entrepriseService.upload(file);
    }
}
