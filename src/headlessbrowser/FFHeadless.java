package headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FFHeadless {

	public static void main(String[] args) {
		
		FirefoxBinary ffBinary = new FirefoxBinary();
		ffBinary.addCommandLineOptions("--headless");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(ffBinary);
		
		System.setProperty("webdriver.gecko.driver", "D:/Software Setup/Selenium - Java/geckodriver-v0.29.0-win64/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.google.com");
		driver.quit();
	}
}
