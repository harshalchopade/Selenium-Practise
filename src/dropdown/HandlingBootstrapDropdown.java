package dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootstrapDropdown {

	public static void main(String[] args) {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Handling of Bootstrap dropdown.
		//Steps
		/*1.Click on the dropdown
		 *2.Locate the options
		 * then perfrom the operation
		 * 
		 * Note
		 * In bootstrap tech, select class we are not going to use to perform the operation
		 * in this mostly div class is used.
		 * */
		driver.findElement(By.id("menu1")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		
		/*driver.findElements(By.cssSelector("ul#react-autosuggest-1 div.clearfix span"))
        .stream().forEach(ele-> System.out.println(ele.getText()));*/

		for (WebElement eachOption : options) 
			{
			
			String text = eachOption.getText();
			//String text = eachOption.getAttribute("innerHTML"); -- alternate way to get the text of an element.
			System.out.println(text);
			if (text.contentEquals("JavaScript"))
			{
				eachOption.click();
				break;
			} 
		}
		driver.quit();
	}
}
