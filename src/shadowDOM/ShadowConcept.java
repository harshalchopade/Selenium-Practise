package shadowDOM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowConcept {
	/*Whenever we are interact with shadow root element it wont support the
	 * normal locator
	 * We have to use css with JS to handle this
	 * And also we can interact with shadow element only when its open
	 * i.e #shadow-root (open)*/
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D://Software Setup//Selenium - Java//chromedriver_win32//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement element = (WebElement) jse.executeScript("return document.querySelector('downloads-manager')"
				+ ".shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar#toolbar')"
				+ ".shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('div#searchTerm > input')");
		
		driver.get("chrome://downloads/");
		String js = "arguments[0].setAttribute('value', 'Naveen Automation')";
		((JavascriptExecutor)driver).executeScript(js, element);
	}

}
