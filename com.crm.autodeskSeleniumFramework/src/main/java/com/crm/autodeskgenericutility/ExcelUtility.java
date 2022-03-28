
package com.crm.autodeskgenericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





/**
 * 
 * @author jayapradha
 *
 */

public class ExcelUtility {
	
	/**its used read the data from excelbased below arguments
	 * 
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */

	public String getDataFromExcel(String SheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/leads.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		String data = row.getCell(cellnum).getStringCellValue();
		workbook.close();
		return data;
	}
	/**
	 * its used read the data from excelbased below arguments
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public Double getDataFromExcelDouble(String SheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/leads.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		double data = row.getCell(cellnum).getNumericCellValue();
		workbook.close();
		return data;
	}
	/**
	 * used to get last used row number on specified sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName) throws Throwable
	{
		
		FileInputStream fis=new FileInputStream("./data/testdata.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		workbook.close();
		return sheet.getLastRowNum();
	}
	/**
	 * this method is used to write the data t the sheet
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setDataexcel(String SheetName,int rownum,int cellnum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/testdata.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		Cell cel = row.createCell(cellnum);
		cel.setCellValue(data);
		FileOutputStream fout=new FileOutputStream("./data/testdata.xlsx");
		workbook.write(fout);
		workbook.close();
		
	}

}
