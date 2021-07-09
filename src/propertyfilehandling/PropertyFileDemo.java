package propertyfilehandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*What is OR/Property/Config File
 * Its plain text file which contains key and pair.
 * Using keys we can get the values resp.
 * You can use this as config file.
 * In selenium you can use this as object repo as well.
 * */

public class PropertyFileDemo {
	ConfigReader config;
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		config = new ConfigReader();
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
	}
	
	@Test
	public void getPathFromPropertyFile()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.getAppUrl());
		driver.quit();
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
