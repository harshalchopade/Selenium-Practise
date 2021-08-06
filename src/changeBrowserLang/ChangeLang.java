package changeBrowserLang;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


//Change the browser lang 
public class ChangeLang {

	WebDriver driver;

	@Test
	public void testBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=es-mx");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://google.co.in");
		driver.quit();
	}
}
