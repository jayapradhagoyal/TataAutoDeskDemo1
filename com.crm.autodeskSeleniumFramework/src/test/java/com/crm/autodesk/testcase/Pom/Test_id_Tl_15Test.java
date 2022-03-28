package com.crm.autodesk.testcase.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.crm.vtiger.elementRespository.CreatingNewLead;
import com.crm.vtiger.elementRespository.HomePage;
import com.crm.vtiger.elementRespository.LeadInformationPage;
import com.crm.vtiger.elementRespository.LeadsPage;
import com.crm.vtiger.elementRespository.LoginPage;



/**
 * Test_id_Tl_15
 * 
 * @author Jayapradha
 * Test Type FT
 *
 */
public class Test_id_Tl_15Test{
	public static void main(String[] args) throws Throwable {
		
		// creating the objects for generic libraries
				
		FileUtility fil = new FileUtility();
		WebDriverUtility web = new WebDriverUtility();
		ExcelUtility ExcUtil = new ExcelUtility();
		JavaUtility JaUtil = new JavaUtility();
		// reading the common data from properties file
		String browser = fil.getPropertyKeyVAlue("browser");
		System.out.println(browser);
		String url = fil.getPropertyKeyVAlue("url");
		System.out.println(url);
		String username = fil.getPropertyKeyVAlue("username");
		System.out.println(username);
		String password = fil.getPropertyKeyVAlue("password");
		System.out.println(password);
		
        //launching the Browser
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		// creating object for loginpage
		LoginPage loginpage = new LoginPage(driver);
		
		// logging to the application
		loginpage.loginbutton(username, password);
		String actualTitle = loginpage.logintitleVerification(driver);

		// getting data from excel sheet
		String expectedTitle = ExcUtil.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		
		//login page verification
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("PASS");
		} else {
			System.out.println("Fail");
		}

		// creating object for homepage
		HomePage homepage = new HomePage(driver);
		
		//reading the data from excelsheet
		String expectedUrl = ExcUtil.getDataFromExcel("Sheet1", 1, 0);

		// verification for homepage
		String actualurl = homepage.urlVerification(driver);
		if (actualurl.contains(expectedUrl)) {
			System.out.println("PASS:");
		} else {
			System.out.println("Fail:");
		}

		// clicking on leads module
		homepage.clickOnLeadsModule();
		
		// object for leads page
		LeadsPage leadspage = new LeadsPage(driver);
		
		// click leads image icon
		leadspage.createLeadIcon();

		// leads page verification
		String ExpectedUrl = ExcUtil.getDataFromExcel("Sheet1", 1, 5);

		String actualUrl1 = leadspage.leadsTitleVerification(driver);

		System.out.println(actualUrl1);
		System.out.println(ExpectedUrl);
		if (actualUrl1.equals(ExpectedUrl)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		// creating object for new lead
		
		CreatingNewLead newLead = new CreatingNewLead(driver);
		String lastname = ExcUtil.getDataFromExcel("Sheet1", 4, 1);
		String companyName = ExcUtil.getDataFromExcel("Sheet1", 4, 2);
		String emplyees = ExcUtil.getDataFromExcel("Sheet1", 4, 3);
		String email = ExcUtil.getDataFromExcel("Sheet1", 7, 0);
		String secondaryemail = ExcUtil.getDataFromExcel("Sheet1", 7, 1);
		
		newLead.enteringEmail(lastname, companyName,email , secondaryemail);
		
		// creating an object for leadinformationpage 
		
		LeadInformationPage leadinfo = new LeadInformationPage(driver);
	
     String actualtext = leadinfo.headerText();
      System.out.println(actualtext);
      String expectedtext=ExcUtil.getDataFromExcel("Sheet1", 7, 2);
      System.out.println(expectedtext);
      
      //verification whether unique lead number is generated or not
      
      if(expectedtext!=null )
      {
    	  System.out.println("unique lead number is generated :PASS");
      }
      else
      {
    	  System.out.println("unique lead number is not  generated :FAIL");
      }
      
      //logging out of the application
      
      homepage.logOut(driver);
      driver.quit();
}

	}

