package com.crm.autodesk.genericutility;

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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


	/**
	 * it's contains Webdriver resuable specific actions
	 * @author Kishorkumar
	 *
	 */
public class WebDriverUtility
	{
		/**
		 * used to maximize the window
		 * @param driver
		 */
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		/**
		 * wait for page to load before identifying any synchronized element in DOM [HTML-Document]
		 * @param driver
	     * 
		 */
	public void waitforPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * wait for page to load before identifying any asychronized[java scripts actions] element in DOM [HTML-Docuent
	 * @param driver
	 */
	public void waitforPageToLoadforJSelement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		
	}

	/**
	 * used to wait for element to be clickable in GUI , & 
	 check for specific element for every 500 mill seconds
	 * @param driver
	 * @param element
	 */
	public void waitforElementtobeclickable(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to wait for element to be clickable in GUI , 
	 & check for specific element for every 500 milli seconds
	 * @param driver
	 * @param pollingtime
	 * @param element
	 * @throws Throwable
	 */
	public void waitforElementtoCustomizeTimeout(WebDriver driver,int pollingtime, WebElement element) throws Throwable
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingtime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowtitle
	 */

	public void switchToWindow(WebDriver driver, String partialWindowtitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String window = it.next();
			driver.switchTo().window(window);
			String currentWindowtitle = driver.getTitle();
			if(currentWindowtitle.contains(partialWindowtitle))
			{
				break;
			}
		}
		}

	/**
	 * used to switch alertwindow and click ok button
	 * @param
	 */
	public void switchToAlertWindowandAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 *used to switch alertwindow and click cancel button
	 *@param
	 */
	public void switchToAlertWindowandCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to switch framewindow based on index
	 * @param driver
	 * @param index
	 */
	public void switchtoFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
		
	}

	/**
	 * used to switch framewindow based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchtoFrame(WebDriver driver, String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index )
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to select the value from dropdown based on value available in GUI
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place  mouse cursor on specific element
	 * @param driver
	 * @param element
	 * @param  
	 */
	public void mouseoveronElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * 
	 * @param element
	 * @param driver
	 */
	public void rightclickonElement(WebElement element, WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * used to execute the asychronous piece of javascript on the current window or frame
	 * @param driver
	 * @param java
	 */
	public void executejavaScript(WebDriver driver, String javaScript)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript,null);
	}

	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitandClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
		try
		{
			element.click();
			break;
		}
		catch(Throwable e)
		{
			Thread.sleep(1000);
			count++;
		}
	}
	}

	/**
	 * 
	 * @param driver
	 * @param screenshotname
	 * @throws Throwable 
	 */
	public String takeScreenshot(WebDriver driver, String screenshotname) throws Throwable
	{
		JavaUtility Jlib = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String timestamp = Jlib.getSystemDateandTime().replace(":","-");
		File destination  = new File ("./SCREENSHOT/"+timestamp+screenshotname+".PNG");
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();
	}

	/**
	 * use enter keys which applicable in the browser
	 * @param driver
	 */
	public void passEnterkey(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	}

	
		
	

	
		
	

