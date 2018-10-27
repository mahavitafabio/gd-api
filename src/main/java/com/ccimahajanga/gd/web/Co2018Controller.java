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

import com.ccimahajanga.gd.domain.Co2018;
import com.ccimahajanga.gd.service.Co2018Service;


@RestController
@RequestMapping("/certificat18")
public class Co2018Controller {
	
	@Autowired
	private Co2018Service co2018Service;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Co2018> getCo2018(
    		@RequestParam(value = "q", required = false) String q) {
        return co2018Service.get(q);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCo2018(@RequestBody Co2018 co2018) {
		System.out.println(co2018);
		co2018Service.save(co2018);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCo2018(@RequestBody Co2018 co2018) {
		System.out.println(co2018);
		co2018Service.save(co2018);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCo2018(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		co2018Service.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCo2018(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=certificatOrigines18.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		co2018Service.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadCo2018(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		co2018Service.upload(file);
    }

}
