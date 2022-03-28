package practice;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;

public class createcontractwithoraganisationtest {
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
		/*creating organization*/
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...\']")).click();
		 ExcelLib lib=new  ExcelLib();
		 Random ran=new Random();
		 int rd=ran.nextInt(1000);
		 String org= lib.getdata("org", 1, 0);
		 String orgname=org+rd;
		 driver.findElement(By.name("accountname")).sendKeys(orgname);
		 
		 driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		 /*creating contracts */
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
			
		 driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		 
		 ExcelLib lib1=new ExcelLib();
		 String name= lib1.getlastname("contract",1,0);
		 String lastname=name+rd;
		 System.out.println(lastname);
		
		 driver.findElement(By.name("lastname")).sendKeys(lastname);
		 /*switching the driver control to child window*/
		 String parent_window = driver.getWindowHandle();
		 driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		 Set<String> allwindowid = driver.getWindowHandles();
		 
		 Iterator <String>window=allwindowid .iterator();
		 while(window.hasNext())
		 {
			String childid= window.next();
			driver.switchTo().window(childid);
			if(driver.getTitle().equals("Accounts"))
			{
				break;
				
			}
		 }
		 driver.findElement(By.id("search_txt")).sendKeys(orgname);
		 driver.findElement(By.name("search")).click();
		 wait.until(ExpectedConditions.urlContains("Accounts&action"));
		 driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		 /*switching back control to parent window*/
		 Set<String> allwindowid1 = driver.getWindowHandles();
		 Iterator <String>window1=allwindowid1 .iterator();
		 while(window1.hasNext())
		 {
			String parentid= window1.next();
			driver.switchTo().window(parentid);
			if(driver.getTitle().equals("Contacts"))
			{
				break;
				
			}
		 }
		 

		 driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		 WebDriverWait wait1=new WebDriverWait(driver,10);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
			
			/*logging out of the application*/
			 WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			// wait1.until(ExpectedConditions.elementToBeClickable(move));
			
			 Actions actions=new Actions(driver);
			 actions.moveToElement(move).perform();
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 
		 
}
}
