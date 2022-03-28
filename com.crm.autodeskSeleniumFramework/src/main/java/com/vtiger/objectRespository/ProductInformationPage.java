package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	@FindBy(xpath="lvtHeaderText")
	private WebElement headerText;
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		public String productInfo()
		{
			return headerText.getText();
		}
	}


