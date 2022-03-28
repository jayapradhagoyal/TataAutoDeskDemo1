 package com.vtiger.objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.autodeskgenericutility.WebDriverUtility;
/**
 * object for Create new contract page
 * @author jayapradha
 *
 */

public class CreateNewContractPage extends WebDriverUtility {

	//Declaring WebElement
	@FindBy(name="lastname")
	private WebElement lastnametextfield;
	
	@FindBy(id="search_txt")
	private WebElement searchtextbox;

	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(css="img[src='themes/softed/images/select.gif']")
	
private WebElement createorganisationselecticon;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	

	// initilization of webelement
	public CreateNewContractPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//create getter methods

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void getData( String lastname)
	{
		lastnametextfield.sendKeys(lastname);
		 createorganisationselecticon.click();
		
		 
		
		
		
		
	}
	
	public WebElement getLastnametextfield() {
		return lastnametextfield;
	}

	public WebElement getSearchtextbox() {
		return searchtextbox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCreateorganisationselecticon() {
		return createorganisationselecticon;
	}

	public void searchtext(WebDriver driver,String orgname ) throws Throwable
	{
		 switchToWindow(driver,"Accounts");
		 
		 searchtextbox.sendKeys(orgname);
			
			searchButton.click();
			
			
			 driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			 
			 switchToWindow(driver, "Contacts");

			//	WebDriverWait wait=new WebDriverWait(driver,10);
				
				
				//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
				
				Thread.sleep(5000);
				saveButton.click();

	}
			
		
	}

