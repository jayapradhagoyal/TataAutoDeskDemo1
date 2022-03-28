package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassCalendarTest1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/flights/");
		String month="May 2022";
		String date="19";
		
		Actions action=new Actions(driver);
		action.moveByOffset(0, 0).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		for(;;)
		{
		try
		{
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"'] ")).click();
		break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		
	
	}
		}


}
}
