package fluentwait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWaitDemo {
	/*
	 * Fluentwait in selenium webdriver is one of the most versatile wait which will
	 * give you the complete power to handle any kind of situation based on your
	 * requirement.
	 * 
	 * 
	 * Why wait is required
	 * 
	 * 1-Now a day many applications are using AJAX control, Jquery and many other
	 * complex widgets which make application slow and data takes some time to
	 * appear on screen so we need to wait until data is not present on UI.
	 * 
	 * 2-When you perform the complex operation on any application it also takes
	 * some time for processing and we have to make sure our script should wait
	 * until specific conditions are not true.
	 * 
	 * Definition of Fluentwait in selenium webdriver
	 * 
	 * In simple words, Fluent wait is just a plain class and using this class we
	 * can wait until specific conditions are met.
	 * 
	 * In Fluent wait, we can change the default polling period based on our
	 * requirement.
	 * 
	 * 
	 * 
	 * Technical details
	 * 
	 * 1-Fluent wait is a class and is part of org.openqa.selenium.support.ui
	 * Package
	 * 
	 * 2-It is an implementation of Wait interface.
	 * 
	 * 3-Each fluent wait instance defines the maximum amount of time to wait for a
	 * condition and we can give the frequency with which to check the condition.
	 * 
	 * 4- We can also ignore any exception while polling element such as
	 * NoSuchElement exception in Selenium.
	 * 
	 * You will also get questions in your interviews that what is the difference
	 * between explicit wait and Fluent wait.
	 * 
	 * Ans- In explicit wait, you can use some set of existing precondition to wait
	 * like
	 * 
	 * Wait till element is not visible, wait till element is not clickable, Wait
	 * till presence of element located and so on.
	 * 
	 * In Fluent wait, you can customize the apply method and you can write your own
	 * conditions based on your requirement.
	 * 
	 */
	@Test(priority = 1)
	public void fluenWaitDemo() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

		// Click on timer button to start
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) {
				
				WebElement ele = driver.findElement(By.xpath(".//*[@id='demo']"));

				String value = ele.getAttribute("innerHTML");

				if (value.equalsIgnoreCase("WebDriver")) {
					return ele;
				} else {

					System.out.println("Text on screen is " + value);
					return null;
				}
			}
		});
		System.out.println("Element is displayed "+element.isDisplayed());
		driver.quit();
	}
}
