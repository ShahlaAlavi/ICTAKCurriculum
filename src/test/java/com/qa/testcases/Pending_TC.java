package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.AdminLoginPage;
import com.qa.pages.PendingPage;
import com.qa.utilities.ExcelUtility;

public class Pending_TC extends BaseClass{
	PendingPage pendingpage;
	AdminLoginPage adminloginpage;
	@BeforeMethod
	public void tearUp() throws IOException, InterruptedException
	{
		adminloginpage=new AdminLoginPage(driver);
		pendingpage= new PendingPage(driver);
		String User=ExcelUtility.getDataSheet0(0,0);
		String Pwd=ExcelUtility.getDataSheet0(0,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminloginpage.login_method_admin(User,Pwd);
		
	}
	
	@Test(priority=1)
	public void pending_link()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pendingpage.pending_link();
		String txt=pendingpage.get_text();
		Assert.assertEquals(txt, "Pending List");
		System.out.println("Navigated to Pending Curriculum page");
	}
	
	@Test(priority=2)
	public void flex_link()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pendingpage.pending_link();
		String txt=pendingpage.flex_check();
		Assert.assertEquals(txt, "Flex List");
		System.out.println("Navigated to Edit Curriculum page");
	}
	
	@Test(priority = 3)
	  public void edit_pending() throws InterruptedException
	  {
		Thread.sleep(2000);
		pendingpage.pending_edit();
		 
	  }
	
	@Test(priority = 4)
	  public void save_pending() throws InterruptedException
	  {
		Thread.sleep(2000);
		pendingpage.pending_save();
		 
	  }
	
	@AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
	
	
	
	
	

}
