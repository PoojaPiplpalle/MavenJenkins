package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	//create a constructor of LoginPageTest
	public LoginPageTest() {
		super();//it will call super class construtor i.e TestBase class becox first we need to initialise the properties which are present in config properties file.
		//then it will go to setup() method then it will call initialization() method so it will not throw null pointer exception becoz in inilization we have use prop.
	}
	@BeforeMethod
	public void Setup() {
		initialization();
		
		//create the object of LoginPage class
	 loginpage=new LoginPage(); 
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginpPageTitle();//Calling through object of login page becoz method is non static.
		Assert.assertEquals(title,"CRMPRO  - CRM software for customer relationship management, sales, and support." );
		
	}
	
	@Test(priority=2)
	public void crmLogoimageTest() {
		boolean flag=loginpage.validateCRMImage();
	Assert.assertTrue(flag);
		}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));//login method is returning HomePage Object so we can store in HomePage class ref(homepage);
	Thread.sleep(5000);
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
