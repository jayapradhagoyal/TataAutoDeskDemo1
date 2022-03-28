package com.crm.autodesk.products;

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

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;
import scenarios28.ExcelLibrary;

public class createproducttest {
	public static void main(String[] args) throws Throwable {
/* step1:create objects for generic library*/
		
		FileUtility fil=new FileUtility();
		JavaUtility jav=new JavaUtility();
		ExcelUtility excel=new ExcelUtility();
		WebDriverUtility web=new WebDriverUtility();
		
		String browser = fil.getPropertyKeyVAlue("browser");
		System.out.println(browser);
		String url = fil.getPropertyKeyVAlue("url");
		System.out.println(url);
		
		String username = fil.getPropertyKeyVAlue("username");
		System.out.println(username);
		String password = fil.getPropertyKeyVAlue("password");
		System.out.println(password);
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		

			
			driver = new FirefoxDriver();
		
	}
		else
		{
			System.out.println("plse enter valid browser");
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		web.waitPageLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.navigate().to("http://localhost:8888/index.php?module=Products&action=index");
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
//		
//		Random ran=new Random();
//		 int rd=ran.nextInt(1000);
//		 ExcelLib lib=new ExcelLib();
//		 String product=lib.getproductname("pro", 1, 0);
		int rd = jav.GetRandom();
		String product = excel.getDataFromExcel("pro", 1, 0);
		 String productname=product+rd;
		 driver.findElement(By.name("productname")).sendKeys(productname);
		
//		 GetData gdt=new GetData();
//		 String sysdate = gdt.GetSystemDate();
//		
		 String sysdate = jav.getsystemDateWithFormat();
		 driver.findElement(By.name("expiry_date")).sendKeys(sysdate);
		
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		// WebDriverWait wait=new  WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("lvtHeaderText"))));
		web.waitForElementVisibility(driver,driver.findElement(By.className("lvtHeaderText")) );
		 
//	Actions actions=new Actions(driver);
//		
		 WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//			
//				
//				actions.moveToElement(target).perform();
//				
		web.mouseHover(driver, target);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("thankyou for using the applocation");
	}
}



