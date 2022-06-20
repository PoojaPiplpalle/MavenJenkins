package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasic {
	
	//Giving output like ths:
	
	/*Setup system property for chrome
  launch Chrome broswer
  login to App
  Enter URL 
  Google Title Test
  Logout from App
  close Browser
  deleteallcookies
  PASSED: googleTitleTest


*/
	//PreConditions annotation---Starting with @Before
	@BeforeSuite //Executed first.
	public void setUp() {
		
		 System.out.println("BeforeSuite----Setup system property for chrome");
		
	}
	@BeforeTest  //2nd Executed.
	public void launchBrowser()  {
		
		 System.out.println("BeforeTest-----launch Chrome broswer");
	}
	
	 
	
 @BeforeClass//3rd
	public void login() {
	 System.out.println("BeforeClass----login to App");
	 
	 }
 /*sequence of execution if multiple test case
  * 1.@BeforeMethod
  * 2.@Test-1
  * 3.AfterMethod
  * 4.@BeforeMethod
  * 5.@Test-2
  * 6..AfterMethod
 
 */
	@BeforeMethod//4rth 
	public void enterURL() {
		 System.out.println("BeforeMethod----Enter URL");
		
		
	}
	
	//Testcases ---starting with annotation @Test
@Test//5th 
public void googleTitleTest() {
	System.out.println("Test----Google Title Test");
	
	}


@Test 
public void searchTest() {
	
	System.out.println("Test ----Search Test");
	
}
//Post Conditions ----starting with annotation @After
@AfterMethod//6th 
public void logOut() {
	System.out.println("AfterMethod-----Logout from App");
}

@AfterClass//7th 

public void closeBrowser() {
	
	System.out.println("AfterClass---close Browser");
}

@AfterTest//8th
public void deleteAllCookies() {
	System.out.println("AfterTest-----deleteallcookies");
	
	
}



@AfterSuite//9th 
public void generateTestReport() {
	System.out.println("AfterSuite---generateTestReport");
	
}
}
