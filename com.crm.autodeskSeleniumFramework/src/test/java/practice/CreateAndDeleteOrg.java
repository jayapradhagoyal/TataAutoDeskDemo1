package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
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

public class CreateAndDeleteOrg {
	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		WebDriverUtility web=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility ();
		JavaUtility jav=new JavaUtility();
		String browser = fu.getPropertyKeyVAlue("browser");
		String url = fu.getPropertyKeyVAlue("url");
		String username = fu.getPropertyKeyVAlue("username");
		String password = fu.getPropertyKeyVAlue("password");
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
			
		driver.get(url);
		driver.manage().window().maximize();
		web.waitPageLoad(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String usernametext = eu.getDataFromExcel("org", 4, 0)+jav.GetRandom();
		driver.findElement(By.name("accountname")).sendKeys(usernametext);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Navigation navigate = driver.navigate();
		WebElement ele = driver.findElement(By.linkText("Organizations"));
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.stalenessOf(ele));
		driver.findElement(By.linkText("Organizations")).click();
		
		
		
	

	for(;;)
	{
		try
		{
			driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+usernametext+"']")).click();
			break;  
			
		}
		catch(Exception e)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
		}
	}
	driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
	driver.switchTo().alert().accept();
	WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 wait.until(ExpectedConditions.elementToBeClickable(move));
	
	 Actions actions=new Actions(driver);
	 actions.moveToElement(move).perform();
	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
