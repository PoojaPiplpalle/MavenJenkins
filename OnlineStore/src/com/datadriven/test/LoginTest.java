package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil1;

public class LoginTest {
	WebDriver driver;//initialize driver.

	//Interview question:What is sequnce of execution?
	//how will you perfrom sequencying ?
	//ANs:By using priority keyword.


	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/ ");
		Thread.sleep(10000);
	}
	
	@DataProvider(name="getlog")
	public Object[][] getLoginData() {//This method will get the data from excel file
		Object[][] data=TestUtil1.getTestData("Sheet1");
		return data;
	}
	
	@Test(dataProvider="getlog")//we need to add dataprovider to tell test annonatation that we need to fetch data from ecel.
	public void LoginTest(String username,String password) throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
