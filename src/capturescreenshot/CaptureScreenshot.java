package capturescreenshot;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Utility;

@Test
public class CaptureScreenshot {

	public void getTheScreenshot() throws IOException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		Utility.captureScreenshots(driver, "URLHit");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Utility.captureScreenshots(driver, "EnteredUserName");

		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver; File source =
		 * ts.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(source, new
		 * File("./Screenshots/HRM.png"));
		 */
		driver.quit();
	}
}
