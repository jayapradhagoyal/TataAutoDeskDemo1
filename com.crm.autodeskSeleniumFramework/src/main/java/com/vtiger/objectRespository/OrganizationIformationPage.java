package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationIformationPage {
	//Declaring the WebElement
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement target;
	//initialization of webelement
	public OrganizationIformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		
	}
	//create getter method
	public WebElement getTarget() {
		return target;
	}
	
	//verification
	
	public String headerText()
	{
	 String actualtext = target.getText();
	 return actualtext ;

	}
	
	

}
