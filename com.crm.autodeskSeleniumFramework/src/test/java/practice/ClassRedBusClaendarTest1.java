package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRedBusClaendarTest1 { public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.easemytrip.com/");
	driver.findElement(By.xpath("//div[@id='dvfarecal']/child::input[@id='ddate']")).click();
	
	driver.findElement(By.xpath("//div[text()='Mar 2022']/ancestor::div[@class='box']/descendant::li[text()='18'] ")).click();
}

}
