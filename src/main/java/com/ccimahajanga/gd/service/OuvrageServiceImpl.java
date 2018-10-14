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

import com.ccimahajanga.gd.domain.Ouvrages;

@Service
public class OuvrageServiceImpl implements OuvrageService {
	
	@Autowired
	private OuvragesRepository ouvragesRepository;
	
	@Override
	public Iterable<Ouvrages> get(String q) {
		// TODO Auto-generated method stub
		if (q != null && !"".equals(q.trim())) {
			return ouvragesRepository.findByTitreOuvragesContaining(q);
		}
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

	@Override
	public void upload(MultipartFile multipart) throws IllegalStateException, IOException, InvalidFormatException {
		List<String> headers 
		= new ArrayList<>(Arrays.asList("OUVRAGE_ID",
				"CODE_OUVRAGE", "COMMENTAIRE", "DOMAINE", "ETAGE",
				"NOMBRE_EXEMPLAIRE", "RANGER", "TITRE_OUVRAGE"));
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
            Ouvrages ouvr = new Ouvrages();
            Cell cell = cellIterator.next();
            String cellValue;
            if (!isInsert) {
                cellValue = dataFormatter.formatCellValue(cell);
                ouvr.setOuvrageId(Integer.parseInt(cellValue));
                cell = cellIterator.next();
            }
            cellValue = dataFormatter.formatCellValue(cell);
            ouvr.setCodeOuvrages(Integer.parseInt(cellValue));
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            ouvr.setCommentaire(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            ouvr.setDomaines(cellValue);
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	ouvr.setEtage(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	ouvr.setNombreExemplaire(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue != null || !"".equals(cellValue)) {
            	ouvr.setRanger(Integer.parseInt(cellValue));
            }
            
            cell = cellIterator.next();
            cellValue = dataFormatter.formatCellValue(cell);
            ouvr.setTitreOuvrages(cellValue);
            this.save(ouvr);
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
