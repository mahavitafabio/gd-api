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

import com.ccimahajanga.gd.domain.Guide;
import com.ccimahajanga.gd.service.GuideService;



@RestController
@RequestMapping("/guide")
public class GuideController {
	
	@Autowired
	private GuideService guideService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<Guide> getGuide(
       @RequestParam(value = "q", required = false) String q) {
        return guideService.get(q);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void postGuide(@RequestBody Guide guide) {
		System.out.println(guide);
		guideService.save(guide);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putGuide(@RequestBody Guide guide) {
		System.out.println(guide);
		guideService.save(guide);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteGuide(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		guideService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportGuide(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=guides.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		guideService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadGuide(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		guideService.upload(file);
    }

}
