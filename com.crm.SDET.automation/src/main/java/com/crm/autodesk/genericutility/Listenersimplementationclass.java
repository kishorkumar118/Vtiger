package com.crm.autodesk.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenersimplementationclass implements ITestListener 
{

	public void onFinish(ITestContext context) 
	{
		System.out.println("execution finish");
	}

	public void onStart(ITestContext context) 
	{
		System.out.println("executed started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String methodname =result.getMethod().getMethodName();
		System.out.println(methodname+"-------> execution failed");
		System.out.println(result.getThrowable());
		WebDriverUtility wLib = new WebDriverUtility();
		try {
			String path = wLib.takeScreenshot(Baseclass.sdriver,methodname);
			
		} catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodname =result.getMethod().getMethodName();
		System.out.println(methodname+"-------> execution skipped");
	}

	public void onTestStart(ITestResult result) 
	{
		String methodname =result.getMethod().getMethodName();
		System.out.println(methodname+"-------> start");
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodname =result.getMethod().getMethodName();
		System.out.println(methodname+"-------> execution successfull");
		
	}

}
