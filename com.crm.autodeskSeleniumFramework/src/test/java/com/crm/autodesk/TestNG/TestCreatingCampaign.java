package com.crm.autodesk.TestNG;

import org.testng.annotations.Test;

import com.crm.autodesk.POM.CreatingNewCampaign;
import com.crm.autodeskgenericutility.BaseClass;
import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.vtiger.objectRespository.CreateCampaignPage;
import com.vtiger.objectRespository.HomePage;

public class TestCreatingCampaign extends BaseClass {
	@Test(groups="systemTest")
	
	public void TestCreatingCampaign() throws Throwable
	{
	ExcelUtility ExcUtil = new ExcelUtility();
	JavaUtility JaUtil = new JavaUtility();
	
		HomePage homepage = new HomePage(driver);
		homepage.moreMenu(driver);
		
		CreateCampaignPage clickOnImage = new CreateCampaignPage(driver);
		clickOnImage.clickCreateCampaignimageicon();
		String CampaignName=ExcUtil.getDataFromExcel("pro", 4, 0);
		
		
		CreatingNewCampaign campaignname = new CreatingNewCampaign(driver);
		campaignname.creatingCampaignModule(CampaignName);
	}

}
