package baseclass;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestingClass extends BaseClass {
	
	@Test(description = "This will perfom valid login")
	public void loginIntoTheAppWithValidCred()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(description = "This will perfom in-valid login")
	public void loginIntoTheAppWithInvalidCred()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin12");
		driver.findElement(By.id("btnLogin")).click();
	}
}
