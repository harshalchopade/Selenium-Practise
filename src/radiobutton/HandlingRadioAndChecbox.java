package radiobutton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingRadioAndChecbox {
	/*
	 * Selenium always try to click on element on middle of the element Each browser
	 * has different implementation so sometimes click operation throws element is
	 * not clickable at specific coordinate.
	 */

	public static void main(String[] args) throws InterruptedException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		driver.findElement(By.xpath("(//div[@class='header-text'])[1]")).click();

		if (driver.findElement(By.xpath("//span[text()='Radio Button']")).isDisplayed())
			driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

		// Handling the dynamic radio button
		List<WebElement> allRadioButtons = driver.findElements(By.xpath("//input[@type='radio']/following::label"));

		for (WebElement eachButton : allRadioButtons) {
			String labelOfButton = eachButton.getAttribute("for");
			System.out.println("Label of button is " + labelOfButton);
			if (labelOfButton.contains("yes")) {
				eachButton.click();
				break;
			}
		}

		// Handling the dynamic checkbox button
		driver.findElement(By.xpath("(//div[@class='header-text'])[1]")).click();

		if (driver.findElement(By.xpath("//span[text()='Check Box']")).isDisplayed())
			driver.findElement(By.xpath("//span[text()='Check Box']")).click();

		// Handling the dynamic radio button
		driver.findElement(By.xpath("//button[@title='Toggle']")).click();
		List<WebElement> allCheckBoxes = driver
				.findElements(By.xpath("//span[@class='rct-checkbox']/following-sibling::span[@class='rct-title']"));

		for (WebElement eachCheckbox : allCheckBoxes) {
			String labelOfCheckbox = eachCheckbox.getText();
			System.out.println("Label of checkbox is " + labelOfCheckbox);
			if (labelOfCheckbox.equals("Documents")) {
				eachCheckbox.click();
				break;
			}
		}

		driver.quit();
	}
}
