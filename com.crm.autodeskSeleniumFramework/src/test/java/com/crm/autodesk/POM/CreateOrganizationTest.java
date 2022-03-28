package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.vtiger.objectRespository.CreatingNewOrganizationPage;
import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.LoginPage;
import com.vtiger.objectRespository.OrganizationPage;

public class CreateOrganizationTest {
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
		driver.manage().window().maximize();
		driver.get(url);
		web.waitPageLoad(driver); 
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);


		// creating organization
		HomePage homepage = new HomePage(driver); 
		homepage.clickOrganizationLink();
	

		String industry = ExcUtil.getDataFromExcel("org", 1, 1);
		String orgname = ExcUtil.getDataFromExcel("org", 1, 0)+JaUtil.GetRandom();

		System.out.println(orgname);

		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage .clickonorganizationicon();

		CreatingNewOrganizationPage creatingorganization = new  CreatingNewOrganizationPage(driver);
		creatingorganization.getusername( orgname, industry);
		
		homepage.LogOut(driver);
		

}
}