package com.vtiger.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContractPage {
	//Declaring webelement
   @FindBy(xpath="//img[@title='Create Contact...']")
   private WebElement createcontracticon;
   
   //Initialization of WebElement
   
 public  CreateContractPage(WebDriver driver)
   {
	  PageFactory.initElements(driver,this); 
   }

 //create getter methods
public WebElement getCreatecontracticon() {
	return createcontracticon;
}
   
public void createcontract()
{
	 createcontracticon.click();
}
 
 
 
}
