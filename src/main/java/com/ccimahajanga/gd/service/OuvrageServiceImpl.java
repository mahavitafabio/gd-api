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

import com.ccimahajanga.gd.domain.Ouvrages;

@Service
public class OuvrageServiceImpl implements OuvrageService {
	
	@Autowired
	private OuvragesRepository ouvragesRepository;
	
	@Override
	public Iterable<Ouvrages> get() {
		// TODO Auto-generated method stub
		return ouvragesRepository.findAll();
	}

	@Override
	public void save(Ouvrages ouvrages) {
		// TODO Auto-generated method stub
		ouvragesRepository.save(ouvrages);
	}

	@Override
	public void delete(List<Integer> idList) {
		for(Integer id : idList) {
			ouvragesRepository.deleteById(id);
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
		cell.setCellValue("OUVRAGE_ID");
		cell = header.createCell(1);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("CODE_OUVRAGE");
		cell = header.createCell(2);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("COMMENTAIRE");
		cell = header.createCell(3);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("DOMAINE");
		cell = header.createCell(4);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("ETAGE");
		cell = header.createCell(5);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("NOMBRE_EXEMPLAIRE");
		cell = header.createCell(6);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("RANGER");
		cell = header.createCell(7);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("TITRE_OUVRAGE");
		
		Iterable<Ouvrages> ouvragesList = ouvragesRepository.findAll();
		int i = 1;
		for (Ouvrages ouvrages : ouvragesList) {
			Row row = sheet.createRow(i++);
			cell = row.createCell(0);
			cell.setCellValue(ouvrages.getOuvrageId());
			cell = row.createCell(1);
			cell.setCellValue(ouvrages.getCodeOuvrages());
			cell = row.createCell(2);
			cell.setCellValue(ouvrages.getCommentaire());
			cell = row.createCell(3);
			cell.setCellValue(ouvrages.getDomaines());
			cell = row.createCell(4);
			cell.setCellValue(ouvrages.getEtage());
			cell = row.createCell(5);
			cell.setCellValue(ouvrages.getNombreExemplaire());
			cell = row.createCell(6);
			cell.setCellValue(ouvrages.getRanger());
			cell = row.createCell(7);
			cell.setCellValue(ouvrages.getTitreOuvrages());
		}
		System.out.println("created worksheet");
		
		workbook.write(outputStream);
		System.out.println("wrote to stream");
		workbook.close();
		outputStream.flush();
		outputStream.close();
		
	}

}
