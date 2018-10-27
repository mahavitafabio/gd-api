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

import com.ccimahajanga.gd.domain.FichierConsulaire;
import com.ccimahajanga.gd.service.FichierConsulaireService;

@RestController
@RequestMapping("/fichier-consulaire")
public class FichierConsulaireController {
	
	@Autowired
	private FichierConsulaireService fichierConsulaireService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<FichierConsulaire> getFichierConsulaires(
    		@RequestParam(value = "q", required = false) String q) {	
        return fichierConsulaireService.get(q);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void postFichierConsulaires(@RequestBody FichierConsulaire fichierConsulaire) {
		System.out.println(fichierConsulaire);
		fichierConsulaireService.save(fichierConsulaire);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putFichierConsulaires(@RequestBody FichierConsulaire fichierConsulaire) {
		System.out.println(fichierConsulaire);
		fichierConsulaireService.save(fichierConsulaire);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteFichierConsulaires(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		fichierConsulaireService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportFichierConsulaires(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=fichierConsulaires.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		fichierConsulaireService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadFichierConsulaires(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		fichierConsulaireService.upload(file);
    }
}
