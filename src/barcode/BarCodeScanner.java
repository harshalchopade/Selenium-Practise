package barcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

public class BarCodeScanner {
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://barcode.tec-it.com/en");
		String baseCodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(baseCodeURL);
		
		URL url = new URL(baseCodeURL);
		BufferedImage buffImage = ImageIO.read(url);
		
		/*
		 * LuminanceSource lumin = new BufferedImageLuminanceSource(buffImage);
		 * BinaryBitmap bmap = new BinaryBitmap(new HybridBinarizer(lumin)); Result
		 * reult= new MutliFormatReader().decode(bmap);
		 * System.out.println(result.getText());
		 */
	}

}
