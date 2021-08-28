package dataprovider;

import org.testng.annotations.DataProvider;

public class DPClass {
  	@DataProvider(name = "test-data")
  	public static Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"Lambda Test"},{"Automation"}
        	};
  	}
}
