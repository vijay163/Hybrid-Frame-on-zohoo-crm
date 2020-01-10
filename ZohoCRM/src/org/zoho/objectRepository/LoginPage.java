package org.zoho.objectRepository;

import java.awt.Event;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zoho.generics.BaseClass;
import org.zoho.generics.FWutills;

public class LoginPage 
{
	@FindBy(xpath="//input[@id='userName']")
	private WebElement userTextBox;
	
	@FindBy(xpath="//input[@id='passWord']")
	private WebElement passTextBox;
	
	@FindBy(xpath="//td[text()='Remember Me']/../td[1]/input")
	private WebElement checkBox;
	
	@FindBy(xpath="//input[@title='Sign In']")
	private WebElement loginBtn;
	
	@FindBy(xpath="(//td[contains(.,'No such account configured for the user')])[5]")
	private WebElement errMsg;
	
	@FindBy(xpath="//a[text()='Blogs']")
	private WebElement blogsLink;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void setUserName(String user)
	{
		userTextBox.clear();
		userTextBox.sendKeys(user);
	}
	public void errMsgIs()
	{
		String textErr = errMsg.getText();
		System.out.println("The Error Message Is:"+textErr);
	}
	public void clickOnBlogsLink(WebDriver driver)
	{ 
		try
		{
	 Actions ac = new Actions(driver);
	 ac.click().click(blogsLink).perform();
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_T);
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
	}
	
	public void setPassword(String pass)
	{
		passTextBox.clear();
		passTextBox.sendKeys(pass);
	}
	public void clickOnCheckBox()
	{
		checkBox.click();
	}
	public void clickOnSignin()
	{
		loginBtn.click();
	}

}
