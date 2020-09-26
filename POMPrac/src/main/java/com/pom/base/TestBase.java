package com.pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.pom.util.TestUtil;

public class TestBase {
	
	public WebDriver driver;
	Properties prop;
	
	public TestBase()
	{
		try
		{
		prop = new Properties();
		FileInputStream ip  = new FileInputStream("E:\\Ekashree\\Git Workspace\\PageObjectModel\\"
				+ "PageObjectModel\\POMPrac\\src\\main\\java\\com\\pom\\config\\config.properties");
		prop.load(ip);
		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if (browserName.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Software\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.contentEquals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Software\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if (browserName.contentEquals("firefox"))
		{		
			System.setProperty("webdriver.gecko.driver", "E:\\Software\\IEDriverServer.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageload_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	
	}

}
