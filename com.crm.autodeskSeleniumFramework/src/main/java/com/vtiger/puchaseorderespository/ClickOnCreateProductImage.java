package com.vtiger.puchaseorderespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnCreateProductImage {
	
	//Declaring webelement
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement productimage;
		
		// intilization of webelement
		 public ClickOnCreateProductImage(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
		 }
		 //creating getter methods

		public WebElement getProductimage() {
			return productimage;
		}
			//business logic
			public void clickonproductimageicon()
			{
				productimage.click();
			}
		

}
