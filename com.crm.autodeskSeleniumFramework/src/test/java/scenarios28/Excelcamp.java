package scenarios28;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelcamp {
	public String getdata(String sheetname,int row,int column) throws InterruptedException, Throwable, IOException
	{
		String Filepath="D:\\testdata2.xlsx";
	
		
		FileInputStream fin=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fin);
		
	Sheet sh = wb.getSheet("Sheet1");
	Row r = sh.getRow(1);
	String cellvalue=r.getCell(5).getStringCellValue();
	
	return cellvalue;
	}



}
