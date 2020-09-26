package com.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	LoginPage loginPageobj;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPageobj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String loginPageTitle = loginPageobj.validateLoginPageTitle();
		//Assert.assertEquals(loginPageTitle, "Free CRM #1 cloud software for any business large or small");
		System.out.println(loginPageTitle);
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag =loginPageobj.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
