package com.actitime.configuration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonSetup 
{
	public static WebDriver driver;
	public String url="https://demo.actitime.com/login.do";
	
	@BeforeClass
	@Parameters("browser")
	public void classsetup(String browser)
	{	
		if(browser.equalsIgnoreCase("firefox"))
		{
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();	
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
			
		}
		// launching the browser we are using this method
		//firefox driver
		WebDriverManager.firefoxdriver().setup();
		
		//chrome driver
		//WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();	
	}
	@BeforeMethod
	
	public void loginsetup() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		WebDriverUtils utils=new WebDriverUtils();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		String user=utils.getDataFromProperties("username");
		String pass=utils.getDataFromProperties("password");
		lp.loginOperation(user, pass);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	
	public void logout() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickOnLogout();
	}
	
	@AfterClass
	public void classteardown()
	{
		driver.close();
	}
}
