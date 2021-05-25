import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		Thread.sleep(2000);	
		 TakesScreenshot TSObj = (TakesScreenshot) driver;
	        File image = TSObj.getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(image, new File("Output//test.png"));
			driver.get("https://www.facebook.com/");
			Thread.sleep(2000);	
			 TakesScreenshot TSObj1 = (TakesScreenshot) driver;
		        File image1 = TSObj1.getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(image1, new File("Output//test1.png"));

	}

}
