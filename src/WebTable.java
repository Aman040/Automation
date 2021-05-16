
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

		WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			Thread.sleep(3000);
			
			//find row col count and data
			List<WebElement> rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
			System.out.println("Total no of rows are " + rows.size());
			List<WebElement> cols=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
			System.out.println("Total no. of cols are "+cols.size());
			WebElement cell=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
			System.out.println("Cell Value "+cell.getText());
			
			//scroll element
			WebElement loc=driver.findElement(By.xpath("//*[text()='HTML Table - Add a Caption']"));
			JavascriptExecutor obj=(JavascriptExecutor) driver;
			obj.executeScript("arguments[0].scrollIntoView();",loc);
		}

	}


