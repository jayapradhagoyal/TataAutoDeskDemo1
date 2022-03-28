package com.crm.autodeskPurcahseorderPom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.vtiger.puchaseorderespository.ClickOnCreateProductImage;
import com.vtiger.puchaseorderespository.CreateNewVendorPage;
import com.vtiger.puchaseorderespository.CreatePurchaseOrderImagePage;
import com.vtiger.puchaseorderespository.CreatingNewproductPage;
import com.vtiger.puchaseorderespository.CreatingPurchaseOrderPage;
import com.vtiger.puchaseorderespository.HomePage;
import com.vtiger.puchaseorderespository.LoginPage;
import com.vtiger.puchaseorderespository.VendorInformationPage;
import com.vtiger.puchaseorderespository.VendorsPage;

public class TC_002 {
	public static void main(String[] args) throws Throwable {
		// creating the objects for generic Utility classes
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		WebDriverUtility web=new WebDriverUtility();
	String browser	=fu.getPropertyKeyVAlue("browser");
	System.out.println(browser);
	String url	=fu.getPropertyKeyVAlue("url");
	System.out.println(url);
	String username	=fu.getPropertyKeyVAlue("username");
	System.out.println(username);
	String password	=fu.getPropertyKeyVAlue("password");
	System.out.println(password);
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	String actualTitle=driver.getTitle();
	String expectedTitle=eu.getDataFromExcel("vendor" ,1, 1);
	if(actualTitle.equals(expectedTitle))
	{
		System.out.println("login page is successfully dispalyed :PASS");
	}
	else
	{
		System.out.println("login page is not dispalyed :FAIl");
	}

	LoginPage loginpage = new LoginPage(driver);
	loginpage.login(username, password);
	
String actualUrl=driver.getCurrentUrl();
String expextedUrl=eu.getDataFromExcel("vendor" ,1, 2);
if(actualUrl.contains(expextedUrl))
{
	System.out.println("Home page is successfully dispalyed :PASS");
}
else
{
	System.out.println("Home page is not dispalyed :FAIl");
}
	
	
	;
	HomePage homepage = new HomePage(driver);
	
	  homepage.clickOnProductsLink();
	  ClickOnCreateProductImage clickOnProductImage = new ClickOnCreateProductImage(driver);
	  
	  clickOnProductImage.clickonproductimageicon();
	  String product = eu.getDataFromExcel("pro", 1, 0)+ju.GetRandom();
	  CreatingNewproductPage productname = new CreatingNewproductPage(driver);
	  productname.createProduct(product);
	
	homepage.clickOnvendorsLink(driver);
	VendorsPage createvendarimage = new VendorsPage(driver);
	createvendarimage.clickOncreateVendorImg();
	String vendorName = eu.getDataFromExcel("vendor", 1, 0)+ju.GetRandom();
	CreateNewVendorPage vendorNametext = new CreateNewVendorPage(driver);
	vendorNametext.vendorName(vendorName);
	VendorInformationPage vendorInfo = new VendorInformationPage(driver);
	String actualtext=vendorInfo.verifyvendorpage();
	String expectedText=eu.getDataFromExcel("vendor" ,1, 3);
	if(actualtext.contains(expectedText))
	{
		System.out.println("vendor page is successfully created:PASS");
	}
	else
	{
		System.out.println("Home page is not created:FAIl");
	}
	
	homepage.clickOnPurchaseorderLink(driver);
	CreatePurchaseOrderImagePage createPurchaseImage = new CreatePurchaseOrderImagePage(driver);
	
	createPurchaseImage.ClickOnPurcahseImage();
	String actualpurchasePageUrl = driver.getCurrentUrl();
	String expectedpurchasePageUrl =eu.getDataFromExcel("vendor" ,1, 4);
	
	if(actualpurchasePageUrl.contains(expectedpurchasePageUrl))
	{
		System.out.println("purcahse page is successfully created:PASS");
	}
	else
	{
		
		System.out.println("purcahse page is not created:FAIl");
	

	}
  CreatingPurchaseOrderPage purchaseorder = new CreatingPurchaseOrderPage(driver);
  String vendorSubject = eu.getDataFromExcel("vendor", 4, 0);
  purchaseorder.purchaseOrder(vendorSubject, driver, vendorName);
  
  String billingAddress = eu.getDataFromExcel("vendor", 4, 1);
  String shippingAddress = eu.getDataFromExcel("vendor", 4, 2);
  purchaseorder.billingAddress(billingAddress);
  purchaseorder.shippingAddress(shippingAddress);
    String quantity = eu.getDataFromExcel("vendor", 4, 4);
   
 String price = eu.getDataFromExcel("vendor", 4, 3);
 
  purchaseorder.seletingProduct(driver, product,quantity,price);
  
  WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 web. waitForElementVisibility( driver,move);
	
	
	 Actions actions=new Actions(driver);
	 actions.moveToElement(move).perform();
	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
  

  
  
}
}