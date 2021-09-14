package dropdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyDropdownOptionsSortOrder {

	public static void main(String[] args) {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/");

		// Verify sorted list
		List<String> actualList = new ArrayList<>();
		List<String> tempList = new ArrayList<>();

		WebElement tools_droppdown = driver.findElement(By.id("tools"));
		Select tools = new Select(tools_droppdown);

		List<WebElement> allToolsOptions = tools.getOptions();

		for (WebElement eachToolOption : allToolsOptions) {
			actualList.add(eachToolOption.getText());
		}

		System.out.println(actualList);

		tempList.addAll(actualList);

		// Sorting temp list by ascending order
		Collections.sort(tempList);

		System.out.println(tempList);

		if (actualList.equals(tempList)) {
			System.out.println("List are sorted");
		} else {
			System.out.println("List are not sorted");
		}

		/**************************************************************/
		// Verify unsorted list
		List<String> actualList1 = new ArrayList<>();
		List<String> tempList1 = new ArrayList<>();

		WebElement tools_droppdown1 = driver.findElement(By.id("tools1"));
		Select tools1 = new Select(tools_droppdown1);

		List<WebElement> allToolsOptions1 = tools1.getOptions();

		for (WebElement eachToolOption1 : allToolsOptions1) {
			actualList1.add(eachToolOption1.getText());
		}

		System.out.println(actualList1);

		tempList1.addAll(actualList1);

		// Sorting temp list by ascending order
		Collections.sort(tempList1);

		System.out.println(tempList1);

		if (actualList1.equals(tempList1)) {
			System.out.println("List are sorted");
		} else {
			System.out.println("List are not sorted");
		}

		driver.quit();
	}
}
