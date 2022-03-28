package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//Declaring of WebElement
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreMenuOptionLink;
	
	@FindBy(name="Purchase Order")
	private WebElement purcahseOrderLink;
	
	@FindBy(name="Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	//initilization of webelements

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// creating getter methods
	public WebElement getMoreMenuOptionLink() {
		return moreMenuOptionLink;
	}


	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getPurcahseOrderLink() {
		return purcahseOrderLink;
	}
	
	
      public WebElement getProductsLink() {
		return ProductsLink;
	}

	public void clickOnPurchaseorderLink(WebDriver driver)
      {
    	  mouseHover( driver,moreMenuOptionLink);
    	  purcahseOrderLink.click();
    	  
      }
      
      public void clickOnvendorsLink(WebDriver driver)
      {
    	  mouseHover( driver,moreMenuOptionLink);
    	  vendorsLink.click();
    	  
      }
      
      public void clickOnProductsLink()
  	{
  		ProductsLink.click();
  	}
	
}
