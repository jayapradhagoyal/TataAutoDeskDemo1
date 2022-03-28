package practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SampleTest {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		Random rd=new Random();
		int rand = rd.nextInt();
		String orgname = "testyanta"+rand;
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String actualtext = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
	if(actualtext.contains(orgname))
	{
		System.out.println("PASS:");
	}
		
	else
	{
		System.out.println("FAIL");
	}
	Actions actions=new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG\']"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	}

}
