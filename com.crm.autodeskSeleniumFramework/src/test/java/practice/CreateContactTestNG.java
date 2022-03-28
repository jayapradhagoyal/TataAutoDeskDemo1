package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestNG {
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objectArray = new Object[2][2];
		objectArray[0][0]="Goyal";
		objectArray[0][1]="9448292776";
		objectArray[1][0]="shree";
		objectArray[1][1]="987654321";
		return objectArray;
				
	}
	@Test(dataProvider="getData")
	public void sample( String lastname,String contactname) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(contactname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebDriverWait wait=new 	WebDriverWait(driver,10);
		WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wait.until(ExpectedConditions.elementToBeClickable(move));
		
		 Actions actions=new Actions(driver);
		 actions.moveToElement(move).perform();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit(); 
	}

}
