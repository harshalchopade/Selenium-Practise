package framehandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameDemo {
	/*
	 * iFrame in Selenium Webdriver is a web page or an inline frame which is
	 * embedded in another web page or an HTML document embedded inside another HTML
	 * document. The iframe is often used to add content from other sources like an
	 * advertisement into a web page. The iframe is defined with the <iframe> tag.
	 */

	// How to identify the iframe:
	/*
	 * Right click on the element, If you find the option like 'This Frame' then it
	 * is an iframe. (Please refer the above diagram)
	 */

	/*
	 * Right click on the page and click 'View Page Source' and Search with the
	 * 'iframe', if you can find any tag name with the 'iframe' then it is meaning
	 * to say the page consisting an iframe.
	 */

	// We can even identify total number of iframes by using below snippet.

	/* Int size = driver.findElements(By.tagName("iframe")).size(); */

	/*
	 * Basically, we can switch over the elements and handle frames in Selenium
	 * using 3 ways.
	 * 
	 * By Index
	 *  By Name 
	 *  By Web Element
	 */

	// How to switch back to the Main Frame

	/*
	 * We have to come out of the iframe.
	 * 
	 * To move back to the parent frame, you can either use switchTo().parentFrame()
	 * or if you want to get back to the main (or most parent) frame, you can use
	 * switchTo().defaultContent(); driver.switchTo().parentFrame();
	 * driver.switchTo().defaultContent();
	 * 
	 */

	@Test(priority = 1)
	public void simpleAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2017/01/frames-in-selenium-webdriver.html");

		// Finding all iframe tags on a web page
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " + numberOfTags);

		// Switch to the frame using the frame name
		System.out.println("Switching to the frame");
		driver.switchTo().frame("myweb");

		driver.findElement(By.xpath("//button[text()='Menu']")).click();

		// Switch back to main web page
		driver.switchTo().defaultContent();

		// Switch to the frame using 
		System.out.println("Switching to the frame");
		driver.switchTo().frame("google");

		driver.findElement(By.xpath("//button[text()='Menu']")).click();

		// Switch back to main web page
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
