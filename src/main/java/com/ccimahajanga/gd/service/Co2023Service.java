package com.ccimahajanga.gd.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.ccimahajanga.gd.domain.Co2023;

public interface Co2023Service {
	public Iterable<Co2023> get(String q);
	public void save(Co2023 co2023);
	public void delete(List<Integer> idList);
	public void export(OutputStream outputStream) throws IOException;
	public void upload(MultipartFile file) throws IllegalStateException, IOException, InvalidFormatException;

}
