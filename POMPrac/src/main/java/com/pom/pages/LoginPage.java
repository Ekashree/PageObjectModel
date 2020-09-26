package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginBtn;
	
	@FindBy(name="email")
	WebElement emailtextbox;
	
	@FindBy(name="password")
	WebElement passtextbox;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement submitBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Free Customer Relationship')]")
	WebElement crmLogo;
	
	public String validateLoginPageTitle()
	{
		String logintitle = driver.getTitle(); 
		System.out.println(logintitle);
		return logintitle;
	}

	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
}
