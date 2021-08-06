package debugging;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ExecuteSeleniumScriptsOnAlreadyOpenedBrowser {

	@Test
	public void testDebugging() {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("debuggerAddress", "localhost:9988");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://www.google.com");
	}

}
