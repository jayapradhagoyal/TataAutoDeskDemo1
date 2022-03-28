package com.vtiger.objectRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericutility.WebDriverUtility;

public class CreatingNewProductPage extends WebDriverUtility{
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//initilization of WebElement
	 public CreatingNewProductPage(WebDriver driver) {
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
	 public void createProduct(String productName,WebDriver driver)
	 {
		 productNameTextField.sendKeys(productName);
		 
		 saveButton.click();
		WebElement target = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		
		waitForElementVisibility(driver,target );
	 }
	 
	 
	

}
