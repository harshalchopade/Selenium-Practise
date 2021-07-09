package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
 * Base Class is the main which will take care of browser Setup, loading file and other resuable methods.
 * Using base class we can avoid code duplication.
 * Reuse code as much we can.
 * */
public class BaseClass {
	
	WebDriver driver;
	Properties pro;
	
	@BeforeClass
	public void setUp()
	{
		Reporter.log("Browser Session Started", true);

		try {
			File file = new File("./resources/Config.property");
			FileInputStream fis = new FileInputStream(file);
			
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("URL"));
		
		Reporter.log("URL Opened", true);

	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Session Ended", true);
	}

}
