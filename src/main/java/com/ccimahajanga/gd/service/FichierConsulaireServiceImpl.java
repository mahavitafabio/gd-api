package com.ccimahajanga.gd.service;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public void upload(MultipartFile multipart) throws IllegalStateException, IOException, InvalidFormatException {
		List<String> headers 
		= new ArrayList<>(Arrays.asList("CONSULAIRE_ID",
				"RAISON_SOCIAL", "ADRESSE", "CAPITAL",
				"DATE_DE_CREATION", "EMAIL", "FORME_JURIDIQUE", "NUMERO_FISCAL", "NUMERO_IDENTITE", "NUMERO_REGISTRE",
				"SIGLE", "DATE_DE_MODIFICATION"));
		DataFormatter dataFormatter = new DataFormatter();
		InputStream is = multipart.getInputStream();
		Workbook workbook = WorkbookFactory.create(is);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		Row row = rowIterator.next();
		boolean isInsert = this.isInsert(row, headers.get(0));
		
		this.validateHeaders(row, headers, isInsert);
		//this.validateData();
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            //validateData(row);
            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            FichierConsulaire fich = new FichierConsulaire();
            Cell cell = cellIterator.next();
            String cellValue;
            if (!isInsert) {
                cellValue = dataFormatter.formatCellValue(cell);
                fich.setConsulaireId(Integer.parseInt(cellValue));
                cell = cellIterator.next();
            }
            cellValue = dataFormatter.formatCellValue(cell);
            fich.setRaisonSocial(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            fich.setAdresse(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	fich.setCapital(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            Date dateValue = cell.getDateCellValue();
            if (dateValue != null || !"".equals(dateValue)) {
            	fich.setCreatedDate(dateValue);
            	cell = cellIterator.next();
            }
            
            cellValue = dataFormatter.formatCellValue(cell);
            fich.setEmail(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            fich.setFormeJuridique(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	fich.setNumeroFiscal(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	fich.setNumeroIdentite(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	fich.setNumeroRegistre(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            fich.setSigle(cellValue);
            
            //cell = cellIterator.next();
            //cellValue = dataFormatter.formatCellValue(cell);
            //if (cellValue != null || !"".equals(cellValue)) {
            	//fich.setUpdatedDate(Date.parse(cellValue));
            //}
            this.save(fich);
        }
	}
	
//	private void validateData(Row row) {
//		DataFormatter dataFormatter = new DataFormatter();
//		Iterator<Cell> cellIterator = row.cellIterator();
//		List<String> dataTypes 
//			= new ArrayList<>(Arrays.asList("NUMBER/NULL",
//				"STRING", "STRING", "NUMBER", "STRING"));
//		Iterator<String> dataTypeIterator = dataTypes.iterator();
//        while (cellIterator.hasNext()) {
//            Cell cell = cellIterator.next();
//            String cellValue = dataFormatter.formatCellValue(cell);
//            System.out.println(cellValue + "\t");
//            String dataType = dataTypeIterator.next();
//            if("NUMBER".equalsIgnoreCase(dataType)) {
//            	try {
//            		Integer.getInteger(cellValue);
//            	} catch (Exception e) {
//            		throw new IllegalArgumentException("This column accept only numbers. Invalid value: " + cellValue);
//            	}
//            	
//            }
//            if("NUMBER/NULL".equalsIgnoreCase(dataType) && (cellValue != null && !"".equalsIgnoreCase(cellValue.trim()))) {
//            	try {
//            		Integer.getInteger(cellValue);
//            	} catch (Exception e) {
//            		throw new IllegalArgumentException("This column accept only numbers. Invalid value: " + cellValue);
//            	}
//            	
//            }
//        }
//        System.out.println("Data validated");
//		
//	}
	
	private boolean isInsert(Row row, String idHeader) {
		DataFormatter dataFormatter = new DataFormatter();
		Iterator<Cell> cellIterator = row.cellIterator();
		Cell cell = cellIterator.next();
		String cellValue = dataFormatter.formatCellValue(cell);
		if(cellValue.equals(idHeader)) {
			return false;
        }
		return true;
	}
	
	private void validateHeaders(Row row, List<String> headers, boolean isInsert) {
		DataFormatter dataFormatter = new DataFormatter();
		Iterator<Cell> cellIterator = row.cellIterator();
		Iterator<String> headerIterator = headers.iterator();
		if (isInsert) {
			headerIterator.next();
		}
        while (cellIterator.hasNext()) {
        	Cell cell = cellIterator.next();
            String header = headerIterator.next();
            String cellValue = dataFormatter.formatCellValue(cell);
            if(!cellValue.equals(header)) {
            	throw new IllegalArgumentException("Invalid header " + cellValue);
            }
        }
        System.out.println("Headers validated");
		
	}

}
