package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentationClass implements ITestListener 
{

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		
	}

	public void onTestSuccess(ITestResult result) 
	{

		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-----> Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		
		//Configure screen shot name
		String screenShotName = MethodName+new JavaUtils().getSystemDateInFormat();
		String path=null;
		
		//Using screen shot method from webdriver utility
		try {
			path = new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenShotName);
			
//			EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//			File src = edriver.getScreenshotAs(OutputType.FILE);
//			String pa = System.getProperty("user.dir")+".\\Screenshot\\"+screenShotName+".png";
//			path = ".\\Screenshot\\"+screenShotName+".png";
//			File dst = new File(pa);
//			Files.copy(src, dst);
//			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, MethodName+"---> TestScript Failed");
		//It will capture exception and log in report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---> TestScript Skipped");
		
		//It will capture exception and log in report
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		//Execution will start
		/*Configure the path*/
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Report"+new JavaUtils().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 ExecutionReport");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Reports");
		
		report= new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "IamManju");
		
	}

	public void onFinish(ITestContext context) 
	{
		//Consolidate all the parameters and generate the report
		report.flush();
		
	}

}
