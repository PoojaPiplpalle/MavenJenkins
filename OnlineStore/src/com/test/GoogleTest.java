package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
WebDriver driver;//initialize driver.

//Interview question:What is sequnce of execution?
//how will you perform sequencying ?
//ANs:By using priority keyword.


@BeforeClass
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com");
}

@Test(priority=8,groups="Title")
public void googleTitleTest() {
	String title=driver.getTitle();
	System.out.println(title);
	
}

@Test(priority=1,groups="Logo",enabled=true)
public void googleLogoTest() {
	boolean b=driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
	System.out.println(b); 
	
}
@Test(priority=3,groups="LinkTest")
public void mailLinkTest() {
	
	boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	System.out.println(b);
}

@Test(priority=4,groups="Test")
public void test1() {
	System.out.println("test1");
	
}
@Test(priority=5,groups="test")
public void test2() {
	System.out.println("test2");
	

}
@Test(priority=0,groups="test")
public void test3() {
	System.out.println("test3");
	

}
//Refresh the project and click on test-output and  index.html rytclick go to properties and copy paste the loc in chrome.u will see the result

@AfterClass
public void tearDown() {
	
	driver.close();
	
}

}
