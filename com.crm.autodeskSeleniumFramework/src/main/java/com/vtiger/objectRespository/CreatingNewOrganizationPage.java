package com.vtiger.objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodeskgenericutility.WebDriverUtility;

public class CreatingNewOrganizationPage  extends WebDriverUtility{
	//Declaring WeElements
	@FindBy(name="accountname")
	private WebElement usernameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//initilazation of webElements
	
	public CreatingNewOrganizationPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//creating getter method

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void getusername(String username,String industry)
	{
		usernameTextField.sendKeys(username);
		select(industryDropdown,industry);
		saveButton.click();
		
	}

	public void getusernameTextField(String username,WebDriver driver)
	{
		usernameTextField.sendKeys(username);
		
		saveButton.click();
		
		 WebDriverWait wait1=new WebDriverWait(driver,10);
			
		 wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
		
	}

}
