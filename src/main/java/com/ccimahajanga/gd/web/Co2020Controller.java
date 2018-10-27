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

import com.ccimahajanga.gd.domain.Co2020;
import com.ccimahajanga.gd.service.Co2020Service;


@RestController
@RequestMapping("/certificat20")
public class Co2020Controller {
	
	@Autowired
	private Co2020Service co2020Service;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Co2020> getCo2020(
    		@RequestParam(value = "q", required = false) String q) {
        return co2020Service.get(q);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCo2020(@RequestBody Co2020 co2020) {
		System.out.println(co2020);
		co2020Service.save(co2020);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCo2020(@RequestBody Co2020 co2020) {
		System.out.println(co2020);
		co2020Service.save(co2020);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCo2020(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		co2020Service.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCo2020(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=certificatOrigines20.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		co2020Service.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadCo2020(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		co2020Service.upload(file);
    }

}
