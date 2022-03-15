package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest 
{
	@Test
	public void readDataFromExcelSheet() throws EncryptedDocumentException, IOException
	{
		//Step 1: Load excel file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		
		//Step 2: create work book
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//Step 4: get the row
		Row ro = sh.getRow(0);
		
		//Step 5: get the cell
		Cell ce = ro.getCell(0);
		
		//Step 6: read the data from the cell
		String val = ce.getStringCellValue();
		System.out.println(val);
		
		
	}

}
