package com.crm.autodeskgenericutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 
 * @author Jayapradha
 *
 */
public class ListnerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---------->execution successfull");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---------->execution successfull");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---------->execution successfull");
		System.out.println(result.getThrowable());
		try {
			String path=new WebDriverUtility().takeScreenshot(BaseClass.sDriver, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---------->execution successfull");
		System.out.println(result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution finished");
		
		
	}

	
	

}
