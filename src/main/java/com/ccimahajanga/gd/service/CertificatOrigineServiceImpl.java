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

import com.ccimahajanga.gd.domain.CertificatOrigine;

@Service
public class CertificatOrigineServiceImpl implements CertificatOrigineService {

	@Autowired
	private CertificatOrigineRepository certificatOrigineRepository;
	
	@Override
	public Iterable<CertificatOrigine> get() {
		// TODO Auto-generated method stub
		return certificatOrigineRepository.findAll();
	}

	@Override
	public void save(CertificatOrigine certificatOrigine) {
		// TODO Auto-generated method stub
		certificatOrigineRepository.save(certificatOrigine);
	}

	@Override
	public void delete(List<Integer> idList) {
		for(Integer id : idList) {
			certificatOrigineRepository.deleteById(id);
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
		cell.setCellValue("CERTIFICAT_ORIGINE_ID");
		cell = header.createCell(1);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NUMERO");
		cell = header.createCell(2);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("DATE");
		cell = header.createCell(3);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NOM_ENTREPRISE");
		cell = header.createCell(4);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("ADRESSE");
		cell = header.createCell(5);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("DESTINATION");
		cell = header.createCell(6);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("PRODUIT");
		cell = header.createCell(7);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("QUANTITE_EXPORTE");
		cell = header.createCell(8);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("UNITE");
		cell = header.createCell(9);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NOMBRE_DE_CONTENEUR");
		cell = header.createCell(10);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("PRIX_UNITAIRE");
		cell = header.createCell(11);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("MONTANT");
		
		Iterable<CertificatOrigine> certificatOrigineList = certificatOrigineRepository.findAll();
		int i = 1;
		for (CertificatOrigine certificatOrigine : certificatOrigineList) {
			Row row = sheet.createRow(i++);
			cell = row.createCell(0);
			cell.setCellValue(certificatOrigine.getCertificatId());
			cell = row.createCell(1);
			cell.setCellValue(certificatOrigine.getNumero());
			cell = row.createCell(2);
			cell.setCellValue(certificatOrigine.getDate());
			cell = row.createCell(3);
			cell.setCellValue(certificatOrigine.getNomEntreprise());
			cell = row.createCell(4);
			cell.setCellValue(certificatOrigine.getAdresse());
			cell = row.createCell(5);
			cell.setCellValue(certificatOrigine.getDestination());
			cell = row.createCell(6);
			cell.setCellValue(certificatOrigine.getProduit());
			cell = row.createCell(7);
			cell.setCellValue(certificatOrigine.getQuantiteExporte());
			cell = row.createCell(8);
			cell.setCellValue(certificatOrigine.getUnite());
			cell = row.createCell(9);
			cell.setCellValue(certificatOrigine.getNombreConteneur());
			cell = row.createCell(10);
			cell.setCellValue(certificatOrigine.getPrixUnitaire());
			cell = row.createCell(11);
			cell.setCellValue(certificatOrigine.getMontant());
		}
		System.out.println("created worksheet");
		
		workbook.write(outputStream);
		System.out.println("wrote to stream");
		workbook.close();
		outputStream.flush();
		outputStream.close();
		
	}
}
