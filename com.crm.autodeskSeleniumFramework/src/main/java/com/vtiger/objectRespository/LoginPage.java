package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericutility.FileUtility;

public class LoginPage {
	
	
	//Declaration of WebElement using @FindBy Annotation
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//Initialization of WebElement using Pagefactory class
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// Providing the Getter Methods

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	// creating Bussiness logic
	 public void login(String username,String password)
	 {
		 usernameTextField.sendKeys(username);
		 passwordTextField.sendKeys(password);
		 loginButton.click();
		 
	 }

}
