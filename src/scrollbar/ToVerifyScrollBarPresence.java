package scrollbar;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToVerifyScrollBarPresence {

	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com/");
	}

	@Test
	public void getScrollStatus() throws Exception {
		// Initially no scroll present on page.
		// Check and print horizontal and vertical scroll status.
		checkAndPrintScrollStatus();
		Thread.sleep(2000);

		// resize window to get horizontal scroll on page.
		driver.manage().window().setSize(new Dimension(400, 768));
		// Check and print horizontal and vertical scroll status.
		checkAndPrintScrollStatus();
		Thread.sleep(2000);

		// resize window to add vertical scroll on page.
		driver.manage().window().setSize(new Dimension(400, 400));
		// Check and print horizontal and vertical scroll status.
		checkAndPrintScrollStatus();
		Thread.sleep(2000);

		// resize window to remove horizontal scroll from page.
		driver.manage().window().setSize(new Dimension(1024, 400));
		// Check and print horizontal and vertical scroll status.
		checkAndPrintScrollStatus();
	}

	public void checkAndPrintScrollStatus() {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		// Check If horizontal scroll Is present or not.
		Boolean b1 = (Boolean) javascript
				.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
		
		// Check If vertical scroll Is present or not.
		Boolean b2 = (Boolean) javascript
				.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
		
		if (b1 == true && b2 == true) {
			System.out.println("Horizontal and vertical Scrollbar is present on page.");
		} else if (b1 == false && b2 == true) {
			System.out.println("Horizontal Scrollbar not present on page.");
			System.out.println("Vertical Scrollbar is present on page.");
		} else if (b1 == true && b2 == false) {
			System.out.println("Horizontal Scrollbar Is present on page.");
			System.out.println("Vertical Scrollbar not present on page.");
		} else if (b1 == false && b2 == false) {
			System.out.println("Horizontal and Vertical Scrollbar not present on page.");
		}
		System.out.println("<----------x--------x--------->");
	}
}
