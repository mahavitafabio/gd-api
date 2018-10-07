package com.ccimahajanga.gd.service;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccimahajanga.gd.domain.Entreprise;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

	@Autowired
	private EntreprisesRepository entreprisesRepository;
	
	@Override
	public Iterable<Entreprise> get() {
		// TODO Auto-generated method stub
		return entreprisesRepository.findAll();
	}

	@Override
	public void save(Entreprise entreprise) {
		// TODO Auto-generated method stub
		entreprisesRepository.save(entreprise);
	}

	@Override
	public void delete(List<Integer> idList) {
		for(Integer id : idList) {
			entreprisesRepository.deleteById(id);
		}
	}

	@Override
	public void export(OutputStream outputStream) throws IOException {
		SXSSFWorkbook workbook = null;
		SXSSFSheet sheet = null;
		workbook = new SXSSFWorkbook();
		sheet = workbook.createSheet();
		
		CellStyle headerStyle = workbook.createCellStyle();
		XSSFColor headerColor = new XSSFColor(new Color(63,81,181));
		XSSFColor whiteColor = new XSSFColor(Color.WHITE);
		Font font = workbook.createFont();
		font.setBold(true);
		font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());

		CellStyle wrapStyle = workbook.createCellStyle();
		wrapStyle.setWrapText(true);
		headerStyle.setFillForegroundColor(headerColor.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setBottomBorderColor(whiteColor.getIndex());
		headerStyle.setTopBorderColor(whiteColor.getIndex());
		headerStyle.setLeftBorderColor(whiteColor.getIndex());
		headerStyle.setRightBorderColor(whiteColor.getIndex());
		headerStyle.setBorderBottom(BorderStyle.THICK);
		headerStyle.setBorderLeft(BorderStyle.THICK);
		headerStyle.setBorderRight(BorderStyle.THICK);
		headerStyle.setBorderTop(BorderStyle.THICK);
		headerStyle.setFont(font);
		
		Row header = sheet.createRow(0);
		Cell cell = header.createCell(0);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("ENTREPRISE_ID");
		cell = header.createCell(1);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NOM_ENTREPRISE");
		cell = header.createCell(2);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("ADRESSE_ENTREPRISE");
		cell = header.createCell(3);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("CONTACT");
		cell = header.createCell(4);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NOM_RESPONSABLE");
		
		Iterable<Entreprise> entrepriseList = entreprisesRepository.findAll();
		int i = 1;
		for (Entreprise entreprise : entrepriseList) {
			Row row = sheet.createRow(i++);
			cell = row.createCell(0);
			cell.setCellValue(entreprise.getEntreprisesId());
			cell = row.createCell(1);
			cell.setCellValue(entreprise.getNomEntreprise());
			cell = row.createCell(2);
			cell.setCellValue(entreprise.getAdresseEntreprise());
			cell = row.createCell(3);
			cell.setCellValue(entreprise.getContact());
			cell = row.createCell(4);
			cell.setCellValue(entreprise.getNomResponsable());
		}
		System.out.println("created worksheet");
		
		workbook.write(outputStream);
		System.out.println("wrote to stream");
		workbook.close();
		outputStream.flush();
		outputStream.close();
	}
}
