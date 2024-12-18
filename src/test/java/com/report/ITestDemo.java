package com.report;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestDemo implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case: "+result.getName()+" has started.");
		ExtentReportUtils.createTest(result.getMethod().getMethodName());
	}

//	@Override
//	public void onTestSuccess(ITestResult result) {
//		System.out.println("Test Case: "+result.getName()+" has passed.");
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		System.out.println("Test Case: "+result.getName()+" has failed.");
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		System.out.println("Test Case: "+result.getName()+" has been skipped.");
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		System.out.println("Test "+context.getCurrentXmlTest().getName()+" is started");
//	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("All test cases are finished");
		ExtentReportUtils.flushReport();
	}
	
	

}
