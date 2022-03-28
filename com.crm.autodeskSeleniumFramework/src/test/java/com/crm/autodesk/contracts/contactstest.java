package com.crm.autodesk.contracts;

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

public class contactstest {
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
		/* step2:launch the browser*/
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
		web.waitPageLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		/*lastname*/
		String name = excel.getDataFromExcel("contract", 1, 0);
		int rd = jav.GetRandom();
		String lastname = name+rd;
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
		/*explicit wait*/
		 WebElement target = driver.findElement(By.className("dvHeaderText"));
		 web.waitForElementVisibility(driver, target);
			
			// wait.until(ExpectedConditions.titdreContains("Accounts&parenttab"));
			 WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 web.waitForElementVisibility(driver, move);
			
			/*logout*/
			 web.mouseHover(driver, move);
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 
}
}
