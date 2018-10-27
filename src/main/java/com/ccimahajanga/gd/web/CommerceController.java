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

import com.ccimahajanga.gd.domain.Commerce;
import com.ccimahajanga.gd.service.CommerceService;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
	
	@Autowired
	private CommerceService commerceService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Commerce> getCommerces(
    		@RequestParam(value = "q", required = false) String q) {
        return commerceService.get(q);
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCommerces(@RequestBody Commerce commerce) {
		System.out.println(commerce);
		commerceService.save(commerce);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCommerces(@RequestBody Commerce commerce) {
		System.out.println(commerce);
		commerceService.save(commerce);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCommerces(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		commerceService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCommerces(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=commerces.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		commerceService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadCommerces(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		commerceService.upload(file);
    }

}
