package excelsheethandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {

	public static void main(String[] args) throws Exception {
		File src = new File("C:\\Users\\hchopade\\eclipse-workspace\\SeleniumTutorials\\resources\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		sheet.getRow(0).createCell(2).setCellValue("Pass");
		sheet.getRow(1).createCell(2).setCellValue("Pass");
		sheet.getRow(2).createCell(2).setCellValue(145.14);
		
		FileOutputStream fos = new FileOutputStream(src);
		
		workbook.write(fos);
		
		workbook.close();
	}
}
