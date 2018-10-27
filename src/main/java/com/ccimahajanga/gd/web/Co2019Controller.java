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

import com.ccimahajanga.gd.domain.Co2019;
import com.ccimahajanga.gd.service.Co2019Service;


@RestController
@RequestMapping("/certificat19")
public class Co2019Controller {
	
	@Autowired
	private Co2019Service co2019Service;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Co2019>getCo2019(
    		@RequestParam(value = "q", required = false) String q) {
        return co2019Service.get(q);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCo2019(@RequestBody Co2019 co2019) {
		System.out.println(co2019);
		co2019Service.save(co2019);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCo2019(@RequestBody Co2019 co2019) {
		System.out.println(co2019);
		co2019Service.save(co2019);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCo2019(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		co2019Service.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCo2019(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=certificatOrigines19.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		co2019Service.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadCo2019(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		co2019Service.upload(file);
    }

}
