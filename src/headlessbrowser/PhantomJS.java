package headlessbrowser;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;
import library.Utility;

/*Phantom JS
 * 
 * Phantom JS is a headless browser with a JSApi.
 * We can use it  for headless website testing access webpages.
 * 
 * Inorder to use Phantom JS with selenium, we have to use GhostDriver.
 * GhostDriver is a implementation of webdriver wire protocol in simple js for Phantom JS.
 * 
 * The latest release of Phantom JS has integrated GhostDriver so we dont have to install separately now.
 * 
 * It supports screenshots.
 * phantomjs.binary.path property
 * */

public class PhantomJS {

	@Test
	public void PhantomJSExample() 
	{
		File src = new File(
				"D:\\Software Setup\\Selenium - Java\\phantomjs\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();

		driver.get("https://learn-automation.com");
		System.out.println("Title of the page is " + driver.getTitle());
		Utility.captureScreenshots(driver, "demo");
	}
}