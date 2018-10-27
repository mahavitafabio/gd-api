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

import com.ccimahajanga.gd.domain.Revue;
import com.ccimahajanga.gd.service.RevueService;



@RestController
@RequestMapping("/revue")
public class RevueController {
	
	@Autowired
	private RevueService revueService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Revue> getRevu(
       @RequestParam(value = "q", required = false) String q) {
        return revueService.get(q);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void postRevu(@RequestBody Revue revue) {
		System.out.println(revue);
		revueService.save(revue);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putRevu(@RequestBody Revue revue) {
		System.out.println(revue);
		revueService.save(revue);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteRevu(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		revueService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportRevu(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=ouvrages.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		revueService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadRevu(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		revueService.upload(file);
    }

}
