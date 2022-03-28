package com.crm.vtiger.elementRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * ObjectRepository for LeadsPage
 * @author Jayapradha
 *
 */

public class LeadsPage {
	//Declaring webelements
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadsIcon;
	
	
	//initilization of wedelement
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//creating getter method
	public WebElement getCreateLeadsIcon() {
		return createLeadsIcon;
	}
	/**
	 *this method is used to click on create lead image icon
	 * 
	 */
	
	public void createLeadIcon()
	{
		createLeadsIcon.click();
	}
	/**
	 * this method is used to verify whether create lead image icon is clicked
	 * @param driver
	 * @return
	 */
	public String leadsTitleVerification(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		return actualTitle;
	}
	
	

}
