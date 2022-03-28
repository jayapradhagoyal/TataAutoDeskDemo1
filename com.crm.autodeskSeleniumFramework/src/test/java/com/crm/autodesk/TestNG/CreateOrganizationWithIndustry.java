package com.crm.autodesk.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskgenericutility.BaseClass;
import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.vtiger.objectRespository.CreatingNewOrganizationPage;
import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.OrganizationPage;
import com.vtiger.objectRespository.Organizationwithindustry;

public class CreateOrganizationWithIndustry extends BaseClass {
	@Test(groups="smokeTest")
	public void CreateOrganizationWithIndustry() throws Throwable
	{
	ExcelUtility ExcUtil = new ExcelUtility();
	JavaUtility JaUtil = new JavaUtility();
	HomePage homepage = new HomePage(driver);
		homepage.clickOrganizationLink();
		 
		 OrganizationPage organizationPage = new OrganizationPage(driver);
		 
		 organizationPage .clickonorganizationicon();
		 String industry = ExcUtil.getDataFromExcel("org", 1, 1);
			String orgname = ExcUtil.getDataFromExcel("org", 1, 0)+JaUtil.GetRandom();

			System.out.println(orgname);

			CreatingNewOrganizationPage creatingorganization = new  CreatingNewOrganizationPage(driver);
			creatingorganization.getusername( orgname, industry);
			Organizationwithindustry organizationwithindustry = new  Organizationwithindustry (driver);

			String actualText = organizationwithindustry.industryInfo();
			
			Assert.assertEquals(actualText, industry);
	}

}
