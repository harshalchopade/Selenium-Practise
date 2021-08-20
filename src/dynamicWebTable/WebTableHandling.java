package dynamicWebTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://nssdc.gsfc.nasa.gov/planetary/factsheet/planet_table_ratio.html");
		
		List<String> noOfMoonsList = new ArrayList<String>();
		List<String> eachPlanetName = new ArrayList<String>();
		HashMap<String, Integer> planet = new HashMap<String, Integer>();

		for (int i=2; i<=11; i++)
		{
		eachPlanetName.add(driver.findElement(By.xpath("//tr[1]/td["+i+"]/b[./a]")).getText());	
		}
		
		for (int i=1; i<=10; i++) 	
		{
			noOfMoonsList.add(driver.findElement(By.xpath("//a[contains(normalize-space(),'Number of Moons')]/../../following-sibling::td["+i+"]")).getText());	
		}
				
		for(int i=0; i<=9; i++)
		{
			planet.put(eachPlanetName.get(i), Integer.parseInt(noOfMoonsList.get(i)));	
		}
		
		Set<String> keys = planet.keySet();
		for(String str : keys)
		{
			if(planet.get(str)>1)
			{
				System.out.println("Plane name is" + str + "No of planets are "+planet.get(str));
			}
		}
		driver.close();
	}
}
