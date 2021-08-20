package svghandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {

	public static void main(String[] args) {
		int i = 1;
		System.setProperty("webdriver.chrome.driver",
				"D://Software Setup//Selenium - Java//chromedriver_win32//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		
		driver.switchTo().frame("svg_result");
		
		while(i<=12)
		{
			List<WebElement> list = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='g2']"
					+ "//*[local-name()='path' and contains(@id, 'face')]"));
			
			for (WebElement element : list) {
				i++;
				String str = element.getAttribute("d");
				System.out.println(str);
			}
		}
		driver.quit();
	}
}
