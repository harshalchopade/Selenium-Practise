package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		//Code for launching the Chrome browser
				System.setProperty("webdriver.chrome.driver",
						"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
				
				//Handling the dropdown present in 'select' tag
				
				WebElement day_dropdown = driver.findElement(By.id("select-demo"));
				Select day = new Select(day_dropdown);
				
				//Get all option present in dropdown
				List<WebElement> allOptions = day.getOptions();
				
				for(WebElement eachOption : allOptions)
				{
					System.out.println(eachOption.getText());
				}
				
				//Select day by index
				day.selectByIndex(4);
				if(day.getFirstSelectedOption().getText().equalsIgnoreCase("Wednesday"))
					System.out.println("Selected option is "+day.getFirstSelectedOption().getText());
				
				//Select day by value
				day.selectByValue("Sunday");	
				if(day.getFirstSelectedOption().getText().equalsIgnoreCase("Sunday"))
				System.out.println("Selected option is "+day.getFirstSelectedOption().getText());

				//Select day by text
				day.selectByVisibleText("Tuesday");
				if(day.getFirstSelectedOption().getText().equalsIgnoreCase("Tuesday"))
				System.out.println("Selected option is "+day.getFirstSelectedOption().getText());

				driver.quit();
				
	}

}
