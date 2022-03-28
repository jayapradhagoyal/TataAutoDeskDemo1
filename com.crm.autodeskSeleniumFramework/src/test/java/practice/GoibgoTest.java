package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
/**
 * 
 * this class to book hotel for 1 adult & 2children and printing all hotel names
 * @author Jayapradha
 *
 */

public class GoibgoTest {
	public static void main(String[] args) throws Throwable {
		// creating Object for generic utility classes
		FileUtility fu=new FileUtility();
		WebDriverUtility web=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility ();
		JavaUtility jav=new JavaUtility();
		WebDriver driver=new ChromeDriver();
		
		//opening the browser
		driver.get("https://www.goibibo.com/hotels/");
		
		//clicking on radio button
		
		driver.findElement(By.xpath("//h4[text()='India']/parent::div/child::input[@type='radio']")).click();
		
		// entering text and selecting from autosuggestion
		String place = eu.getDataFromExcel("goibo", 1, 1);
			driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys(place);
		Thread.sleep(1000)	;
		driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys(Keys.ARROW_DOWN);
		
		driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys(Keys.ENTER);
	
		// clicking on calendar and selecting the dates
		driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
	driver.findElement(By.xpath("//span[text()='March 2022']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='31']")).click();
	driver.findElement(By.xpath("//span[text()='April 2022']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='1']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).click();
	driver.findElement(By.xpath("//span[text()='Adults']/parent::div/div/span[text()='-']")).click();
	
	//adding the childrens to the list
	for(int i=0;i<=1;i++)
	{
	driver.findElement(By.xpath("//span[text()='Children']/parent::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/child::div/span[text()='+']")).click();
	
	}
	driver.findElement(By.xpath("//p[text()='1']/parent::div/div/span")).click();
	Thread.sleep(1000);
	
	
	driver.findElement(By.xpath("//ul[@class='PaxWidgetstyles__ChildDropdownWrap-sc-gv3w6r-9 cuOfFa']/li[text()='4']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p[text()='2']/parent::div/div/span")).click();
	driver.findElement(By.xpath("//ul[@class='PaxWidgetstyles__ChildDropdownWrap-sc-gv3w6r-9 cuOfFa']/li[text()='7']")).click();
	driver.findElement(By.xpath("//button[text()='Done']")).click();
	Thread.sleep(1000);
	
	// clicking on search button
	
	driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
	Thread.sleep(1000);
	
	// getting all the hotels available from the List
   List<WebElement> allhotels = driver.findElements(By.xpath("//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 bjZxoj']"));

	
	 for (WebElement webElement : allhotels) {
	  System.out.println("List of hotel names:"+webElement.getText());
	 
	  }
	 
	}
}
