package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.vtiger.objectRespository.CreateCampaignPage;
import com.vtiger.objectRespository.CreateProductImageiconpage;
import com.vtiger.objectRespository.CreatingNewProductPage;
import com.vtiger.objectRespository.HomePage;
import com.vtiger.objectRespository.LoginPage;

public class CampaignsText {
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
	
	homepage.LogOut(driver);
}
}
