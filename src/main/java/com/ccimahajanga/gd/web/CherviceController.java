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

import com.ccimahajanga.gd.domain.Chervice;
import com.ccimahajanga.gd.service.CherviceService;

@RestController
@RequestMapping("/chervice")
public class CherviceController {
	
	@Autowired
	private CherviceService cherviceService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Chervice> getServices(
    		@RequestParam(value = "q", required = false) String q) {
        return cherviceService.get(q);
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
    public void postServices(@RequestBody Chervice chervice) {
		System.out.println(chervice);
		cherviceService.save(chervice);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putServices(@RequestBody Chervice chervice) {
		System.out.println(chervice);
		cherviceService.save(chervice);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteService(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		cherviceService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportService(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=services.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		cherviceService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadService(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		cherviceService.upload(file);
    }

}
