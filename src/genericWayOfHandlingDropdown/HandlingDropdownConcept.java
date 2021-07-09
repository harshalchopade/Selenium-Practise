package genericWayOfHandlingDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdownConcept {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D://Software Setup//Selenium - Java//chromedriver_win32//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		
		By dropLocator = By.id("oldSelectMenu");
		
		selectDropdownOnType(dropLocator, TestClass.Dropdown.INDEX.toString(), "1");
		driver.quit();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectDropdownOnType(By locator, String type, String value) {
		Select select = new Select(getElement(locator));

		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			select.selectByValue(value);
			break;

		case "visibletext":
			select.selectByVisibleText(value);
			break;

		default:
			System.out.println("Please select correct value");
			break;
		}

	}

}
