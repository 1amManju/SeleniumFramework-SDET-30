package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerImplimentationClass implements ITestListener 
{

	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---> Execution Started");
		
	}

	public void onTestSuccess(ITestResult result) 
	{

		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---> TestScript excetion Sucessful");
	}

	public void onTestFailure(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---> TestScript Failed");
		
		//Configure screen shot name
		String screenShotName = MethodName+new JavaUtils().getSystemDateInFormat();
		System.out.println(screenShotName);
		
		//Using screen shot method from webdriver utility
		try {
			new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenShotName);
			
//			EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//			File src = edriver.getScreenshotAs(OutputType.FILE);
//			String pa = System.getProperty("user.dir")+".\\Screenshot\\"+screenShotName+".png";
//			File dst = new File(pa);
//			Files.copy(src, dst);
//			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---> TestScript Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context) 
	{
		
	}

}
