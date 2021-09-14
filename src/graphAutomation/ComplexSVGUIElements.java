package graphAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ComplexSVGUIElements {

	WebDriver driver;

	@Test
	public void testBrowser() {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		// System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");

		List<WebElement> verticalGraph = driver.findElements(By.xpath(
				"//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']"));
		System.out.println(verticalGraph.size());

		Actions act = new Actions(driver);
		
		for(WebElement each : verticalGraph)
		{
			act.moveToElement(each).pause(Duration.ofSeconds(2)).perform();
			String text = driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']")).getText();
			System.out.println(text);
		}
		driver.quit();
	}
}
