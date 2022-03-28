package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib{
	public String getdata(String sheet,int row,int cell) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String Filepath="./data/testdata.xlsx";
		Thread.sleep(5000);
		FileInputStream fin=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fin);
		
	Sheet sh = wb.getSheet("org");
	Row r = sh.getRow(1);
	String cellvalue=r.getCell(0).getStringCellValue();
	return cellvalue; 
	}
	public String industry(String sheet,int row,int cell) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String Filepath="./data/testdata.xlsx";
		Thread.sleep(5000);
		FileInputStream fin=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fin);
		
	Sheet sh = wb.getSheet("org");
	Row r = sh.getRow(1);
	String cellvalue=r.getCell(1).getStringCellValue();
	return cellvalue; 
	}
	public String type(String sheet,int row,int cell) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String Filepath="./data/testdata.xlsx";
		Thread.sleep(5000);
		FileInputStream fin=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fin);
		
	Sheet sh = wb.getSheet("org");
	Row r = sh.getRow(1);
	String cellvalue=r.getCell(2).getStringCellValue();
	return cellvalue; 
	}
	public String getlastname(String sheet,int row,int cell) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String Filepath="./data/testdata.xlsx";
		Thread.sleep(5000);
		FileInputStream fin=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fin);
		
	Sheet sh = wb.getSheet("contract");
	Row r = sh.getRow(1);
	String cellvalue=r.getCell(0).getStringCellValue();
	return cellvalue; 
	}
	public String getproductname(String sheet,int row,int cell) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String Filepath="./data/testdata.xlsx";
		Thread.sleep(5000);
		FileInputStream fin=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fin);
		
	Sheet sh = wb.getSheet("pro");
	Row r = sh.getRow(1);
	String cellvalue=r.getCell(0).getStringCellValue();
	return cellvalue; 
	}
}