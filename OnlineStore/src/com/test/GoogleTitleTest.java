package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	 
	@Test(priority=1,groups="Title")
	public void googleTitleTest() {
		String title=driver.getTitle();
		System.out.println(title);
		//We need to validate if the title we are getting is true or not so we have Assert class
		//Assert.assertEquals(title, "Google","title is not matched");//if match is not found then only "title is not matched" will be executed.
	//assertEquals(actual, Expected)	
		
		
	
 }
	
	@Test(priority=2,groups="Title")
	public void googleLogoTest() {
		boolean b=driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
		//Assert.assertTrue(b);//if b is true then test case will be passed.
		//or we can write below one
		//Assert.assertEquals(b, true);
	}
	/*@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}*/

}
//How to execute all the testcases from all class then ryt click on  SRC->new-> go to other->file-Next-> write testNG.xml->finish-we are creating XML file
//TestCase will be pass only ig assertequals returns true.