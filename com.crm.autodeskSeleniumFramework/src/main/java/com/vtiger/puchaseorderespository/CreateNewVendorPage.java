package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	@FindBy(name="vendorname")
	private WebElement vendorNameTextfield;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorNameTextfield() {
		return vendorNameTextfield;
		
	}
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public void vendorName(String firstname)
	{
		vendorNameTextfield.sendKeys(firstname);
		saveButton.click();
	}
	

}
