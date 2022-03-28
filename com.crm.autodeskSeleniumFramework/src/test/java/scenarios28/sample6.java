package scenarios28;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample6 {
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
		
		WebElement targetdropdown = driver.findElement(By.id("qccombo"));
		Select select =new Select(targetdropdown );
		select.selectByValue("Campaigns");
		Excelcamp camp=new Excelcamp();
	String campname	=camp.getdata("sheet1", 1, 5);
		
		
		driver.findElement(By.name("campaignname")).sendKeys(campname);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	String parentwindow = driver.getWindowHandle();
	Set<String> allwindowid = driver.getWindowHandles();
	for (String window : allwindowid) {
		if(!window.equals(parentwindow)) {
			driver.switchTo().window(window);
			break;
		}
		
	}
	driver.findElement(By.linkText("laptop217")).click();
	
	driver.switchTo().window(parentwindow);
	driver.findElement(By.name("button")).click();

	Actions actions=new Actions(driver);
	Thread.sleep(10000);
	 WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
		Thread.sleep(20000);
		actions.moveToElement(target).perform();
		Thread.sleep(20000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("thankyou for using the applocation");
}
}
