package com.ccimahajanga.gd.service;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.ccimahajanga.gd.domain.Co2017;


@Service
public class Co2017ServiceImpl implements Co2017Service {

	@Autowired
	private Co2017Repository co2017Repository;
	
	@Override
	public Iterable<Co2017> get(String q) {
		if (q != null && !"".equals(q.trim())) {
			return co2017Repository.findByProduitContaining(q);
		}
		return co2017Repository.findAll();
	}

	@Override
	public void save(Co2017 co2017) {
		// TODO Auto-generated method stub
		co2017Repository.save(co2017);
	}

	@Override
	public void delete(List<Integer> idList) {
		for(Integer id : idList) {
			co2017Repository.deleteById(id);
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
		
		Iterable<Co2017> co2017List = co2017Repository.findAll();
		int i = 1;
		for (Co2017 co2017 : co2017List) {
			Row row = sheet.createRow(i++);
			cell = row.createCell(0);
			cell.setCellValue(co2017.getCo2017Id());
			cell = row.createCell(1);
			cell.setCellValue(co2017.getNumero());
			cell = row.createCell(2);
			cell.setCellValue(co2017.getDate());
			cell = row.createCell(3);
			cell.setCellValue(co2017.getNomEntreprise());
			cell = row.createCell(4);
			cell.setCellValue(co2017.getAdresse());
			cell = row.createCell(5);
			cell.setCellValue(co2017.getDestination());
			cell = row.createCell(6);
			cell.setCellValue(co2017.getProduit());
			cell = row.createCell(7);
			cell.setCellValue(co2017.getQuantiteExporte());
			cell = row.createCell(8);
			cell.setCellValue(co2017.getUnite());
			cell = row.createCell(9);
			cell.setCellValue(co2017.getNombreConteneur());
			cell = row.createCell(10);
			cell.setCellValue(co2017.getPrixUnitaire());
			cell = row.createCell(11);
			cell.setCellValue(co2017.getMontant());
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
		= new ArrayList<>(Arrays.asList("CERTIFICAT_ORIGINE_ID",
				"NUMERO", "DATE", "NOM_ENTREPRISE", "ADRESSE",
				"DESTINATION", "PRODUIT", "QUANTITE_EXPORTE", "UNITE",
				"NOMBRE_DE_CONTENEUR", "PRIX_UNITAIRE", "MONTANT"));
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
            Co2017 cer = new Co2017();
            Cell cell = cellIterator.next();
            String cellValue;
            if (!isInsert) {
                cellValue = dataFormatter.formatCellValue(cell);
                cer.setCo2017Id(Integer.parseInt(cellValue));
                cell = cellIterator.next();
            }
            
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            cer.setNumero(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            
            cellValue = dataFormatter.formatCellValue(cell);
            cer.setDate(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            cer.setNomEntreprise(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            cer.setAdresse(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            cer.setDestination(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            cer.setProduit(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	cer.setQuantiteExporte(Integer.parseInt(cellValue));
            }

            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            cer.setUnite(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	cer.setNombreConteneur(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            cer.setPrixUnitaire(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	cer.setMontant(Integer.parseInt(cellValue));
            this.save(cer);
            }
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
