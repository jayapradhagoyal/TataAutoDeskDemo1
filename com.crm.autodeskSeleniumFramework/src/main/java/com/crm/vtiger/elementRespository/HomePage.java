package com.crm.vtiger.elementRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.autodeskgenericutility.WebDriverUtility;

/**
 * objectRepository homepage
 * @author Jayapradha
 *
 */

public class HomePage  extends WebDriverUtility{
	//Declaring webelement
	@FindBy(linkText="Leads")
	private WebElement LeadsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Signoutimageicon;
	

	@FindBy(linkText="Sign Out")
	private WebElement SignoutLink;
	
	//Initialization of webelemets
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);;
		
	}
	// creating getter methods

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getSignoutimageicon() {
		return Signoutimageicon;
	}

	public WebElement getSignoutLink() {
		return SignoutLink;
	}

	//Business logic
	/**
	 * this method is used to click on leads module
	 */
	public void clickOnLeadsModule()
	{
		LeadsLink.click();
	}
	/**
	 * this method is used to verify whether leads page is displayed or not
	 * @param driver
	 * @return
	 */
	public String urlVerification(WebDriver driver)
	{
		String Actualurl=driver.getCurrentUrl();
		return Actualurl;
	}
	/**
	 * this method is used to logout from the application
	 * @param driver
	 */
	public void logOut(WebDriver driver)
	{
		
		 mouseHover( driver,Signoutimageicon);
		 SignoutLink.click();
	}

	public void clickOrganizationLink() {
		// TODO Auto-generated method stub
		
	}
	
	}
	
	

