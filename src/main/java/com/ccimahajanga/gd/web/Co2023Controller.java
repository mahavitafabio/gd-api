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

import com.ccimahajanga.gd.domain.Co2023;
import com.ccimahajanga.gd.service.Co2023Service;


@RestController
@RequestMapping("/certificat23")
public class Co2023Controller {
	
	@Autowired
	private Co2023Service co2023Service;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Co2023> getCo2023(
    		@RequestParam(value = "q", required = false) String q) {
        return co2023Service.get(q);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCo2023(@RequestBody Co2023 co2023) {
		System.out.println(co2023);
		co2023Service.save(co2023);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCo2023(@RequestBody Co2023 co2023) {
		System.out.println(co2023);
		co2023Service.save(co2023);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCo2023(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		co2023Service.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCo2023(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=certificatOrigines23.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		co2023Service.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadCo2023(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		co2023Service.upload(file);
    }

}
