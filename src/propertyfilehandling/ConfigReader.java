package propertyfilehandling;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	
	public ConfigReader()
	{
		try {
			File file = new File("./resources/Config.property");
			FileInputStream fis = new FileInputStream(file);
			
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getChromePath()
	{
		String path = pro.getProperty("ChromeDriver");
		return path;
	}
	
	public String getAppUrl()
	{
		return pro.getProperty("URL");
	}

}
