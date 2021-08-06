package chromeoptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
/*
 * ChromeOptions is seperate class in selenium which will help to manage options specific options
 * specific to ChromeDriver.
 * ChromeOptions is a class extends MutuableCapabilites.
 * It added after selenium 3.6.0
 * We can use DesiredCapability with merge method now
 * 
 * Why it is reqd?
 * if we want to make/changes any setting of browser then you can use this class
 * By default selenium start fresh profile of browser which don't have any settings cookies history and so on.
 * 
 *Frequently used methods
 * ChromeOptions  options = new ChromeOptions()
 * 
 * To add new extension
 * option.addExtensions(new File("/path/to/extension.crx"));
 * 
 * To add binary path
 * options.setBinary(new File("path/to/chrome"));
 * 
 * To accept untrusted certificate
 * options.setAcceptInsecureCerts(true);
 * 
 * To disbale infobar
 * options.addArguments("disable-infobars");
 * 
 * https://peter.sh/experiments/chromium-command-line-switches/
 * */

public class ChromeOptionsHandling {
	@Test
	public void HandleChromeOptions() throws InterruptedException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		
		
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setAcceptInsecureCerts(true);
		ChromeOptions options = new ChromeOptions();
		
		/*
		 * //Load extension with browser instance options.addExtensions(new
		 * File("path of crx file"));
		 */
		
		//Disable info bars of the browser.
		options.addArguments("--disable-infobars");
		
		//accept untrusted certificate 
		options.setAcceptInsecureCerts(true);
		
		//Merge options and capabilities to pass to driver
		options.merge(capabilites);

		// Start browser
		WebDriver driver = new ChromeDriver(options);
		
		// Maximize browser
		driver.manage().window().maximize();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		driver.quit();
	}

}
