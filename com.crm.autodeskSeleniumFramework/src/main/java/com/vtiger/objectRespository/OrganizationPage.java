package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Declaring the WebElement
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createoranizationicon;
	
	//initialization of webElement
	 public OrganizationPage(WebDriver driver){
		 PageFactory.initElements(driver, this);
		
	}
	 //create getter method

	public WebElement getCreateoranizationicon() {
		return createoranizationicon;
	}
	//BussinessLogic
	public void clickonorganizationicon()
	{
		createoranizationicon.click();
	}

}
