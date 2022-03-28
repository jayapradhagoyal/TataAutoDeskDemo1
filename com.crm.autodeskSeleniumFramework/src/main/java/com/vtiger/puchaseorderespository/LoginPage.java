package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *ObjectRespository for login page
 * @author Jayapradha
 *
 */

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
		/**
		 * this method will login to the application
		 * @param username
		 * @param password
		 */
		// creating Bussiness logic
		 public void login(String username,String password)
		 {
			 usernameTextField.sendKeys(username);
			 passwordTextField.sendKeys(password);
			 loginButton.click();
			 
		 }
		 /**
		  * this method is used to verify login page is displayed or not
		  * @param driver
		  * @return
		  */
public String logintitleVerification(WebDriver driver)
{
	String actualtitle=driver.getTitle();
	return actualtitle;
}
}

