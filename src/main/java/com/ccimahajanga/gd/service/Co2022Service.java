package com.ccimahajanga.gd.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.ccimahajanga.gd.domain.Co2022;

public interface Co2022Service {
	public Iterable<Co2022> get(String q);
	public void save(Co2022 co2022);
	public void delete(List<Integer> idList);
	public void export(OutputStream outputStream) throws IOException;
	public void upload(MultipartFile file) throws IllegalStateException, IOException, InvalidFormatException;

}
