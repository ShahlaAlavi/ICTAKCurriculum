package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class SignoutPage extends BaseClass {
	public SignoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "d-none d-sm-inline mx-1")
	WebElement SignOut;
	
	@FindBy(xpath = "//h2[@class='text-primary text-center']")
	WebElement Login_text;
	
	public void clickSignout()
	{
		SignOut.click();
	}
	
	public String verify_Signout()
	{
		String text=Login_text.getText();
		return text;
	}
	
	

}
