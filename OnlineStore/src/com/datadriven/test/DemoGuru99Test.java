package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoGuru99Test {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.demo.guru99.com/v4/");
	
	}
	
	
		@Test
		public void LoginSuccessfull() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr262491");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("zytubEp");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
	}
		
		
		@AfterMethod
		public void tearDown() {
			
			driver.quit();
			
		}
}
