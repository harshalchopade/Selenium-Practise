package automateAngularApp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class AutomateAngularAppConcept {
	/*
	 * We can use selenium webdriver to automate Angular app with help third party API/lib
	 * call ngWebDriver developed by paul.
	 * Angular JS based app used for SPA where data is very dynamic, htm content is dynamic and it it
	 * used with angular framwork.
	 * Angular is a javascript framework provided by google.
	 * 
	 *  In a typical web app we have seen we have id, class, name locators
	 *  But in Angular app there are some different contents are available like
	 *  ng-binding, ng-model, ng-options it options like this present then it is Angular app.
	 *  
	 *  
	 *  We have protractor to automate Angular app but for it we have to use JS and Typescript.
	 *  Protractor with JS is nothing but there is webdriver js binding is available on top of that they created
	 *  wrapper internally they are calling webdriver js only on top of that they created protector
	 *  which support multiple locators but for that we have write script in JS only.
	 *  
	 *  Angular JS based app  will be difficult to automate with webdriver java (sync issue) because
	 *  Angular renders dynamic content when we click on button, enter text
	 *  there is an action render behind the scene and one req will send to server
	 *  will get the response for post/get call by the time everything happening
	 *  in the backend so UI dev they write the custom js code to 
	 *  get the status of req, once we get the response form server result will be show on UI. 
	 *  
	 *  With this situation our normal webdriver java wont work. syncissue
	 *  Locator angular using we dont have support for that.
	 *  
	 *  For this we have to ngWebDriver bcz it is written in java.
	 *  
	 *  git clone https://github.com/juliemr/protractor-demo.git
		cd protractor-demo
		npm install
		npm start
	 */

	static WebDriver driver;
	static NgWebDriver ngDriver;
	static JavascriptExecutor jsDriver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		jsDriver = (JavascriptExecutor)driver;
		ngDriver = new NgWebDriver(jsDriver);
		driver.manage().window().maximize();
		driver.get("http://localhost:3456/");
		ngDriver.waitForAngularRequestsToFinish(); // to wait for the request to be completed
		
		//Locator creation
		
		//HTML CODE
		//<input ng-model="first" type="text" class="input-small ng-pristine ng-valid ng-touched">
		//here ng-model="first" is using we have to use below property/syntax
		
		ByAngularModel first = ByAngular.model("first");
		ByAngularModel last = ByAngular.model("second");
		ByAngularModel operator = ByAngular.model("operator");
		ByAngularButtonText goBtn = ByAngular.buttonText("Go!");
		
		//Normal locator
		By result = By.tagName("h2");
		
		driver.findElement(first).sendKeys("10");
		driver.findElement(last).sendKeys("20");
		driver.findElement(operator).sendKeys("+");
		driver.findElement(goBtn).click();
		ngDriver.waitForAngularRequestsToFinish();
		
		String out = driver.findElement(result).getText();
		System.out.println(out);
		driver.quit();
	}
	
	

}
