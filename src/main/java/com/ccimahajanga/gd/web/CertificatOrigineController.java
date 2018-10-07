package com.ccimahajanga.gd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccimahajanga.gd.domain.CertificatOrigine;
import com.ccimahajanga.gd.service.CertificatOrigineService;


@RestController
@RequestMapping("/certificat")
public class CertificatOrigineController {
	
	@Autowired
	private CertificatOrigineService certificatOrigineService;
	
	@RequestMapping(method = RequestMethod.GET,
		    produces = {"application/json"})
    public Iterable<CertificatOrigine> getCertificatOrigines() {
        return certificatOrigineService.get();
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
	
}
