package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.TestUtil1;

public class ContactPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	String SheetName="contact";
	
	public ContactPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testutil=new TestUtil();
		contactpage=new ContactPage();
		loginpage=new LoginPage();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(5000);
	testutil.switchToFrame();
	contactpage=homepage.clickOnContactsLink();
	Thread.sleep(6000);

	
	
	}
	
	@Test(priority=4)
	public void VerifyContactsPageLabel() throws InterruptedException {
		
		boolean flag=contactpage.verifyContactLabel();
		Assert.assertTrue(flag,"Contact lable is missing on page");
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	
	public void selectSingleContactTest() throws InterruptedException {
		
		contactpage.selectContactsByName("Krishna piple");
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void selectMultipleContactTest() throws InterruptedException {
	
	contactpage.selectContactsByName("Krishna piple");
	contactpage.selectContactsByName("Poja pipl");
	Thread.sleep(5000);
	}
	
	@DataProvider
public Object[][] getCRMTestData() {
		
		Object obj[][]=TestUtil1.getTestData(SheetName);
		return obj;
		
	}
	@Test(priority=1,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company) throws InterruptedException {
		
		homepage.clickOnNewContactLink();
		//contactpage.createNewContact("Mr.", "Priya", "surya", "Capgemenin");
		contactpage.createNewContact(title, firstname, lastname, company);
		Thread.sleep(5000);
		
		//Instead of passing hardcoded value u can create excel sheet.and paste in com.crm.qa.testdata package
	//so create dataprovider method in ContactPageTest class and create testdata method in TestUtil .java class
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}

//To run Each Testclass at one time create runner class.
//Ryt click on project ->-New->create on source folder-src/main/resources
//Inside folder->create xml file->ryt click ->other->-File->testng.xml