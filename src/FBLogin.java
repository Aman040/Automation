import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBLogin {
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		FBLogin obj=new FBLogin();
		obj.setup();
		//obj.login();
		obj.signup();
	}
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
	}
	public void login() {
		
		//Tag and ID CSS Selector
		 //Syntax :”css = tag#id”
		// Tag and Class
       // Syntax : “css = tag.class”
       //Tag and Attribute
       // Syntax : “css = tag[attribute=value]”
		
//		 WebElement username = driver.findElement(By.cssSelector("input#email"));
//	        WebElement password = driver.findElement(By.cssSelector("input#pass"));
//	        WebElement loginbutton = driver.findElement(By.cssSelector("button[name=login]"));
//	        username.sendKeys("abc@xyz.com");
//	        password.sendKeys("pwd");
//	        loginbutton.click();
		
		
		WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
		WebElement pass=driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement loginbtn=driver.findElement(By.xpath("//*[@name='login']"));	
		username.sendKeys("amancha@gmail.com");
		pass.sendKeys("aahs");
		loginbtn.click();
		
		//WebElement text=driver.findElement(By.xpath("//*[text()='Facebook helps you connect and share with the people in your life.']"));
		//Alternate
		//WebElement text=driver.findElement(By.xpath("//*[contains(text(),'people')]"));
		WebElement text=driver.findElement(By.xpath("//*[starts-with(text(),'Connect')]"));
	}
	public void signup() {
		
	
		
		//drop down Selection
		WebElement createnewbtn=driver.findElement(By.xpath("//*[text()='Create New Account']"));
		createnewbtn.click();
		WebElement daydropdown=driver.findElement(By.xpath("//*[@title='Day']"));
		Select day=new Select(daydropdown);
		day.selectByIndex(17);
		WebElement monthdropdown=driver.findElement(By.xpath("//*[@title='Month']"));
		Select month=new Select(monthdropdown);
		month.selectByValue("10");
		WebElement yeardropdown=driver.findElement(By.xpath("//*[@title='Year']"));
		Select year=new Select(yeardropdown);
		year.selectByValue("1996");
		
		//Radio button Selection
		WebElement GenderMale=driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		//Select  same element
		//WebElement GenderMale=driver.findElement(By.xpath("//input[@type='radio' and @value='1']//following::input[1]"));
		//WebElement GenderMale=driver.findElement(By.xpath("//input[@type='radio' and @value='1']//preceding::input[1]"));
		GenderMale.click();
		
		
	}
}
