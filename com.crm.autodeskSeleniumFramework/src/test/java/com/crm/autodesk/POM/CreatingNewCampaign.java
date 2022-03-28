package com.crm.autodesk.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericutility.WebDriverUtility;

public class CreatingNewCampaign extends WebDriverUtility {
	//Declaring webelements
	@FindBy(name="campaignname")
	private WebElement campaignname; 
	
	@FindBy(css="img[src='themes/softed/images/select.gif']")
	private WebElement productimage;
	@FindBy(name="search_text")
	private WebElement searchTextfield;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	//initilization of webelements
	public CreatingNewCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//craeting getter methods 

	public WebElement getCampaignname() {
		return campaignname;
	}

	public WebElement getProductimage() {
		return productimage;
	}
	
	public void creatingCampaign(String campaignName,WebDriver driver,String productName)
	{
		campaignname.sendKeys(campaignName);
		productimage.click();
 switchToWindow(driver,"Products");
		 
 searchTextfield.sendKeys(productName);
			
			searchButton.click();
			
			
			 driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
			 
			 switchToWindow(driver, "Campaigns");
				saveButton.click();
	}
	
	public void creatingCampaignModule(String campaignName)
	{
		campaignname.sendKeys(campaignName);
		
				saveButton.click();
	}

	
	

}
