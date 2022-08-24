package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static final long PAGE_LOAD_TIME_OUT = 20;
	public static final long IMPLICIT_WAIT = 10;
	
	public void swithToFrame(String fraemeName) {
		driver.switchTo().frame(fraemeName);
	}
	
	public Object[][] getTestData(String filePath,String sheetName) throws Exception{
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][columnCount];
		
		for(int i=1;i<rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=1;j<=columnCount;j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j-1] = cell.getStringCellValue();
			}
		}
		return data;
		
	}
	
}
