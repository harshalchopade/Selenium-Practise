package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogDemo {

	@Test
	public void log4jdemo() throws InterruptedException {
		
		Logger log = Logger.getLogger("LogDemo");

		PropertyConfigurator.configure("log4j.properties");
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		// Start browser
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();
		log.info("Window maximized");

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		log.info("Site Opened");
		
		driver.quit();
		
	}
}
