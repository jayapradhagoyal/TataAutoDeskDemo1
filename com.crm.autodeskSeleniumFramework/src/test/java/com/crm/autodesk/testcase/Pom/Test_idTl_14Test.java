package com.crm.autodesk.testcase.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.autodeskgenericutility.ExcelUtility;
import com.crm.autodeskgenericutility.FileUtility;
import com.crm.autodeskgenericutility.JavaUtility;
import com.crm.autodeskgenericutility.WebDriverUtility;
import com.crm.vtiger.elementRespository.CreatingNewLead;
import com.crm.vtiger.elementRespository.HomePage;
import com.crm.vtiger.elementRespository.LeadsPage;
import com.crm.vtiger.elementRespository.LoginPage;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

/**
 * Test_idTl_14
 * @author jayapradha
 * Test Type FT
 *
 */

public class Test_idTl_14Test {
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

		// entering data into mandatory fields of leads page
		newLead.getData(lastname, companyName, emplyees, driver);
		
		// verification for leads page
           String alertText=newLead.alert(driver);
            System.out.println(alertText);
          String expectedText=ExcUtil.getDataFromExcel("Sheet1", 4, 0);
            System.out.println(expectedText);
         if(alertText.contains(expectedText))
        {
	         System.out.println("New Lead should not be created :"+alertText+"PASS");
         }
          else
            {
	         System.out.println("New Lead should  be created :"+alertText+"FAIL");
	
              }
   
            //closing the alert
             newLead.closeAlert(driver);
		
		 //logging out of the applications
		homepage.logOut(driver); driver.quit();
		
	}

}
