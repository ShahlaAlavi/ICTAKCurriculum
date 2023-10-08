package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.FacultyLoginPage;
import com.qa.utilities.ExcelUtility;

public class Faculty_TC extends BaseClass {
	FacultyLoginPage facultyloginpage;
	
	@BeforeMethod
	public void tearUp()
	{
		facultyloginpage=new FacultyLoginPage(driver);
	}
	
	@Test(priority=1)
	public void validLogin() throws IOException, InterruptedException
	{
		String User=ExcelUtility.getDataSheet1(0, 0);
		String Pwd=ExcelUtility.getDataSheet1(0, 1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		facultyloginpage.login_method_faculty(User, Pwd);
		String txt=facultyloginpage.label_Text();
		Assert.assertEquals(txt,"Admin");
		System.out.println("Successfully logged in");		
	}
	
	@Test(priority=2)
	public void Blank_Username() throws IOException
	{
		String User=ExcelUtility.getDataSheet1(1, 0);
		String Pwd=ExcelUtility.getDataSheet1(1, 1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		facultyloginpage.login_failed(User, Pwd);
		String message=facultyloginpage.Email_Msg_validation();
		Assert.assertEquals(message,"Email is required");
		System.out.println(message);		
	}
	
	@Test(priority=3)
	public void Blank_Password() throws IOException
	{
		String User=ExcelUtility.getDataSheet1(2,0);
		String Pwd=ExcelUtility.getDataSheet1(2,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		facultyloginpage.login_failed(User,Pwd);
		String message=facultyloginpage.Pwd_Msg_validation();
		Assert.assertEquals(message,"Password is required");
		System.out.println(message);
	}
	
	@Test(priority=4)
	public void Blank_fields() throws IOException 
	{
		String User=ExcelUtility.getDataSheet1(3,0);
		String Pwd=ExcelUtility.getDataSheet1(3,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		facultyloginpage.login_failed(User,Pwd);
		String message=facultyloginpage.Email_Msg_validation();
		Assert.assertEquals(message,"Email is required");
		System.out.println(message);
	}
	
	@Test(priority=5)
	public void Invalid_user() throws IOException 
	{
		String User=ExcelUtility.getDataSheet1(5,0);
		String Pwd=ExcelUtility.getDataSheet1(5,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		facultyloginpage.login_failed(User,Pwd);
		String message=facultyloginpage.wrong_user();
		Assert.assertEquals(message,"SIGN IN");
		System.out.println("No Error message and Not logged in");
	}
	
	@AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
		

}
