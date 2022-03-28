package com.crm.vtiger.elementRespository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodeskgenericutility.WebDriverUtility;
/**
 * ObjectRespository for creating new leads page
 * @author Jayapradha
 *
 */

public class CreatingNewLead extends WebDriverUtility{
	//Declaring webelement
	@FindBy(name="lastname")
	private WebElement lastnameTextField;
	
	@FindBy(name="company")
	private WebElement companyNameTextField;
	
	@FindBy(id="noofemployees")
	private WebElement noOfEmployeesTextField;  
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement   saveButton;
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="secondaryemail")
	private WebElement secondaryemail;
	
	
	
	//intilization of WebElements
	
  public CreatingNewLead(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  // creating getter methods
	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}
	

	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getSecondaryemail() {
		return secondaryemail;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getNoOfEmployeesTextField() {
		return noOfEmployeesTextField;
	}
	/**this method is used to enter the mandatory data into leads page
	 * 
	 * @param lastname
	 * @param companyName
	 * @param employees
	 * @param driver
	 */
  public void getData(String lastname,String companyName,String employees,WebDriver driver)
  {
	  lastnameTextField.sendKeys(lastname);
	  companyNameTextField.sendKeys(companyName);
	  
	  noOfEmployeesTextField.sendKeys(employees);
	  
	  saveButton.click();
	  
  }
	  /**
	   * this method is used to get text from alert pop up
	   * @param driver
	   * @return
	   */
  public String alert(WebDriver driver)
  {
	 waitUntilAlertPopup(driver);
		return driver.switchTo().alert().getText();
		
	  
  }
  
  /**
   * this method is used to handle  alert pop up
   * @param driver
   */
  public void closeAlert(WebDriver driver)
	  
  {
	  driver.switchTo().alert().accept();
  }
	  
/**
 * This method is used to creating new lead page
 * @param lastname
 * @param companyName
 * @param firstemailId
 * @param secondaryemailId
 */
	  
  
	
	public void enteringEmail(String lastname,String companyName,String firstemailId,String secondaryemailId)
	{
		 lastnameTextField.sendKeys(lastname);
		  companyNameTextField.sendKeys(companyName);
		email.sendKeys(firstemailId);
		secondaryemail.sendKeys(secondaryemailId);
		 saveButton.click();
		
		
	}

	

}
