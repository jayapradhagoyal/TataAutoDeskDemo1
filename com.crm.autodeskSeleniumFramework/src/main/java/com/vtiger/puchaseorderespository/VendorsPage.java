package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendorImg;
	
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateVendorImg() {
		return createVendorImg;
	}
	

	public void clickOncreateVendorImg()
	{
		createVendorImg.click();
	}
}
