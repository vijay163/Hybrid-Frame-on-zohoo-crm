package org.zoho.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewLeadPage 
{
	@FindBy(xpath="//select[@name='property(saltName)']")
	private WebElement nameTitleTextB;
	
	@FindBy(xpath="//input[@name='property(First Name)']")
	private WebElement fNameTextB;
	
	@FindBy(xpath="//input[@name='property(Company)']")
	private WebElement companyTextB;
	
	@FindBy(xpath="//input[@name='property(Last Name)']")
	private WebElement lNameTextB;
	
	@FindBy(xpath="//input[@name='property(Designation)']")
	private WebElement desigTextB;
	
	@FindBy(xpath="//select[@name='property(Lead Source)']")
	private WebElement leadSourceTextB;
	
	@FindBy(xpath="//select[@name='property(Industry)']")
	private WebElement IndustryTextB;
	
	@FindBy(xpath="//input[@name='property(Annual Revenue)']")
	private WebElement annualReveTextB;
	
	@FindBy(xpath="//input[@value='Save & New']")
	private WebElement saveLeadButton;
	public NewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void selectLeadNameTitle(String title)
	{
		Select s = new Select(nameTitleTextB);
		s.selectByVisibleText(title);
	}
	public void enterFirstName(String fname)
	{
		fNameTextB.sendKeys(fname);
	}
	public void enterLastName(String ln)
	{
		lNameTextB.sendKeys(ln);
	}
	public void enterCompanyN(String cn)
	{
		companyTextB.sendKeys(cn);
	}
	public void enterDesText(String des)
	{
		desigTextB.sendKeys(des);
	}
	public void selectLeadSource(String lead)
	{
             Select s = new Select(leadSourceTextB);
             s.selectByVisibleText(lead);
	}
	public void selectIndustry(String in)
	{
		Select s = new Select(IndustryTextB);
		s.selectByVisibleText(in);
	}
	public void clickOnSave()
	{
		saveLeadButton.click();
	}
	

}
