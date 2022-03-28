package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePurchaseOrderImagePage {
	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseimage;
	
	public CreatePurchaseOrderImagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatePurchaseimage() {
		return createPurchaseimage;
	}
	
	public void ClickOnPurcahseImage()
	{
		createPurchaseimage.click();
	}

}
