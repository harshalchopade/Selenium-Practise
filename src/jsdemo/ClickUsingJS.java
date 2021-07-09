package jsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickUsingJS {
	/*
	 * Sometimes we have passed the correct xpath but still selenium is not clicking
	 * on the checkbox or element says elementNotInterractableException and behaving
	 * strange
	 * 
	 * It could be due to multiple reasons Compatibility issue (upgradedriver,
	 * downgrade driver, selenium version) But if issue occuring only for one of the
	 * element then we can use JS.
	 * 
	 * In webelement click() checks - conditions element must be clickable, visible, proper
	 * width and height < 0 then only it will click. 
	 * 
	 * But JS click() will checks if present on the DOM or not, 
	 * O/W will not checks conditions like disabled,enabled,visible
	 */

	@Test
	public void brokenLinksExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("https://demoqa.com/checkbox");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Approach 1 - when we have id, name, classname, tagname
		js.executeScript("document.getElementById('tree-node-home').click()");

		// Approach 2 - when we have xpath or css
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='tree-node-home']"));
		js.executeScript("arguments[0].click()", checkbox);

		Thread.sleep(5000);

		driver.quit();

	}
}
