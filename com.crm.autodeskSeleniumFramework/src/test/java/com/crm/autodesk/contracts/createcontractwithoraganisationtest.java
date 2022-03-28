package com.crm.autodesk.contracts;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class createcontractwithoraganisationtest {
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
		/* step2: launch the browser*/
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
		/*step3:implicit wait*/
		web.waitPageLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		/*creating organization*/
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...\']")).click();
/*step4:creating orgname*/
		String org = excel.getDataFromExcel("org", 1, 0);
		int rd = jav.GetRandom();
		String orgname=org+rd;
		 driver.findElement(By.name("accountname")).sendKeys(orgname);
		 
		 driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		 
		 web.waitForElementVisibility(driver, driver.findElement(By.className("dvHeaderText")));
			
		 driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		 

			String name = excel.getDataFromExcel("contract", 1, 0);
			int rd1=jav.GetRandom();
			String lastname=name+rd1;
		
		 driver.findElement(By.name("lastname")).sendKeys(lastname);
		 /*switching the driver control to child window*/
		 String parent_window = driver.getWindowHandle();
		 driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();

		 String Title="Accounts";
		 web.switchToWindow(driver, Title);
		 driver.findElement(By.id("search_txt")).sendKeys(orgname);
		 driver.findElement(By.name("search")).click();
		 WebDriverWait wait=new  WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.urlContains("Accounts&action"));
		 driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		 /*switching back control to parent window*/
		 web.switchToWindow(driver, "Accounts");

		 String title="Contacts";
 web.switchToWindow(driver,title );

		 driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
			web.waitForElementVisibility(driver,driver.findElement(By.className("dvHeaderText") ));
			/*logging out of the application*/
			 WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			
			 web.mouseHover(driver, move);
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			 driver.quit();
		 
		 
}
}
