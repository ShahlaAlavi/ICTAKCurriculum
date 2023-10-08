package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class PendingPage extends BaseClass
{
	public PendingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@routerlink='/dashboard/pending']//span[@class='d-none d-sm-inline text-light']")
	WebElement Pending;
	
	@FindBy(className = "card-title text-primary")
	WebElement Pending_Approvel_Page;
	
	@FindBy(xpath = "//div[@class='col py-3 text-center']//li[1]//a[1]")
	WebElement Flex;
	
	@FindBy(xpath = "//label[normalize-space()='Click here to view the description:']")
	WebElement Flex_Text;
	
	@FindBy(xpath = "//button[@class='btn btn-primary mr-5'][normalize-space()='Edit']")
	WebElement Edit;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save;
	
	
	public void pending_link() 
	{
		
		Pending.click();
	}
	
	public String get_text()
	{
		String txt=Pending_Approvel_Page.getText();
		return txt;
	}
	
	public String flex_check()
	{
		Flex.click();
		String txt=Flex_Text.getText();
		return txt;
	}
	
	
	public void pending_edit()
	{
		Pending.click();
		Edit.click();
	}
	
	public void pending_save()
	{
		Pending.click();
		Save.click();
	}
	
	


}
