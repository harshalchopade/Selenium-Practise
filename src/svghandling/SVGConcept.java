package svghandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGConcept {
	/*
	 * SVG Handling SVG is like other images png, .jpeg etc, but it wont be handle
	 * by xpath SVG is vector images like circle, rectangle, lines etc Elements will
	 * be available under svg tag.
	 */

	// Syntax
	// *[name()='svg']//[local-name()='attribute name']

	// e.g //*[name()='svg']//[local-name()='text']

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D://Software Setup//Selenium - Java//chromedriver_win32//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://flipkart.com/");
		driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='path' and @class='_34RNph'][2]"))
				.sendKeys("mobile");
		driver.quit();
	}
}
