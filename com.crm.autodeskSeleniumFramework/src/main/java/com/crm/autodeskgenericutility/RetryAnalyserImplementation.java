package com.crm.autodeskgenericutility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class is used to provide implementation for IRetryAnalyzer
 * @author jayapradha.D
 *
 */

public class RetryAnalyserImplementation  implements IRetryAnalyzer{
	 int count=0;
     int retrycount=5;
	public boolean retry(ITestResult result) {
	      
	       if(count<retrycount)
	       {
	    	   count++;
	    	   return true;
	       }
		return false;
	}
	

}
