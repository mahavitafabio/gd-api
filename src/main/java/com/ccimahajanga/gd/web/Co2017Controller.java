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

import com.ccimahajanga.gd.domain.Co2017;
import com.ccimahajanga.gd.service.Co2017Service;


@RestController
@RequestMapping("/certificat17")
public class Co2017Controller {
	
	@Autowired
	private Co2017Service co2017Service;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Co2017> getCo2017(
    		@RequestParam(value = "q", required = false) String q) {
        return co2017Service.get(q);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCo2017(@RequestBody Co2017 co2017) {
		System.out.println(co2017);
		co2017Service.save(co2017);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCo2017(@RequestBody Co2017 co2017) {
		System.out.println(co2017);
		co2017Service.save(co2017);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCo2017(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		co2017Service.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCo2017(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=certificatOrigines17.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		co2017Service.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadCo2017(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		co2017Service.upload(file);
    }

}
