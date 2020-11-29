package com.app.ohrm.Generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static int getRowCount(String path,String sheet) {
		int rc=-1;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rc;
	}

	public static String getData(String path,String sheet,int r,int c) {
		String v="";
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return v;
	}
	public static String getData2(String path,String sheet,int r,int c) {
		String val="";
	//	FileInputStream fis;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheet);
			Row row=sh.getRow(r);
			Cell cell=row.getCell(c);
			val = cell.getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//	System.out.println(value);
		
		return val;
		
	}

}

