package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class ApprovedPage extends BaseClass {
	public ApprovedPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "d-none d-sm-inline text-light")
	WebElement Approved;
	
	@FindBy(className = "card-title text-primary")
	WebElement New_Page_Text;
	
	@FindBy(xpath = "//div[@class='col py-3 text-center']//li[1]//a[1]")
	WebElement Flex;
	
	@FindBy(xpath = "//label[normalize-space()='Click here to view the description:']")
	WebElement Flex_Text;
	
	@FindBy(xpath = "//button[@class='btn btn-primary mr-5'][normalize-space()='Edit']")
	WebElement Edit;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save;
	
	@FindBy(xpath = "//button[@class='btn btn-primary mt-3 mr-5']")
	WebElement Approved_Click;
	
	@FindBy(xpath = "//input[@id='input']")
	WebElement Message;
	
	
	public void Approve_Page_link() 
	{
		
		Approved_Click.click();
	}
	
	public String get_text()
	{
		String txt=New_Page_Text.getText();
		return txt;
	}
	
	public String flex_check()
	{
		Flex.click();
		String txt=Flex_Text.getText();
		return txt;
	}
	
	public void edit_curriculum()
	{
		Flex.click();
		Edit.click();
	}
	
	public void save_curriculum()
	{
		Edit.click();
		Save.click();
	}

}
