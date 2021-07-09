package headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("window-size=1400,800");
		option.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.netmeds.com/customer/account/login");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
