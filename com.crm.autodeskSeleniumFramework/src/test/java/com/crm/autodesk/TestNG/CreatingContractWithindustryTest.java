package com.crm.autodesk.TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskgenericutility.BaseClass;
import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.vtiger.objectRespository.ContractInformationPage;
import com.vtiger.objectRespository.CreateContractPage;
import com.vtiger.objectRespository.CreateNewContractPage;
import com.vtiger.objectRespository.CreatingNewOrganizationPage;
import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.OrganizationPage;

public class CreatingContractWithindustryTest  extends BaseClass{
	@Test
	public void createWithindustry() throws Throwable
	{
		
		ExcelUtility ExcUtil = new ExcelUtility();
		JavaUtility JaUtil = new JavaUtility();
		webUtil=new WebDriverUtility();
		// creating organization
				HomePage homepage = new HomePage(driver); 
				homepage.clickOrganizationLink();
			

				String industry = ExcUtil.getDataFromExcel("org", 1, 1);
				String orgname = ExcUtil.getDataFromExcel("org", 1, 0)+JaUtil.GetRandom();

				

				OrganizationPage organizationPage = new OrganizationPage(driver);
				organizationPage .clickonorganizationicon();

				CreatingNewOrganizationPage creatingorganization = new  CreatingNewOrganizationPage(driver);
				creatingorganization.getusername( orgname, industry);
				webUtil.waitForElementVisibility(driver, driver.findElement(By.className("dvHeaderText")));

				// creating contracts with organization 
				homepage.clickContractsLink();


				CreateContractPage createcontract = new CreateContractPage(driver);

				createcontract.createcontract();
				String expectedText = ExcUtil.getDataFromExcel("sheet2", 1, 2);
				System.out.println(expectedText);
				CreateNewContractPage newcontract = new  CreateNewContractPage(driver);
				newcontract .getData(expectedText);
			

				newcontract.searchtext(driver, orgname);
			//ContractInformationPage contractinfo = new ContractInformationPage(driver);
			//String actualText = contractinfo.headerText();
			//System.out.println(actualText);
				//System.out.println(expectedText);

	}

}
