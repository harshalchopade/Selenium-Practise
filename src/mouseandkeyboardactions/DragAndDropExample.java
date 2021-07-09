package mouseandkeyboardactions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DragAndDropExample {

	/*
	 * Selenium has a separate class called Actions Class which is mainly
	 * responsible for the complex gesture which includes double click, right-click,
	 * mouse hover, keyboard events, and so on.
	 * 
	 * All application which is available on the web like all E-commerce like
	 * Flipkart, Amazon, Snapdeal they have all advanced activities for example
	 * mouse hover, drag and drop and right click etc. In these cases, we will use
	 * the Actions class in Selenium.
	 * 
	 * 
	 * In order to perform drag and drop we have some predefined methods which will
	 * do our task. Even if you do not want to use dragAndDrop method then still you
	 * can do the same operation using clickAndHold, MoveToElement and Release
	 * method which we will discuss in this post itself.
	 * 
	 * 1.dragAndDrop(WebElement src,WebElement dest)
	 * 
	 * This is a very straight forward method where you can simply specify the
	 * source and destination and selenium will perform internally clickAndHold >
	 * MoveToElement > Release method.
	 * 
	 * Note- This is only applicable when you can have a clear source and
	 * destination.
	 * 
	 * Note- Any method of Actions class we need to call perform () method otherwise
	 * we will get an exception. If we have series of action in our script using
	 * Actions class then we have to call build().perform() method.
	 * 
	 * Second Approach- You can find X, Y coordinate using Selenium itself and once
	 * you find the X, Y then you can changes the coordinates accordingly.
	 * 
	 * 
	 * WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));</code>
	 * <code>int x=drag.getLocation().getX();</code> <code>int
	 * y=drag.getLocation().getY();
	 * 
	 * Action class we need to use for this activity. pause() is a method to wait
	 * before the next action to be performed. build() should be used when we are
	 * doing more than 1 operation e.g clickandhold then move (multiple method call to combined it and then call
	 * it) perform() is mandatory to perform action irrespective no of method calls
	 */

	@Test(priority = 1)
	public void dragAndDropExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		// Start application
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");

		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);

		Actions action = new Actions(driver);

		WebElement src = driver.findElement(By.xpath("//span[text()='Ian Rankin']"));

		WebElement dest = driver.findElement(By.xpath("//li[text()='Zend Framework in Action']"));

		action.clickAndHold(src).pause(Duration.ofSeconds(5)).moveToElement(dest).pause(Duration.ofSeconds(5)).release()
				.build().perform();

		/* alternative to above method use by defualt method provide by the selenium */
		action.dragAndDrop(src, dest).perform();

		driver.quit();
	}
}
