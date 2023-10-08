package com.qa.testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.AdminLoginPage;
import com.qa.pages.RequirementPage;


public class Requirement_TC extends BaseClass{
	RequirementPage requirementpage;
	
	@BeforeMethod
	public void tearUp() throws InterruptedException
	{
		AdminLoginPage loginpage=new AdminLoginPage(driver);
		requirementpage=new RequirementPage(driver);
		loginpage.login_method_admin("admin@org.in", "admin123");
		
	}
	@Test(priority=1)
	public void req_link()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		requirementpage.req_link();
		String txt=requirementpage.get_text();
		Assert.assertEquals(txt, "Requirement List");
		System.out.println("Navigated to Requirement page");
	}
	@Test(priority=2)
	public void newreq_button_check()
	{
		requirementpage.req_link();
		String txt=requirementpage.button_check();
		Assert.assertEquals(txt, "Add Requirements");
	}
	@Test(priority=3)
	public void add_requirement() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		requirementpage.req_link();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		requirementpage.add_requirement_method();		
		
	}
	
	@AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
	

}
