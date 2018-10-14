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

import com.ccimahajanga.gd.domain.CertificatOrigine;
import com.ccimahajanga.gd.service.CertificatOrigineService;


@RestController
@RequestMapping("/certificat")
public class CertificatOrigineController {
	
	@Autowired
	private CertificatOrigineService certificatOrigineService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<CertificatOrigine> getCertificatOrigines(
    		@RequestParam(value = "q", required = false) String q) {
        return certificatOrigineService.get(q);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void postCertificatOrigines(@RequestBody CertificatOrigine certificatOrigine) {
		System.out.println(certificatOrigine);
		certificatOrigineService.save(certificatOrigine);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putCertificatOrigines(@RequestBody CertificatOrigine certificatOrigine) {
		System.out.println(certificatOrigine);
		certificatOrigineService.save(certificatOrigine);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCertificatOrigines(@RequestBody List<Integer> idList) {
		System.out.println(idList);
		certificatOrigineService.delete(idList);
    }
	
	@RequestMapping(value="/export", method = RequestMethod.GET)
    public void exportCertificatOrigines(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment; filename=certificatOrigines.xlsx");
		response.addHeader("Cache-Control", "no-cache");
		certificatOrigineService.export(response.getOutputStream());
    }
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public void uploadEntreprises(@RequestParam("data") MultipartFile file) throws IOException, EncryptedDocumentException, InvalidFormatException {
		certificatOrigineService.upload(file);
    }
	
}
