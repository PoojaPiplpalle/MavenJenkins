package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
LoginPage loginpage;
HomePage homepage;
TestUtil testutil;
ContactPage contactpage;

	public HomePageTest() {
		super();
		
	}
	//TestCase should be seperated-Independent with each other
	//Before each testcase launch broswer and login.
	//@Test-Execute testcase.
	//After each test case close the browser.
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testutil=new TestUtil();
		//contactpage=new ContactPage();
		loginpage=new LoginPage();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(5000);
	
	
	}
	
	@Test(priority=1)
	public void verifyHomeTitleTest() throws InterruptedException {
		
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home page title is not matched");//this message will be priniting only if testcase got failed
	
	Thread.sleep(5000);
	}
	@Test(priority=2)
	public void verifyUserNameTest() throws InterruptedException {
		testutil.switchToFrame();
		
	boolean flag=	homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
		Thread.sleep(5000);
		//This is getting failed becoz there is frame in application.
		//so create a create common utility method in TestUtil.java class.
		//Then in HomePageTest Create TestUtil Class object to access method.
		
	}
	@Test(priority=3)
	public void verifyContactLinkTest() throws InterruptedException {
		testutil.switchToFrame();
		contactpage=homepage.clickOnContactsLink();
		Thread.sleep(5000);
	}
	
	/*@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}*/
}
