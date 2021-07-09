package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Demo {

	@Test(priority = 1)
	public void draggableExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("https://testproject.io/");
		Thread.sleep(5000);
		java.util.List<WebElement> elements = driver.findElements(By.xpath("//a/@href"));
		
		
		System.out.println(elements.size());
	}
}
