package scenarios28;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.poifs.crypt.temp.AesZipFileZipEntrySource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;

public class Sample1 {
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...\']")).click();
		 ExcelLib lib=new  ExcelLib();
		 Random ran=new Random();
		 int rd=ran.nextInt(1000);
		 String org= lib.getdata("sheet1", 1, 0);
		 String orgname=org+rd;
		 driver.findElement(By.name("accountname")).sendKeys(orgname);
		 driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		 Thread.sleep(5000);
		 
		 Actions actions=new Actions(driver);
		 WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
			Thread.sleep(5000);
			actions.moveToElement(target).perform();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("thankyou for using the applocation");
			}
	
	
	
		
}