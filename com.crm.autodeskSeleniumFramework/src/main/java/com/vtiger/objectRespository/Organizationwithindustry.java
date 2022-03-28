package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationwithindustry {
	@FindBy(xpath="//font[text()='Banking']")
	private WebElement Bankinginfo;
	
	public Organizationwithindustry(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBankinginfo() {
		return Bankinginfo;
	}
		
		public String industryInfo()
		{
			 return Bankinginfo.getText();
		}
	
	

}
