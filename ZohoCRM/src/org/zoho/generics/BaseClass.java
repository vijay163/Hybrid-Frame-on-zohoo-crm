package org.zoho.generics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

abstract public class BaseClass implements IAutoConstants
{
	static 
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
		System.setProperty(IE_KEY,IE_VALUE);
	
	}
	public WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void openApp(String browser)
	{
	
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
		
		
	}
	@BeforeMethod
	public void openApp()
	{
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(PTO,TimeUnit.SECONDS);
		driver.get(URL);
	}
	@AfterMethod
	public void closeApp(ITestResult res)
	{
		int passCount=0;
		int failCount=0;
		String name = res.getName();
		int status = res.getStatus();
		if(status==1)
		{
			passCount++;
			System.out.println("Pass count is===="+passCount);
		}
		else
		{
			failCount++;
			String path = PHOTO_PATH+name+".png";
			FWutills.takesSrceenShot(driver, path);
			
		}
		driver.close();
	}

}
