package com.crm.autodeskgenericutility;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;

import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
@Listeners(com.crm.autodeskgenericutility.ListnerImplementationClass.class)

public class BaseClass {
	public WebDriver driver = null;
	public FileUtility FileUtil = new FileUtility();
	public ExcelUtility excelutil = new ExcelUtility();
	public WebDriverUtility webUtil = new WebDriverUtility();
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "smokeTest", "regression", "systemTest" })

	public void beforesuite() {
		System.out.println("DatabaseConnection");
	}

	@BeforeTest(groups = { "smokeTest", "regression", "systemTest" })

	public void beforeTest() {
		System.out.println("ParallelConnection");
	}


	@BeforeClass(groups = { "smokeTest", "regression", "systemTest" })
	public void beforeClass() throws Throwable {
	
		

		
		String browserName = FileUtil.getPropertyKeyVAlue("browser");
		 String url=FileUtil.getPropertyKeyVAlue("url");
		  
		  if( browserName.equalsIgnoreCase("chrome")) { 
			  driver=new ChromeDriver(); 
			  }
		  else if(browserName.equalsIgnoreCase("Firefox")) { 
			  driver=new FirefoxDriver(); 
		  } else if(browserName.equalsIgnoreCase("opera"))
		  { 
			  driver=new OperaDriver(); 
		  }
		  else
			  {
			  System.out.println("Browser incompatible"); 
			  }
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sDriver=driver;
}

	
  
	@BeforeMethod(groups = { "smokeTest", "regression", "systemTest" })

	public void bm(XmlTest xml) throws Throwable {
	 
	String userName = FileUtil.getPropertyKeyVAlue("username");
	String password = FileUtil.getPropertyKeyVAlue("password");
		System.out.println(userName);
		System.out.println(password);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(userName, password);
	}

	@AfterMethod(groups = { "smokeTest", "regression", "systemTest" })

	public void am() {
		HomePage homepage = new HomePage(driver);

		homepage.LogOut(driver);
	}

	@AfterClass(groups = { "smokeTest", "regression", "systemTest" })
	public void ac() {
		driver.quit();
		System.out.println("closes the browser");
	}

	@AfterTest(groups = { "smokeTest", "regression", "systemTest" })

	public void at() {
		System.out.println("clses parallelexecution");
	}

	@AfterSuite(groups = { "smokeTest", "regression", "systemTest" })

	public void as() {
		System.out.println("closes Database Connectivity");
	}
}
