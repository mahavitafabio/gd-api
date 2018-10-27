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

import com.ccimahajanga.gd.domain.Autres;
import com.ccimahajanga.gd.service.AutresService;



@RestController
@RequestMapping("/autres")
public class AutresController {
	
	@Autowired
	private AutresService autresService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Autres> getAutres(
       @RequestParam(value = "q", required = false) String q) {
        return autresService.get(q);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void postAutres(@RequestBody Autres autres) {
		System.out.println(autres);
		autresService.save(autres);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putAutres(@RequestBody Autres autres) {
		System.out.println(autres);
		autresService.save(autres);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteAutres(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		autresService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportAutres(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=ouvrages.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		autresService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadAutres(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		autresService.upload(file);
    }

}
