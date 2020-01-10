package org.zoho.generics;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FWutills 
{
	public static String read_XL_Data(String path,String sheetName,int row,int cell)
	{  
		String data="";
		try
		{
		 Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		data=wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
	
		}
		catch (Exception e)
		{
		  e.printStackTrace();
		}
		return data;
		
	}
	public static int read_XL_DataRowCount(String path,String sheet)
	{
		int rc=0;
		try
		{
	Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	rc=wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		return rc;
	}
	public static void write_XL_Darta(String path,String sheet,int row,int cell,String value)
	{
		
		try
		{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
		wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
		wb.write(new FileOutputStream(path));
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		
	}
	public static void takesSrceenShot(WebDriver driver,String path)
	{
		try
		{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);
		}
		catch (Exception e) 
		{
	       e.printStackTrace();
		}
	}
	public static void verifieTitle(WebDriver driver,String expTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(expTitle));
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		System.out.println("the Title of The page is Displayed====>"+expTitle);
	}
	public static Actions actions(WebDriver driver)
	{
		return new Actions(driver);
	}
	public static Robot robot()
	{
		Robot rc=null;
		try
	   {
		return new Robot();
	   }
		catch (Exception e)
		{
		e.printStackTrace();	
		}
		return rc;
	}
	public static Select select(WebElement element)
	{
		return new Select(element);
	}
}
