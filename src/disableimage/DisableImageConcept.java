package disableimage;

import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DisableImageConcept {

	//Chrome
	public static void disableImageOnChrome(ChromeOptions options) {
		HashMap<String, Object> img = new HashMap<String, Object>();
		img.put("images", 2);
		HashMap<String, Object> pref = new HashMap<String, Object>();
		pref.put("profile.default_content_setting_values", img);
		options.setExperimentalOption("pref", pref);
	}

	//FF
	public static void disableImageOnFF(FirefoxOptions options) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
	}
	
	public static void main(String[] args) {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		disableImageOnChrome(options);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// Start application
		driver.get("http://amazon.in");
	}
}
