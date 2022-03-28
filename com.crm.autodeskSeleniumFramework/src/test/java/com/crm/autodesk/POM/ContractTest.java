package com.crm.autodesk.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.vtiger.objectRespository.ContractInformationPage;
import com.vtiger.objectRespository.CreateContractPage;
import com.vtiger.objectRespository.CreateNewContractPage;
import com.vtiger.objectRespository.CreatingNewOrganizationPage;
import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.LoginPage;
import com.vtiger.objectRespository.OrganizationPage;

public class ContractTest {
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
	

		String industry = ExcUtil.getDataFromExcel("sheet1", 1, 1);
		String orgname = ExcUtil.getDataFromExcel("Sheet1", 1, 0)+JaUtil.GetRandom();

		System.out.println(orgname);

		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage .clickonorganizationicon();

		CreatingNewOrganizationPage creatingorganization = new  CreatingNewOrganizationPage(driver);
		creatingorganization.getusername( orgname, industry);
		web.waitForElementVisibility(driver, driver.findElement(By.className("dvHeaderText")));

		// creating contracts with organization 
		homepage.clickContractsLink();


		CreateContractPage createcontract = new CreateContractPage(driver);

		createcontract.createcontract();
		String lastname = ExcUtil.getDataFromExcel("sheet1", 1, 2);
		CreateNewContractPage newcontract = new  CreateNewContractPage(driver);
		newcontract .getData(lastname);
		System.out.println(orgname);

		newcontract.searchtext(driver, orgname);
	ContractInformationPage contractinfo = new ContractInformationPage(driver);
		if(contractinfo.headerText().contains(lastname))
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