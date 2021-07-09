package headlessbrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessDemo {

	/*
	 * As name suggest it doesnt have any head it means you cannot see it but it
	 * runs internally.
	 * 
	 * In tech terms it is kind of web browser without a GUI.In other words it is a
	 * browser a piece of software that access a particular web page but doesnt show
	 * them to any human being.
	 * 
	 * We can use this just to provide the content of web pages to other
	 * program/script
	 * 
	 * HTMLUnit Driver This is currently the fastest and most lightweight impltn of
	 * WebDriver.As the name suggest this base on HtlmUnit.
	 * 
	 * Pros Fastest impltn of WebDriver. A pure java soltn and so it is platform
	 * independent. Supports JS.
	 * 
	 * Cons Emulates other brower's JS behavior.
	 * 
	 * 
	 * if we pass WebDriver driver = new HtmlUnitDriver(true); it will enabled the
	 * JS. by default it is disabled. Also it will not support screenshot
	 * functionality. to get that use PhantomJS driver incase of headless browser.
	 */

	@Test
	public void HTMLDriverExample() {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://learn-automation.com");
		System.out.println("Title of the page is " + driver.getTitle());

	}
}
