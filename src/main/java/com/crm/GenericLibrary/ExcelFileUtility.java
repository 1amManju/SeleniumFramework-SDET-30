package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of Generic methods of read and write of Excel 
 * @author Manjunath
 *
 */
public class ExcelFileUtility 
{
	/**
	 * This method is used to read the data from the excel
	 * @param sheet
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheet, int rownum , int cellnum) throws Throwable
	{
		FileInputStream f = new FileInputStream(AutoPathConstants.ExcelPath);
		Workbook w = WorkbookFactory.create(f);
		Sheet sh = w.getSheet(sheet);
		Row ro = sh.getRow(rownum);
		Cell cel = ro.getCell(cellnum);
		String value = cel.getStringCellValue();
		return value;
		
	}
	
	/**
	 * This method is used to read the Numeric data from the excel
	 * @param sheet
	 * @param rownum
	 * @param cellnum
	 * @return 
	 * @return
	 * @throws Throwable
	 */
	public int readNumericDataFromExcel(String sheet, int rownum , int cellnum) throws Throwable
	{
		FileInputStream f = new FileInputStream(AutoPathConstants.ExcelPath);
		Workbook w = WorkbookFactory.create(f);
		Sheet sh = w.getSheet(sheet);
		Row ro = sh.getRow(rownum);
		Cell cel = ro.getCell(cellnum);
		double value = cel.getNumericCellValue();
		int num = (int) value;
		return num;
		
	}
	/**
	 * This method is used to write the value into Excel
	 * @param sheet
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheet, int rownum , int cellnum, String value) throws Throwable
	{
		FileInputStream f = new FileInputStream(AutoPathConstants.ExcelPath);
		Workbook w = WorkbookFactory.create(f);
		Sheet sh = w.getSheet(sheet);
		Row ro = sh.getRow(rownum);
		Cell cel = ro.createCell(cellnum);
		cel.setCellValue(value);
		FileOutputStream fo=new FileOutputStream(AutoPathConstants.ExcelPath);
		w.write(fo);
	}
	
	/**
	 * This method is used to Get Last Row Value
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream f = new FileInputStream(AutoPathConstants.ExcelPath);
		Workbook w = WorkbookFactory.create(f);
		Sheet sh = w.getSheet(sheetName);
		int ro = sh.getLastRowNum();
		return ro;
	}
	
	/**
	 * This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(AutoPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}
	
	public Object[][] readmultipleDataFromExcel(String SheetName,int n) throws Throwable
	{
		FileInputStream fis = new FileInputStream(AutoPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell-n];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell-n;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}

}
