package datadriventesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.Utility;

public class DataDrivenTestUsingExcel {
	/*
	 * As the name itself says Data drivern - A framwework which is drivern by data
	 * It can be used when one test case has to execute with different set of data
	 * 
	 * lets say eg we have 20 credentials and we need to test our app with all
	 * credentials so we will be writing only 1 test script and test will be passed
	 * via excel sheet.
	 */

	WebDriver driver;

	@Test(dataProvider = "Credentials")
	public void loginWithSetOfTestData(String uname, String pwd) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"), "Login failes - Invalid Credentials");

		driver.quit();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider(name = "Credentials")
	public Object[][] testData() {
		Utility.readExcelData("C:\\Users\\hchopade\\eclipse-workspace\\SeleniumTutorials\\resources\\TestData.xlsx");
		int rows = Utility.getRowCount(0);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < 2; j++)
			{
				data[i][j] = Utility.getData("Sheet1", i, j);
			}
		}
		return data;
	}
}
