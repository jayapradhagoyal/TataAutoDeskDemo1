package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;
import scenarios28.ExcelLibrary;

public class contactstest {
	public static void main(String[] args) throws Throwable {
		FileInputStream fin=new FileInputStream("./src/main/resources/commonsdata/commonsdata.properties");
		Properties properties=new Properties();
		properties.load(fin);
		String browser = properties.getProperty("browser");
		System.out.println(browser);
		String url = properties.getProperty("url");
		System.out.println(url);
		String username = properties.getProperty("username");
		System.out.println(username);
		String password = properties.getProperty("password");
		System.out.println(password);
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
	}
		else
		{
			System.out.println("plse enter valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		Random ran=new Random();
		 int rd=ran.nextInt(1000);
		 ExcelLib lib=new ExcelLib();
		 String name= lib.getlastname("contract",1,0);
		 String lastname=name+rd;
		 System.out.println(lastname);
		 driver.findElement(By.name("lastname")).sendKeys(lastname);
		 
		 String actualurl = driver.getCurrentUrl();
		 if(actualurl.contains("Contacts"))
		 {
			 System.out.println("PASS::contracts successfully created");
		 }
		 else
		 {
			 System.out.println("FAIL::contracts not successfully created");
		 }
		 
		 driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		 WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
			
			// wait.until(ExpectedConditions.titdreContains("Accounts&parenttab"));
			 WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 wait.until(ExpectedConditions.elementToBeClickable(move));
			
			 Actions actions=new Actions(driver);
			 actions.moveToElement(move).perform();
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 
}
}
