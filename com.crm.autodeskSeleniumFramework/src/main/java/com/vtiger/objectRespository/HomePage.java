package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericutility.WebDriverUtility;
/**
 * Object Elementary for HomePage
 * @author Jayapradha
 *
 */

public class HomePage  extends WebDriverUtility{
	//Declaration of the Web Elements
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Signoutimageicon;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement target;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreMenu;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignoutLink;
	
	
	//initialization of WebElements
	public HomePage( WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// using getter method
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getMoreMenu() {
		return moreMenu;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getSignoutimageicon() {
		return Signoutimageicon;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getSignoutLink() {
		return SignoutLink;
	}
	
	public WebElement getTarget() {
		return target;
	}
	
	// create BussinessLogic
	
	public void clickOnProductsLink()
	{
		ProductsLink.click();
	}
	public void clickOrganizationLink()
	{
		organizationLink.click();
	}
	public void clickContractsLink()
	{
		ContactsLink.click();
	}
	
	
	public void moreMenu(WebDriver driver)
	{
		mouseHover(driver,moreMenu);
		campaignsLink.click();
	}

	public void LogOut(WebDriver driver)
	
	{
			 
		
		mouseHover(driver,Signoutimageicon);
		SignoutLink.click();
		driver.quit();
	}

	
}
