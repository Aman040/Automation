package TestNG;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners(TestNGListeners.class)
public class LoginTest {
	
	WebDriver driver=new ChromeDriver();
	
	XSSFWorkbook workbook;
	XSSFSheet sheet1;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://www.simplilearn.com/");
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		FileInputStream fin=new FileInputStream("exceldata.xlsx");
		workbook=new XSSFWorkbook(fin);
		sheet1=workbook.getSheetAt(0);
	}
	
	@Test
	@Parameters({"uname","pass"})
	public void login(String userVal,String passVal ) throws InterruptedException {
		WebElement loginlink=driver.findElement(By.linkText("Log in"));
		loginlink.click();
		WebElement username=driver.findElement(By.name("user_login"));
		
		userVal=sheet1.getRow(0).getCell(0).getStringCellValue();
		username.sendKeys(userVal);
		
		WebElement password=driver.findElement(By.name("user_pwd"));
		
		passVal=sheet1.getRow(0).getCell(1).getStringCellValue();
		password.sendKeys(passVal);
		WebElement check=driver.findElement(By.className("rememberMe"));
		check.click();
		WebElement loginbutton=driver.findElement(By.name("btn_login"));
		loginbutton.click();
		Thread.sleep(5000);
		WebElement errormsg = driver.findElement(By.id("msg_box"));
	    
        String actError = errormsg.getText();
        String expError = "The email or password you have entered is invalid.";
        
//        if(actError.equals(expError)) {
//        	System.out.println("Pass");
//        }else {
//        	System.out.println("Fail");
//        }
        
        Assert.assertEquals(actError,expError);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
