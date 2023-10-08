package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.AdminLoginPage;
import com.qa.utilities.ExcelUtility;

public class AdminLogin_TC extends BaseClass{
	AdminLoginPage adminlogin;
	
	@BeforeMethod
	public void tearUp()
	{
		adminlogin=new AdminLoginPage(driver);
	}
	
	@Test(priority=1)
	public void validLogin() throws IOException, InterruptedException
	{
		String User=ExcelUtility.getDataSheet0(0, 0);
		String Pwd=ExcelUtility.getDataSheet0(0, 1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminlogin.login_method_admin(User, Pwd);
		String txt=adminlogin.label_Text();
		Assert.assertEquals(txt,"Admin");
		System.out.println("Successfully logged in");		
	}
	
	@Test(priority=2)
	public void Blank_Username() throws IOException
	{
		String User=ExcelUtility.getDataSheet0(1, 0);
		String Pwd=ExcelUtility.getDataSheet0(1, 1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminlogin.login_failed(User, Pwd);
		String message=adminlogin.Email_Msg_validation();
		Assert.assertEquals(message,"Email is required");
		System.out.println(message);
		
	}
	
	@Test(priority=3)
	public void Blank_Password() throws IOException
	{
		String User=ExcelUtility.getDataSheet0(2,0);
		String Pwd=ExcelUtility.getDataSheet0(2,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminlogin.login_failed(User,Pwd);
		String message=adminlogin.Pwd_Msg_validation();
		Assert.assertEquals(message,"Password is required");
		System.out.println(message);
	}
	
	@Test(priority=4)
	public void Blank_fields() throws IOException 
	{
		String User=ExcelUtility.getDataSheet0(3,0);
		String Pwd=ExcelUtility.getDataSheet0(3,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminlogin.login_failed(User,Pwd);
		String message=adminlogin.Email_Msg_validation();
		Assert.assertEquals(message,"Email is required");
		System.out.println(message);
	}
	
	/*@Test(priority=5)
	public void Invalid_pwd() throws IOException 
	{
		String User=ExcelUtility.getDataSheet0(4,0);
		String Pwd=ExcelUtility.getDataSheet0(4,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminlogin.login_failed(User,Pwd);
		String message=adminlogin.wrong_pwd();
		Assert.assertEquals(message,"Invalid!");
		System.out.println(message);
	}*/
	
	@Test(priority=5)
	public void Invalid_user() throws IOException 
	{
		String User=ExcelUtility.getDataSheet0(5,0);
		String Pwd=ExcelUtility.getDataSheet0(5,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminlogin.login_failed(User,Pwd);
		String message=adminlogin.wrong_user();
		Assert.assertEquals(message,"SIGN IN");
		System.out.println("No Error message and Not logged in");
	}
	
	@AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
		
	
	
	

}
