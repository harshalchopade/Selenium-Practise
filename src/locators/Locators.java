package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;


public class Locators {

	public static void main(String[] args) {
		//Code for launching the Chrome browser
		  System.setProperty("webdriver.chrome.driver","D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://opensource-demo.orangehrmlive.com"); 
		  
		  /*
		   * Direct locators - id, class ,name
		   * Dynamic - xpath, css
		   * */
		  
		  /* Note
		   * '/' is an abbreviation of child::
		   
		   * '//' selects direct and indirect child nodes in the doc from the current node
		     and it is an abbreviation of descendant-or-self::
		     
		   * '*' selects all  element children of the context node
		   
		   * '.' selects the current context node. Abbreviation of self::node()
		   
		   *'..' selects the parent of the context node.Abbreviation of parent::node()
		   
		   *'@' selects the attribute of the context node.@ 
		    
		   A single slash '/' anywhere  in Xpath  signifies to look for the element immediately inside its parent element
		   A double slash '//' to look for any child or any grand-child element inside its parent element
		   
		   * */
		  
		  //1.id
		  WebElement uname = driver.findElement(By.id("txtUsername"));
		  uname.sendKeys("Admin");
		  
		  //2.name
		  driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		  
		  //3.classname but many time class name wont be unique
		  driver.findElement(By.className("button")).click();
		  
		  //4.xpath
		  driver.findElement(By.xpath("//span[@class='quickLinkText']")).click();
		  
		  //5.css
		  driver.findElement(By.cssSelector("#assignleave_txtEmployee_empName")).sendKeys("Harshal");;

		  //6.link text
		  driver.findElement(By.linkText("Welcome Paul")).click();

		  //7.partial link text
		  driver.findElement(By.partialLinkText("About")).click();
		  
		  //8.tag 
		  System.out.println(driver.findElements(By.tagName("img")).size());
		  
		  //9.ByAll
		  //It will be used when we have multiple attributes out of which anyone will be matched other will be ignored if match found
		  //Will be evaluated based on the order it mentioned ie left to right.
		  //If we are using implicit wait it will be applicable for all the locators mentioned.
		  //To use this locator we have to create ByAll constructor i.e new ByAll()
		  
		  driver.findElement(new ByAll(By.name("txtUsername"), By.id("txtUsername"),
				  By.xpath("//input[@id='txtUsername']"))).click();
		 
		  //10.ByIdorName
		  //It will be use when either we pass id or name.When both id and name are present but out of which
		  //we pass either one of them and it will check on the basis of value is it name or id and pass the value.
		  driver.findElement(new ByIdOrName("name")).sendKeys("test");
		  
		  //11.ByChained
		  //It will be used when there is parent child relationship
		  //driver.findElement(new ByChained(parent1, child1, child2).sendKeys("test");
		  
		  driver.quit();
		
	}

}
