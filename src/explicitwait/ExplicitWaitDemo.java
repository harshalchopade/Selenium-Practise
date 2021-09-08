package explicitwait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {

	/*
	 * Condition for Explicit wait in selenium webdriver
	 * 
	 * Condition 1- I have a web page which has some login form and after login, it
	 * takes a lot of time to load Account page or Home page. This page is dynamic
	 * it means sometimes it takes 10 seconds to load the homepage, sometimes its 15
	 * second and so on. In this situation, the Explicit wait can help us which will
	 * wait until specific page/page title is not present it will keep waiting.
	 * 
	 * 
	 * 
	 * Condition 2- You are working on travel application and you have filled the
	 * web form and clicked on submit button. Now you have to wait until complete
	 * data is not loaded or specific data is not loaded. In this case, again we can
	 * use Explicit wait in which we can give wait till specific or set of elements
	 * are not loaded.
	 * 
	 * 
	 * Condition 3- There are some elements on a web page which are hidden and it
	 * will be displayed only when specific conditions get true, so we have to wait
	 * until these elements are not visible. In this case, again explicit wait will
	 * help in which we can specify wait till the element or elements are not
	 * visible.
	 * 
	 * The good thing which will make you happy is that you don’t have to write code
	 * for all these conditions. It is already defined in a separate class and we
	 * just have to use them based on our requirement.
	 * 
	 * ExpectedConditions is a class in Selenium which has some predefined condition
	 * which makes our task easy.
	 * 
	 * 
	 * Now you must be confused between Implicit wait and Explicit wait right?
	 * 
	 * Don’t worry its totally different let me make it clear for you with the help
	 * of one example.
	 * 
	 * Implicit wait– It only checks the presence of element on WebPage that’s all
	 * if elements are hidden or any other condition then it will not handle and it
	 * will fail your script.
	 * 
	 * It is applicable for all the element after initialization.
	 * 
	 * Explicit wait– It has so much capability which we already discussed and it is
	 * applicable to the specific element.
	 * 
	 * It will be executed on local part of the selenium code i.e code level.
	 * Very well documented and defined behaviour
	 * Ignores the exceptions
	 *
	 */

	@Test(priority = 1)
	public void simpleAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

		// Click on timer button to start
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

		// Create object of WebDriverWait class and it will wait max of 20 seconds.
		// By default it will accepts in Seconds
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Here we will wait until element is not visible, if element is visible then it
		// will return web element
		// or else it will throw exception org.openqa.selenium.TimeoutException
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

		// if element found then we will use- In this example I just called isDisplayed
		// method
		boolean status = element.isDisplayed();

		// if else condition
		if (status) {
			System.out.println("===== WebDriver is visible======");
		} else {
			System.out.println("===== WebDriver is not visible======");
		}
	}
}
