package com.crm.GenericLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class consists Of Generic Methods of WebDriver
 * @author Manjunath
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait Until element loads 
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait until element to be clickable
	 * @param driver
	 * @param element
	 */
	public void explicitWait(WebDriver driver , WebElement element)
	{
		WebDriverWait wb=new WebDriverWait(driver, 20);
		wb.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will select data from Drop down using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sc= new Select(element);
		sc.selectByIndex(index);
	}
	
	/**
	 * This method will select data from Drop down using text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sc= new Select(element);
		sc.selectByVisibleText(text);
	}
	
	/**
	 * This method will select data from Drop down using value
	 * @param value
	 * @param element
	 */
	public void select(String value,WebElement element)
	{
		Select sc= new Select(element);
		sc.selectByValue(value);
	}
	
	/**
	 * This method will wait until the element is Clickable
	 * @param element
	 * @throws Throwable
	 */
	public void waitForCompleteLoad(WebElement element) throws Throwable
	{
		while(true)
		{
			try
			{
				element.click();
				break;
			}
			catch (Exception e) {
				Thread.sleep(2000);
			}
		}
	}
	
	/**
	 * This method is used for mouseHover action
	 * @param driver
	 * @param target
	 */
	public void mouseHover(WebDriver driver , WebElement target)
	{
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	/**
	 * This method is used for DoubleClick on element
	 * @param driver
	 * @param target
	 */
	public void doubleClick(WebDriver driver , WebElement target)
	{
		Actions a = new Actions(driver);
		a.doubleClick(target).perform();
	}
	
	/**
	 * This method is used for Double click on WebPage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * This method is used for Drag And Drop
	 * @param driver
	 * @param from
	 * @param to
	 */
	public void dragAndDrop(WebDriver driver , WebElement from , WebElement to)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}
	
	/**
	 * This method is used for Right click on Element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method is used for Right click on WebPage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method is used to handle Keyboard function using action class
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method will switch the frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch the frame by name or ID
	 * @param driver 
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch the frame by Address
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * This method is used to press enter key
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable 
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method is used to Release enter key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable 
	{
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
		
	/**
	 * This method is used accept Alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used Cancel Alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to switch in between windows based on the Partial Window Title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver ,String partialWinTitle)
	{
		//Step 1: Capture all the windows Id's
		Set<String> win = driver.getWindowHandles();
		
		//Step 2: Iterate Thru the window
		Iterator<String> it = win.iterator();
		
		//Step 3: Check whether there is next window
		while(it.hasNext())
		{
			//Step 4: Capture current window id
			String winId = it.next();
			
			//Step 5: Switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//Step 6: Check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method is used to take Screen shot
	 * @param driver
	 * @param screenShotName
	 * @return 
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver , String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+screenShotName+".png");
		//File dst = new File("C:\\Users\\Manjunath\\Desktop\\Screeeeen\\vTiger.jpeg");
		//Files.copy(src, dst);
		FileUtils.copyFile(src, dst);
		//"C:\Users\Manjunath\Desktop\Screeeeen"
		return dst.getAbsolutePath();
	}
	
	
	/**
	 * This method is used scroll the window by 500 pixel in Y direction
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	
	/**
	 * This method is used scroll the window upto to particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")" , element);
	}
	
}
