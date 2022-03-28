package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage {
	@FindBy(className="lvtHeaderText")
	private WebElement headerText;
	
	public VendorInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderText() {
		return headerText;
	}

	public String verifyvendorpage()
	{
		 return headerText.getText();
	}
}
