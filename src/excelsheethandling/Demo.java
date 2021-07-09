package excelsheethandling;

import library.Utility;

public class Demo {

	public static void main(String[] args) {
		
		Utility.readExcelData("C:\\Users\\hchopade\\eclipse-workspace\\SeleniumTutorials\\resources\\TestData.xlsx");
		
		System.out.println(Utility.getData("Sheet1", 1, 0));
	}
}
