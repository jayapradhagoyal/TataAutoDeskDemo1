package com.crm.autodesk.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskgenericutility.BaseClass;
import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.vtiger.objectRespository.CreatingNewOrganizationPage;
import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.OrganizationIformationPage;
import com.vtiger.objectRespository.OrganizationPage;

public class TestCreateOrganization extends BaseClass {
	@Test(groups= {"smokeTest"})
	public void createOrganization() throws Throwable
	{
		ExcelUtility ExcUtil = new ExcelUtility();
		JavaUtility JaUtil = new JavaUtility();
		HomePage homepage = new HomePage(driver);
			homepage.clickOrganizationLink();
			 
			 OrganizationPage organizationPage = new OrganizationPage(driver);
			 
			 organizationPage .clickonorganizationicon();
			 String industry = ExcUtil.getDataFromExcel("org", 1, 1);
				String expectedlHeaderText = ExcUtil.getDataFromExcel("org", 1, 0)+JaUtil.GetRandom();

				System.out.println(expectedlHeaderText);

				CreatingNewOrganizationPage creatingorganization = new  CreatingNewOrganizationPage(driver);
				creatingorganization.getusernameTextField(expectedlHeaderText,driver);
                   OrganizationIformationPage organizationInfopage = new OrganizationIformationPage(driver);
				
                  String actualHeaderText = organizationInfopage.headerText();
                 
                  System.out.println(actualHeaderText);
                  System.out.println(expectedlHeaderText);
        Assert.assertEquals(actualHeaderText.contains(expectedlHeaderText), true);
	}
	

}
