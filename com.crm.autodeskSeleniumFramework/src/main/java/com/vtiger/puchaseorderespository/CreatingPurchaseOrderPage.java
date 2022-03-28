package com.vtiger.puchaseorderespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericutility.WebDriverUtility;

public class CreatingPurchaseOrderPage extends WebDriverUtility {
	@FindBy(name="subject")
	private WebElement subjectTextField;
	
	@FindBy(xpath="//td[text()='Vendor Name 			']/following-sibling::td/img")
	private WebElement selectVendorNameImg;
	
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveButton;
    
    @FindBy(xpath="//textarea[@name='bill_street']")
    private WebElement billingAdresstextfield;
    
    @FindBy(xpath="//input[@id='search_txt']")
    private WebElement searchTextBox;
    
    @FindBy(xpath="//input[@name='search']")
    private WebElement searchButton;
    
    @FindBy(xpath="//textarea[@name='ship_street']")
    private WebElement shippingAdresstextfield;
    
    @FindBy(xpath="//img[@title='Products']")
    private WebElement createProducticon;
    
    @FindBy(xpath="//input[@id='qty1']")
    private WebElement quantity;
    @FindBy(xpath="//input[@name='search_text']")
    
    private WebElement productsearchtextbox;
    
 @FindBy(xpath="//input[@name='search']")
    
    private WebElement productsearchButton;
    @FindBy(xpath="//input[@id='listPrice1']")
    private WebElement pricebook;
    
    @FindBy(xpath="//input[@id='search_txt']")
    private WebElement vendorSearch;
    @FindBy(xpath="//input[@type='button']")
    
    private WebElement vendorSearchButton;
    public WebElement getSearchTextBox() {
		return searchTextBox;
	}
    

	public WebElement getProductsearchtextbox() {
		return productsearchtextbox;
	}


	public WebElement getProductsearchButton() {
		return productsearchButton;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}

	
	public WebElement getVendorSearch() {
		return vendorSearch;
	}

	public WebElement getVendorSearchButton() {
		return vendorSearchButton;
	}

	public CreatingPurchaseOrderPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getSubjectTextField() {
		return subjectTextField;
	}

	public WebElement getSelectVendorNameImg() {
		return selectVendorNameImg;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getBillingAdresstextfield() {
		return billingAdresstextfield;
	}

	public WebElement getShippingAdresstextfield() {
		return shippingAdresstextfield;
	}

	public WebElement getCreateProducticon() {
		return createProducticon;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPricebook() {
		return pricebook;
	}
    
	public void purchaseOrder( String subjectName ,WebDriver driver,String vendorName) throws InterruptedException
	{
		subjectTextField.sendKeys(subjectName);
		
		selectVendorNameImg.click();
		
		switchToWindow( driver,"Vendors");
		
		vendorSearch.sendKeys(vendorName);
		vendorSearchButton.click();
		Thread.sleep(2000);
	
		 driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		 
		switchToWindow( driver,"PurchaseOrder");
		
		
		
		
	}
	
	public void billingAddress(String address)
	{
		billingAdresstextfield.sendKeys(address);
		
	}
    
	public void shippingAddress(String address)
	{
		shippingAdresstextfield.sendKeys(address);
		
	}
	 
	public void seletingProduct(WebDriver driver,String productName,String noquantity,String price) throws InterruptedException
	{
		createProducticon.click();
		
switchToWindow( driver,"Products");
		
productsearchtextbox.sendKeys(productName);
          productsearchButton.click();
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		 Thread.sleep(5000);
		switchToWindow( driver,"PurchaseOrder");
		quantity.sendKeys(noquantity);
		pricebook.sendKeys(price);
		saveButton.click();
		
	}
	public void clickOnSaveButton(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		saveButton.click();
		
		
		
	}
	
	

}
