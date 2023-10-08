package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class RequirementPage extends BaseClass{
	
	public RequirementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(className = "fs-6 font-weight-semi-bold d-sm-inline")
	WebElement Admin_Dashboard;
	
	@FindBy(id = "reqform")
	WebElement Requirements;
	
	@FindBy(className = "ng-pristine ng-valid ng-touched")
	WebElement Search;
	
	@FindBy(xpath = "//h6[contains(text(),'Create Form ')]")
	WebElement New_Requirment;
	
	@FindBy(className = "text-primary mt-1")
	WebElement Add_Req_Field;
	
	@FindBy(id = "requirementName")
	WebElement Name;
	
	@FindBy(css = "select#trainingArea")
	WebElement Training_Area;
	
	@FindBy(name = "institution")
	WebElement Corporate_Office;
	
	@FindBy(css = "select#category")
	WebElement Category_Req;
	
	@FindBy(css = "input#trainingHours")
	WebElement Training_Hours;
	
	@FindBy(xpath = "//input[@name=\\\"files\\\"]")
	WebElement Choose_File;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Btn_Submit;
	
	public void req_link() 
	{
		
		Requirements.click();
	}
	
	public String get_text()
	{
		String txt=Admin_Dashboard.getText();
		return txt;
	}
	
	public String button_check()
	{
		New_Requirment.click();
		String txt=Add_Req_Field.getText();
		return txt;
	}
	
	public void add_requirement_method() throws InterruptedException
	{
		New_Requirment.click();
		Name.sendKeys("ABC");
		Training_Area.sendKeys("ST");
		Corporate_Office.sendKeys("A");
		Category_Req.sendKeys("Corporate");
		Training_Hours.sendKeys("12");
		Choose_File.sendKeys("C:\\Internship");
		Thread.sleep(15000);
		Actions action=new Actions(driver);
		action.moveToElement(Btn_Submit).click().build().perform();
		Btn_Submit.click();
		
		
		
		
	}
	
	
	
	

}
