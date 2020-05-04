package com.actitime.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.CreateCustomerPage;
import com.actitime.pages.HomePage;
import com.actitime.pages.TaskPage;

public class CreateCustomerTest extends CommonSetup
{	
	WebDriverUtils wt = new WebDriverUtils();
	@Test
	public void createNewCustomer() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException
	{	
		String custname=wt.readtestdata("./src/test/resources/Testcasedata/Customerdata.xlsx","Sheet1", 1, 0);
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.clickOnTasks();
		TaskPage tp=new TaskPage(driver);
		Thread.sleep(3000);
		tp.createCustomer();
		CreateCustomerPage cp=new CreateCustomerPage();
		Thread.sleep(3000);
		cp.createNewCustomer(custname);
		Thread.sleep(3000);
	}
	

	@Test
	public void createCustomerWithNameAndDescription() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException
	{
		String custname=wt.readtestdata("./src/test/resources/Testcasedata/Customerdata.xlsx", "Sheet1", 2, 0);
		String desc=wt.readtestdata("./src/test/resources/Testcasedata/Customerdata.xlsx", "Sheet1", 2, 1);
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.clickOnTasks();
		TaskPage tp=new TaskPage(driver);
		Thread.sleep(3000);
		tp.createCustomer();
		CreateCustomerPage cp=new CreateCustomerPage();
		Thread.sleep(3000);
		cp.createNewCustomer(custname, desc);
		Thread.sleep(3000);
			
	}
	
	
}
