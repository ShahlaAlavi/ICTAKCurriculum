package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.AdminLoginPage;
import com.qa.pages.ApprovedPage;
import com.qa.utilities.ExcelUtility;

public class Approved_TC extends BaseClass {
	
	ApprovedPage approvedpage;
	AdminLoginPage adminloginpage;
	@BeforeMethod
	public void tearUp() throws IOException, InterruptedException
	{
		adminloginpage=new AdminLoginPage(driver);
		approvedpage= new ApprovedPage(driver);
		String User=ExcelUtility.getDataSheet0(0,0);
		String Pwd=ExcelUtility.getDataSheet0(0,1);
		System.out.println("UserName:"+User);
		System.out.println("PassWord:"+Pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adminloginpage.login_method_admin(User,Pwd);
		
	}
	
	@Test(priority=1)
	public void curriculum_link()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		approvedpage.Approve_Page_link();
		String txt=approvedpage.get_text();
		Assert.assertEquals(txt, "Approved List");
		System.out.println("Navigated to Approved Curriculum page");
	}
	
	@Test(priority=2)
	public void flex_link()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		approvedpage.Approve_Page_link();
		String txt=approvedpage.flex_check();
		Assert.assertEquals(txt, "Flex List");
		System.out.println("Navigated to Edit Curriculum page");
	}
	
	@Test(priority = 3)
	  public void edit_approved() throws InterruptedException
	  {
		Thread.sleep(2000);
		approvedpage.edit_curriculum();
		 
	  }
	
	@Test(priority = 4)
	  public void save_approved() throws InterruptedException
	  {
		Thread.sleep(2000);
		approvedpage.save_curriculum();
		 
	  }
	
	
	@AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
	
	

}
