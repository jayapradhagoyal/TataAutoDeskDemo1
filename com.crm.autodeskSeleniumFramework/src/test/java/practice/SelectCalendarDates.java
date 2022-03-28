package practice;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectCalendarDates {
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
	
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		LocalDateTime localdatetime = LocalDateTime.now();
		int day= localdatetime.getDayOfMonth();
		
	
		String month = localdatetime.getMonth().toString();
		String actualmonth=month.substring(0, 1).toUpperCase()+month.substring(1).toLowerCase();


		int year = localdatetime.getYear();
		String monthAndYear=actualmonth+" "+year;
	
		
		WebElement target = driver.findElement(By.xpath("//div[@class='landingContainer']"));
		//String month="May 2022";
		//String date="27";
	    Actions actions=new Actions(driver);
	    actions.moveToElement(target).click().perform();
	    driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	    driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
	    actions.moveToElement(target).click().perform();
	    driver.findElement(By.id("toCity")).click();
	    JavascriptExecutor jse=(JavascriptExecutor)driver;
	   WebElement toDestination = driver.findElement(By.xpath("//div[@class='calc60']/p[text()='Mumbai, India']"));
	   jse.executeScript("arguments[0].click;", toDestination);
	    
	    driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	   
	    driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
	    
	     
	   
	    
	  
	    
	    
	    driver.findElement(By.xpath("//a[text()='Search']")).click();
	    List<WebElement> allflights = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
	 
	       for (WebElement ele: allflights) {
	    	   System.out.println(ele.getText());
			
		}
	}

}
