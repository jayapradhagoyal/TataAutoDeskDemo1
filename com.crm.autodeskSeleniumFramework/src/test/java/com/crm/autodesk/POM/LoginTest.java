package com.crm.autodesk.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.vtiger.objectRespository.CreatingNewOrganizationPage;
import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.LoginPage;
import com.vtiger.objectRespository.OrganizationIformationPage;
import com.vtiger.objectRespository.OrganizationPage;


public class LoginTest {
	public static void main(String[] args) throws Throwable {
		FileUtility fil=new FileUtility();
		WebDriverUtility web=new WebDriverUtility();
		ExcelUtility ExcUtil=new ExcelUtility ();
		JavaUtility JaUtil=new JavaUtility();
		
		 String browser = fil.getPropertyKeyVAlue("browser");
		System.out.println(browser);
		String url = fil.getPropertyKeyVAlue("url");
		System.out.println(url);
		String username = fil.getPropertyKeyVAlue("username");
		System.out.println(username);
		String password = fil.getPropertyKeyVAlue("password");
		System.out.println(password);
		
	
		  WebDriver driver=new ChromeDriver();
		  driver.get(url);
		  web.waitPageLoad(driver); 
		  
		  LoginPage lp = new LoginPage(driver);
		 lp.login(username, password);
		String usernameTextfield= ExcUtil.getDataFromExcel("sheet1", 1, 0)+JaUtil.GetRandom();
		 
		String industry = ExcUtil.getDataFromExcel("sheet1", 1, 1);
			 HomePage homepage = new HomePage(driver); 
			 homepage.clickOrganizationLink();
			 
			 OrganizationPage organizationPage = new OrganizationPage(driver);
			 
			 organizationPage .clickonorganizationicon();
			 
			CreatingNewOrganizationPage creatingorganization = new  CreatingNewOrganizationPage(driver);
			 creatingorganization.getusername( usernameTextfield, industry);
			 
			OrganizationIformationPage organizationinfo = new OrganizationIformationPage(driver);
			 if(organizationinfo.headerText().contains(usernameTextfield))
			 {
				 System.out.println("PASS:");
			 }
			 else
			 {
				 System.out.println("FAIL:");
			 }
	
	  homepage.LogOut(driver);
	  
	  driver.quit();
	  
	  
	 
}
}
