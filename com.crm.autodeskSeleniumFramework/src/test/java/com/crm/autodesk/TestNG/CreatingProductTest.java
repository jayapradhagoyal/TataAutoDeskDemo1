package com.crm.autodesk.TestNG;

import org.testng.annotations.Test;

import com.crm.autodeskgenericutility.BaseClass;
import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.vtiger.objectRespository.CreateProductImageiconpage;
import com.vtiger.objectRespository.CreatingNewProductPage;
import com.vtiger.objectRespository.HomePage;

public class CreatingProductTest extends BaseClass {
	@Test(groups={"smokeTest","regression","systemTest"})
	public void TestProduct() throws Throwable
	{
		FileUtility fil=new FileUtility();
		JavaUtility jav=new JavaUtility();
		ExcelUtility excel=new ExcelUtility();
		WebDriverUtility web=new WebDriverUtility();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnProductsLink();
		CreateProductImageiconpage productImage = new CreateProductImageiconpage (driver);
		productImage.clickonproductimageicon();
		String productName=excel.getDataFromExcel("pro", 1, 0);
		CreatingNewProductPage newproduct = new CreatingNewProductPage(driver);
		newproduct.createProduct(productName,driver);
		
		
	}

}
