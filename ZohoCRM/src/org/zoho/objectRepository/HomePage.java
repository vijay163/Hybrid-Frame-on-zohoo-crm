package org.zoho.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage
{
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeTab;
	
	@FindBy(xpath="//a[text()='Reports']")
	private WebElement reportsTab;
	
	@FindBy(xpath="//a[text()='New Task']")
	private WebElement newTask;
	
	@FindBy(xpath="//a[text()='New Lead']")
	private WebElement newLeadTab;
	
	@FindBy(xpath="//td[text()='* Subject:']/../td[2]/input")
	private WebElement SubjectTextBox;
	
	@FindBy(xpath="//td[text()='Description: ']/../td[2]/textarea")
	private WebElement discpTextBox;
	
	@FindBy(xpath="//td[text()='Due Date: ']/../td[2]/input")
	private WebElement dateTextBox;

	@FindBy(xpath="//select[@id='leContModSel']")
	private WebElement empTextbox;
	
	@FindBy(xpath="//select[@name='property(priority)']")
	private WebElement priorityTextBox;
	
	@FindBy(xpath="//input[@name='savenewtask']")
	private WebElement saveTaskAct;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clickOnNewTsak()
	{
		newTask.click();
	}
	public void enterSubjectOfPro(String sub)
	{
		SubjectTextBox.sendKeys(sub);
	}
	public void clickOnHome()
	{
		homeTab.click();
	}
	public void enterDesOfPro(String des)
	{
		discpTextBox.sendKeys(des);
	}
	public void selectDate(String date)
	{
		dateTextBox.sendKeys(date);
	}
	public void selectEmp(String emp)
	{
		Select s = new Select(empTextbox);
		s.selectByVisibleText(emp);
	}
	public void selectPriority(String pri)
	{
		Select s = new Select(priorityTextBox);
		s.selectByVisibleText(pri);
	}
	public void clickOnSaveTask()
	{
		saveTaskAct.click();
	}
	public void clickOnNewLeadTab()
	{
		newLeadTab.click();
	}
}
