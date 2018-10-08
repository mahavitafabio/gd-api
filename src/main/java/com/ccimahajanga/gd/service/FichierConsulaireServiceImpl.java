package com.ccimahajanga.gd.service;

import java.awt.Color;
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

import com.ccimahajanga.gd.domain.FichierConsulaire;

@Service
public class FichierConsulaireServiceImpl implements FichierConsulaireService { 
	
	@Autowired
	private FichierConsulaireRepository fichierConsulaireRepository;
	
	@Override
	public Iterable<FichierConsulaire> get() {
		// TODO Auto-generated method stub
		return fichierConsulaireRepository.findAll();
	}

	@Override
	public void save(FichierConsulaire fichierConsulaire) {
		// TODO Auto-generated method stub
		fichierConsulaireRepository.save(fichierConsulaire);
	}

	@Override
	public void delete(List<Integer> idList) {
		for(Integer id : idList) {
			fichierConsulaireRepository.deleteById(id);
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
		cell.setCellValue("CONSULAIRE_ID");
		cell = header.createCell(1);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("RAISON_SOCIAL");
		cell = header.createCell(2);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("ADRESSE");
		cell = header.createCell(3);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("CAPITAL");
		cell = header.createCell(4);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("DATE_DE_CREATION");
		cell = header.createCell(5);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("EMAIL");
		cell = header.createCell(6);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("FORME_JURIDIQUE");
		cell = header.createCell(7);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NUMERO_FISCAL");
		cell = header.createCell(8);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NUMERO_IDENTITE");
		cell = header.createCell(9);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NUMERO_REGISTRE");
		cell = header.createCell(10);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("SIGLE");
		cell = header.createCell(11);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("DATE_DE_MODIFICATION");
		
		Iterable<FichierConsulaire> fichierConsulaireList = fichierConsulaireRepository.findAll();
		int i = 1;
		for (FichierConsulaire fichierConsulaire : fichierConsulaireList) {
			Row row = sheet.createRow(i++);
			cell = row.createCell(0);
			cell.setCellValue(fichierConsulaire.getConsulaireId());
			cell = row.createCell(1);
			cell.setCellValue(fichierConsulaire.getRaisonSocial());
			cell = row.createCell(2);
			cell.setCellValue(fichierConsulaire.getAdresse());
			cell = row.createCell(3);
			cell.setCellValue(fichierConsulaire.getCapital());
			cell = row.createCell(4);
			cell.setCellValue(fichierConsulaire.getCreatedDate());
			cell = row.createCell(5);
			cell.setCellValue(fichierConsulaire.getEmail());
			cell = row.createCell(6);
			cell.setCellValue(fichierConsulaire.getFormeJuridique());
			cell = row.createCell(7);
			cell.setCellValue(fichierConsulaire.getNumeroFiscal());
			cell = row.createCell(8);
			cell.setCellValue(fichierConsulaire.getNumeroIdentite());
			cell = row.createCell(9);
			cell.setCellValue(fichierConsulaire.getNumeroRegistre());
			cell = row.createCell(10);
			cell.setCellValue(fichierConsulaire.getSigle());
			cell = row.createCell(11);
			cell.setCellValue(fichierConsulaire.getUpdatedDate());
		}
		System.out.println("created worksheet");
		
		workbook.write(outputStream);
		System.out.println("wrote to stream");
		workbook.close();
		outputStream.flush();
		outputStream.close();
		
	}

}
