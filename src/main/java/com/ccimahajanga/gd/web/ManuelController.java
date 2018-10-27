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

import com.ccimahajanga.gd.domain.Manuel;
import com.ccimahajanga.gd.service.ManuelService;



@RestController
@RequestMapping("/manuel")
public class ManuelController {
	
	@Autowired
	private ManuelService manuelService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Manuel> getManuels(
       @RequestParam(value = "q", required = false) String q) {
        return manuelService.get(q);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void postManuels(@RequestBody Manuel manuel) {
		System.out.println(manuel);
		manuelService.save(manuel);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putManuels(@RequestBody Manuel manuel) {
		System.out.println(manuel);
		manuelService.save(manuel);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteManuels(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		manuelService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportManuels(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=ouvrages.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		manuelService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadManuels(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		manuelService.upload(file);
    }

}
