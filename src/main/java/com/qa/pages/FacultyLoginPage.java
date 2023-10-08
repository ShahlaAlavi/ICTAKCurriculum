package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class FacultyLoginPage extends BaseClass {
	public FacultyLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className =  "nav-item nav-link btn btn-primary px-4 d-inline text-light p-1 m-1")
	WebElement Login;
	
	@FindBy(name="email")
	WebElement UserName;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(className = "ng-pristine ng-invalid ng-touched")
	WebElement Submit;
	
	@FindBy(className = "fs-6 font-weight-semi-bold d-sm-inline")
	WebElement new_page;
	
	@FindBy(xpath = "//small[@class=\"text-danger\"]")
	WebElement email_msg;
	
	@FindBy(xpath = "//label[@for='exampleInputEmail1']")
	WebDriver label_text_Email;
	
	@FindBy(xpath = "//label[@for='exampleInputPassword1']")
	WebElement label_text_Pwd;
	
	public void login_method_faculty(String user,String pwd) throws InterruptedException
	{
		this.Login.click();
		Thread.sleep(2000);
		UserName.sendKeys(user);
		Password.sendKeys(pwd);
		Submit.click();
	}
	
	public void login_failed(String user,String pwd)
	{
		Login.click();
		UserName.sendKeys(user);
		Password.sendKeys(pwd);
		Submit.click();
	}
	
	public String label_Text()
	{
		String txt=new_page.getText();
		return txt;
	}
	
	public String Email_Msg_validation()
	{
		String msg=email_msg.getText();
		return msg;
	}
	
	public String Pwd_Msg_validation()
	{
		String msg1=label_text_Pwd.getText();
		//System.out.println(msg1);
		return msg1;
	}
	
	public String wrong_user()
	{
		String msg3=Submit.getText();
		System.out.println(msg3);
		return msg3;
	}
	
	
	
	

}
