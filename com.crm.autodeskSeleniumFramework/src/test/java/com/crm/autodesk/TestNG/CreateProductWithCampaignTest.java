package com.crm.autodesk.TestNG;

import org.testng.annotations.Test;

import com.crm.autodesk.POM.CreatingNewCampaign;
import com.crm.autodeskgenericutility.BaseClass;
import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.vtiger.objectRespository.CreateCampaignPage;
import com.vtiger.objectRespository.CreateProductImageiconpage;
import com.vtiger.objectRespository.CreatingNewProductPage;
import com.vtiger.objectRespository.HomePage;

public class CreateProductWithCampaignTest extends BaseClass{
	@Test(groups= {"smokeTest","regression"})
	public void TestcreateProductWithCamapign() throws Throwable
	{
		ExcelUtility ExcUtil = new ExcelUtility();
		JavaUtility JaUtil = new JavaUtility();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnProductsLink();
		CreateProductImageiconpage productImage = new CreateProductImageiconpage (driver);
		productImage.clickonproductimageicon();
		String productName=ExcUtil.getDataFromExcel("pro", 1, 0);
		CreatingNewProductPage newproduct = new CreatingNewProductPage(driver);
		newproduct.createProduct(productName,driver);
		homepage.moreMenu(driver);
		
		CreateCampaignPage clickOnImage = new CreateCampaignPage(driver);
		clickOnImage.clickCreateCampaignimageicon();
		String CampaignName=ExcUtil.getDataFromExcel("pro", 4, 0);
		
		
		CreatingNewCampaign campaignname = new CreatingNewCampaign(driver);
		campaignname.creatingCampaign(CampaignName, driver, productName);
	}

}
