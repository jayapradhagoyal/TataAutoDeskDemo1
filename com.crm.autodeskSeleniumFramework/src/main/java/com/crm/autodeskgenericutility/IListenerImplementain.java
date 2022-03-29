package com.crm.autodeskgenericutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class IListenerImplementain implements ITestListener {
ExtentTest test;
ExtentReports extentReports;

	@Override
	public void onTestStart(ITestResult result) {
		
		//step3:create a test method during the test execution starts
		test=extentReports.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//step4:log the pass method 
		test.log(Status.PASS, result.getMethod().getMethodName());

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String path=null;
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		WebDriverUtility webUtil = new WebDriverUtility();
		
		try {
			path=webUtil.takeScreenshot(BaseClass.sDriver,result.getMethod().getMethodName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//step5:log the skipped method 
				test.log(Status.SKIP, result.getMethod().getMethodName());
			test.log(Status.SKIP,result.getThrowable() );
		
	}

	@Override
	public void onStart(ITestContext context) {
		//step1:Extent report cofiguration
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./extentReport"+new JavaUtility().getSystemDateAndTime());
		 sparkReporter.config().setReportName("regression execution  report");
		 sparkReporter.config().setDocumentTitle("com.cast.vtiger.Automationframework report");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 
		 //step2:attach the physical report and do the system configuration
		 
		 extentReports = new ExtentReports();
		 
		 extentReports.attachReporter(sparkReporter);
		 extentReports.setSystemInfo("OS", "Windows 10");
		 extentReports.setSystemInfo("environment", "Testing environment");
		 extentReports.setSystemInfo("reportername", "Jayapradhagoyal");
		 extentReports.setSystemInfo("Url", "https://localhost:8888");
		 
		 
		 
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	

}
