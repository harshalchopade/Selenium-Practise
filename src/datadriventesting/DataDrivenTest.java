package datadriventesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	/*
	 * As the name itself says Data drivern - A framwework which is drivern by data 
	 * It can be used when one test case has to execute with different set of data
	 * 
	 * lets say eg we have 20 credentials and we need to test our app with all credentials so we
	 * will be writing only 1 test script and test will be passed via excel sheet.
	 * 
	 * DDT -
	 * 1.Excel file
	 * 2.Properties file
	 * 3.testng.xml
	 * 4.XML files
	 * 5.JSON file
	 * 6.DB
	 * */

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
		Object[][] data = { { "Admin", "Admin137" }, { "Admin", "Admin123" }, { "Admin", "Admin789" } };
		return data;
	}
}
