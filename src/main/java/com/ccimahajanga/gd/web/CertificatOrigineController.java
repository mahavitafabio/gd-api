package com.ccimahajanga.gd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccimahajanga.gd.domain.CertificatOrigine;
import com.ccimahajanga.gd.service.CertificatOrigineRepository;


@RestController
public class CertificatOrigineController {
	@Autowired
	private CertificatOrigineRepository certificatOrigineRepository;
	@RequestMapping("/certificat")
    public Iterable<CertificatOrigine> index() {
        return certificatOrigineRepository.findAll();
	}
}
