package excelsheethandling;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	public static void main(String[] args) throws Exception {
		
		File src = new File("C:\\Users\\hchopade\\eclipse-workspace\\SeleniumTutorials\\resources\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String data = sheet.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(data);
		
		//To print all the data 
		
		int noOfRows = sheet.getLastRowNum();
		
		for(int i=0;i<noOfRows;i++)
		{
			
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		
		workbook.close();
			
	}
}
