package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	//Create Obj for all utilities
	public DataBaseUtility dbLib = new DataBaseUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtils jLib = new JavaUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups={"regression","smokeSuite"})
	public void launchTheDB()
	{
		//dbLib.connectToDataBase();
		Reporter.log("DataBase Connected",true);
	}
	
	//@Parameters("browser")
	@BeforeClass(groups={"regression","smokeSuite"})
	public void launchTheBrowser() throws Throwable
	{
		//Read Data from PropertyFile
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		sdriver=driver;
		wLib.maximizeWindow(driver);
		wLib.implicitWait(driver);
		driver.get(URL);
		Reporter.log("Browser Launch Sucessful",true);
	}
	
	@BeforeMethod(groups={"regression","smokeSuite"})
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		LoginPage lo = new LoginPage(driver);
		lo.loginToAppln(USERNAME, PASSWORD);
		Reporter.log("Login Sucessful");
	}
	
	@AfterMethod(groups={"regression","smokeSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutofApp(driver);
		Reporter.log("Logout Sucessful",true);
	}
	
	@AfterClass(groups={"regression","smokeSuite"})
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser Closed Sucessful",true);
	}
	
	@AfterSuite(groups={"regression","smokeSuite"})
	public void closeDB()
	{
		//dbLib.closeDataBase();
		Reporter.log("DB Close Sucessful",true);
	}
	
}
