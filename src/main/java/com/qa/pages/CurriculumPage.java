package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class CurriculumPage extends BaseClass{
	public CurriculumPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@class='nav-link px-0 align-middle text-light']//span[@class='ms-1 d-none d-sm-inline']")
	WebElement All_Curriculum;
	
	@FindBy(className = "text-primary mt-5")
	WebElement Curriculum_text;
	
	@FindBy(xpath = "//a[normalize-space()='ID609/DSA - dini']")
	WebElement Curriculum_Flex;
	
	@FindBy(xpath = "//label[normalize-space()='Click here to view the description:']")
	WebElement Flex_Text;
	
	@FindBy(xpath = "//div[@class='col-md-12 col-lg-11 justify-content-center m-5']//div[1]//div[1]//button[1]")
	WebElement Delete_Button;
	
	@FindBy(id = "Requirement")
	WebElement Requirement;
	
	
	public void curriculum_link() 
	{
		
		All_Curriculum.click();
	}
	
	public String get_text()
	{
		String txt=Curriculum_text.getText();
		return txt;
	}
	
	public String flex_check()
	{
		Curriculum_Flex.click();
		String txt=Flex_Text.getText();
		return txt;
	}
	
	public void curriculum_delete()
	{
		All_Curriculum.click();
		Delete_Button.click();
	}
	
	
	

}
