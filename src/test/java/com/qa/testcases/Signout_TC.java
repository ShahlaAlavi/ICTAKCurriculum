package com.qa.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.AdminLoginPage;
import com.qa.pages.SignoutPage;
import com.qa.utilities.ExcelUtility;

public class Signout_TC extends BaseClass{
	SignoutPage signoutpage;
	@Test(priority=1)
	public void signout() throws IOException, InterruptedException
	{
		AdminLoginPage adminlogin=new AdminLoginPage(driver);
		String User=ExcelUtility.getDataSheet0(0, 0);
		String Pwd=ExcelUtility.getDataSheet0(0, 1);
		adminlogin.login_method_admin(User, Pwd);
	    signoutpage.clickSignout();
	    String text=signoutpage.verify_Signout();
	    Assert.assertEquals(text, "fingerprintLOGIN");
		System.out.println("Signout successfully!");	
	}
	
	@AfterMethod
	public void window_close()
	{
		driver.close();
	}
	
	

}
