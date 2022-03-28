package com.crm.vtiger.elementRespository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * ObjectRespository for lead information page
 * @author Jayapradha
 *
 */

public class LeadInformationPage {
	// Declaration of WebElents
	@FindBy(className="dvHeaderText")
	private WebElement headerText;

	//initialization of WebElements
	public LeadInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//creating getter methods
	public WebElement getHeaderText() {
		return headerText;
	}
	/**
	 * This method is used to return the header text
	 * @return
	 */
	
  public String headerText()
  { 
	  
	 return  headerText.getText();
  }
}
