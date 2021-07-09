package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility {
	/*
	 * Creating a library to take the screenshot for each action So each time we
	 * dont need to write the code again and again simply call this method wherever
	 * required
	 */

	/*
	 * Note For using FileUtils class need apache.coomon.io jar to be part of the
	 * project
	 */

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String captureScreenshots(WebDriver driver, String name) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			return dest;
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot is " + e.getMessage());
			return e.getMessage();
		}
	}

	// Element highlighter code
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	// Click Element using Action class
	public static void clickUsingAction(WebDriver driver, WebElement id) {

		Actions action = new Actions(driver);
		action.moveToElement(id).click().build().perform();
	}

	public static void readExcelData(String path)
	{
		try 
		{
		File src = new File(path);

		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);

		} 
		catch (Exception e)
		{
		System.out.println(e.getMessage());
		}
	}
	
	public static String getData(String sheetName, int row, int col)
	{
		sheet = workbook.getSheet(sheetName);
		
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public static int getRowCount(int sheetIndex)
	{
		int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
		return row;
		
	}
}
