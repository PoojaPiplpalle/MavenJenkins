package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest {
   WebDriver driver;
	
   @Test(priority=1)
	@Parameters({"Browser"})
	public void LaunchURLTest(String Browser) {
		
		System.out.println("Running browser is :"+Browser);
		if(Browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		    driver=new ChromeDriver();
		}
		driver.get("https://www.freecrm.com/ ");
	}
   
   @Test(priority=2)
   @Parameters({"Email","Password"})
   public void loginTest(String Email,String Password) throws InterruptedException {
	   driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
	   driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(2000);
	   
   }
}
