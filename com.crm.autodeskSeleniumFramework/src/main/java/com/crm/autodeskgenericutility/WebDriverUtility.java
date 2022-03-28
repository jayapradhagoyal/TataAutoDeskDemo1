package com.crm.autodeskgenericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * 
 * This class contains webdriver specific generic methods
 * @author jayapradha
 */

public class WebDriverUtility{
	/**
	 * 
	 * this method will wait 20s for page to load
	 * @param driver
	 */

	public void waitPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * this method wait for the element to be visible
	 * @param driver
	 * @param ele
	 */



	public void waitForElementVisibility(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	
	public void waitUntilAlertPopup(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());

	}
	public void waitAndClick(WebElement ele) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			try
			{
				ele.click();
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
	 * this methods enables user to handle dropdown
	 * @param ele
	 * @param option
	 */

	public void select(WebElement ele,String option)
	{
		Select select =new Select(ele);
		select.selectByVisibleText(option);
	}
	/**
	 * this methods enables user to handle dropdown by index
	 * @param ele
	 * @param option
	 */
	public void select(WebElement ele,int index)
	{
		Select select =new Select(ele);
		select.selectByIndex(index);
	}
	/**
	 * this method will perform mouse over action
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver,WebElement ele)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).perform();
	}
	/**
	 * this method helps to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator <String>it=window.iterator();
		while(it.hasNext())

		{
			String winid=it.next();
			String title=driver.switchTo().window(winid).getTitle();

			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}

		/**
		 * This method is used to take screen shot
		 * @param driver
		 * @param screenshotName
		 * @throws IOException
		 */
		
		public String takeScreenshot(WebDriver driver,String screenshotName) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String timeStamp=LocalDateTime.now().toString().replace(":", "-");
			File dest=new File("./errorshot/"+screenshotName+timeStamp+".PNG");
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();
		}
	
}

