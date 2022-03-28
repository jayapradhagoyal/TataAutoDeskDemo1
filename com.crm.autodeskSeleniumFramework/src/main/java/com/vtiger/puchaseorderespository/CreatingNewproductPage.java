package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewproductPage {
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//initilization of WebElement
	 public CreatingNewproductPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }

	
	 
	 



	//creating getter method
	 public WebElement getProductNameTextField() {
			return productNameTextField;
			
		}
	 
	 
	 public WebElement getSaveButton() {
		return saveButton;
	}



	//business logic
	 public void createProduct(String productName)
	 {
		 productNameTextField.sendKeys(productName);
		 saveButton.click();
	 }
	 
	 
	

}
