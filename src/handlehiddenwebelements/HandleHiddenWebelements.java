package handlehiddenwebelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleHiddenWebelements {
	/*
	 * When webelement is hidden on the DOM, and we try to perform any operation like click, type etc
	 * i.e webelement is having property as 'hidden' then it will throw ElementNotVisibleException.
	 * To check webelement is hidden or not on the DOM,  check the property 'hidden' is present or not
	 * or by Using selenium use getLocation().getX() and getY() we can determine.
	 * 
	 * When above method returns coordinates as 0 then it means it is hidden, but if you get value means visible
	 * */
	
	@Test
	public void highlightElementExample() throws InterruptedException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		// Start browser
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		/*
		 * //If we use directly then it will throw error
		 * driver.findElement(By.id("male")).click();
		 */
		
		//Way to handle hidden webelements
		List<WebElement> elements = driver.findElements(By.id("male"));
		System.out.println(elements.size());
		
		for(WebElement eachElement : elements)
		{
			int x = eachElement.getLocation().getX();
			if(x!=0)
			{
				
				eachElement.click();
				Thread.sleep(5000);
				break;
			}
		}
		
		driver.quit();
	}
}
