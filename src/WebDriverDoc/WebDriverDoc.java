package WebDriverDoc;

public class WebDriverDoc {
	// WebDriver is an interface which is a child interface of SearchContext.
	// SearchContext is the top interface available in selenium.
	// SearchContext is extended by WebDriver and WebElement.
	// SearchContext is also implemented by ChromeDriver, FFDriver

	// SearchContext - findElement(),findElements() these are the only 2 abstract
	// methods available.
	// WebDriver - driver.close(),driver.get() etc. all are abstract methods and
	// findElement and findElements are Overridden methods only.

	//Now RemoteWebDriver class implements the WebDriver(I) here actual implementation
	//is provided for the methods in this class.
	//And then ChromiumDriver class extends the RemoteWebDriver class.
	
	//And then ChromeDriver class extends the ChromiumDriver class
	
	//RemoteWebDriver driver = new ChromeDriver();
	//It will be used when we want to run scripts on remote side i.e on saucelab, on hub, on cloud 
	//then use this because ChromeDriver() wont support this capabilities.
	//WebDriver driver = new RemoteWebDriver();
}
