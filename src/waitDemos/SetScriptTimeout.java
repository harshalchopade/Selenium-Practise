package waitDemos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SetScriptTimeout {
	/*
	 * setScriptTimeout();
	 * 
	 * This is used to set the amount of time the WebDriver must wait for an
	 * asynchronous script to finish execution before throwing an error. If the
	 * timeout is negative, then the script will be allowed to run indefinitely.
	 * 
	 * Syntax:
	 * 
	 * setScriptTimeout(long time,java.util.concurrent.TimeUnit unit);
	 * 
	 * time – The timeout value. unit – The unit of time
	 * 
	 * The default timeout for setScriptTimeout method is zero. If you do not set
	 * time, then there are chances that executeAsyncScript method may fail because
	 * the JavaScript code may take more than the time allotted. To avoid such
	 * failures, set the setScriptTimeout. This is mainly used for Javascript
	 * objects and executors.
	 * 
	 * In the example above, if the time is not used, then there will be an error
	 * stating: “Timed out waiting for async script result”. To avoid this error,
	 * one should use setScriptTimeout.
	 */

	@Test(priority = 1)
	public void handlePageLoadTimeout() {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		// setScriptTimeout for 10 seconds
		/*
		 * driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		 * ((JavascriptExecutor) driver).executeScript("alert('hello world');");
		 * ((JavascriptExecutor) driver).
		 * executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);"
		 * );
		 */

		driver.get("https://learn-automation.com/implicit-wait-in-selenium-webdriver/");
		driver.quit();
	}
}
