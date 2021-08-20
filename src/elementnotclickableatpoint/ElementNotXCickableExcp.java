package elementnotclickableatpoint;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ElementNotXCickableExcp {

	/*
	 * I came across through a requirement where I had to execute test case mainly
	 * on Chrome browser. I faced Element is not clickable at point in Selenium and
	 * I solved using different ways.
	 * 
	 * The reason for the element is not clickable at point(x,y) exception.
	 * 
	 * Some of my observation was
	 * 
	 * It mostly happens in Chrome so if you are mostly working with Firefox or IE
	 * then you will not be getting this exception. Chrome does not calculate the
	 * exact location of element Chrome always click in the middle of Element.
	 * Sometimes you will get this exception due to Sync issue also.
	 * 
	 * Solution that worked for me to Solve element is not clickable at point(x,y)
	 * exception
	 * 
	 * 1-Updated chrome driver to latest one.
	 * 
	 * 2-Get the coordinate then click on the link or button
	 * 
	 * 3-Try to click using Y coordinates
	 * ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
	 * 
	 * 4.Try to click using X coordinates
	 * ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().x+")");
	 * 
	 * 5.Try different Xpath for the same element.
	 */
	@Test
	public void highlightElementExample() throws InterruptedException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		// Start browser
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//div[@class='header-text'])[1]")).click();
		
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
		action.moveToElement(driver.findElement(By.id("yesRadio"))).click().build().perform();
		Thread.sleep(10000);
		driver.quit();	
	}
}
