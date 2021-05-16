import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	
	WebDriver driver=new ChromeDriver();;

	public static void main(String[] args) throws InterruptedException {
		LoginTest obj=new LoginTest();
		obj.setup();
		obj.login();
		obj.teardown();	
	}
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		//driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://www.simplilearn.com/");
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	public void login() throws InterruptedException {
		WebElement loginlink=driver.findElement(By.linkText("Log in"));
		loginlink.click();
		WebElement username=driver.findElement(By.name("user_login"));
		username.sendKeys("aaan@ah");
		WebElement password=driver.findElement(By.name("user_pwd"));
		password.sendKeys("ad11");
		WebElement check=driver.findElement(By.className("rememberMe"));
		check.click();
		WebElement loginbutton=driver.findElement(By.name("btn_login"));
		loginbutton.click();
		Thread.sleep(5000);
		WebElement errormsg = driver.findElement(By.id("msg_box"));
	    
        String actError = errormsg.getText();
        String expError = "The email or password you have entered is invalid.";
        
        if(actError.equals(expError)) {
        	System.out.println("Pass");
        }else {
        	System.out.println("Fail");
        }
	}
	public void teardown() {
		driver.quit();
	}

}
