package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	//Declaring of webelements
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createcampaignimageicon;
	//initilization of webelements
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//creating getter method
	public WebElement getCreatecampaignimageicon() {
		return createcampaignimageicon;
	}
	
	public void clickCreateCampaignimageicon()
	{
		createcampaignimageicon.click();
	}

}
