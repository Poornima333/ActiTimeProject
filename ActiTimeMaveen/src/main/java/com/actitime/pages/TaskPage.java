package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage 
{
	@FindBy(xpath="//div[.='Add New]") private WebElement AddNewbtn;
	@FindBy(xpath="//div[.='+New Customer") private WebElement NewCustomer;
	@FindBy(xpath="//div[.='+New Project") private WebElement NewProject;
	@FindBy(xpath="//div[.='+New Task") private WebElement NewTask;
	@FindBy(xpath="//div[.='Import Tasks from CSV") private WebElement Importtasks;
	
	public TaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createCustomer()
	{
		AddNewbtn.click();
		NewCustomer.click();
	}
	public void createProject()
	{
		AddNewbtn.click();
		NewProject.click();
	}
	public void createTasks()
	{
		AddNewbtn.click();
		NewTask.click();
	}
	public void importTasks()
	{
		AddNewbtn.click();
		Importtasks.click();
	}
	
}
