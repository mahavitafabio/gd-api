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

import com.ccimahajanga.gd.domain.Co2021;
import com.ccimahajanga.gd.service.Co2021Service;


@RestController
@RequestMapping("/certificat21")
public class Co2021Controller {
	
	@Autowired
	private Co2021Service co2021Service;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Co2021> getCo2021(
    		@RequestParam(value = "q", required = false) String q) {
        return co2021Service.get(q);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCo2021(@RequestBody Co2021 co2021) {
		System.out.println(co2021);
		co2021Service.save(co2021);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCo2021(@RequestBody Co2021 co2021) {
		System.out.println(co2021);
		co2021Service.save(co2021);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCo2021(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		co2021Service.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCo2021(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=certificatOrigines21.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		co2021Service.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadCo2021(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		co2021Service.upload(file);
    }

}
