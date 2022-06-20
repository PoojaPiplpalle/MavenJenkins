package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterTest {
	WebDriver driver;
	//Parameterization in Selenium is a process to parameterize the test scripts in order to pass multiple data to the application at runtime. It is a strategy of execution which automatically runs test cases multiple times using different values. The concept achieved by parameterizing the test scripts is called Data Driven Testing.
	//There are two ways by which we can achieve parameterization in TestNG.
/*
With the help of Parameters annotation and TestNG XML file.
TestNG: Parameterization using XML & DataProvider in Selenium

=======
With the help of Parameters annotation and TestNG XML file.
TestNG: Parameterization using XML & DataProvider in Selenium

With the help of DataProvider annotation.
TestNG: Parameterization using XML & DataProvider in Selenium


=============
With the help of DataProvider annotation.
TestNG: Parameterization using XML & DataProvider in Selenium

With the help of DataProvider annotation.
//Parameters Annotation in TestNG is a method used to pass values to the test methods as arguments using .xml file. Users may be required to pass the values to the test methods during run time. The @Parameters annotation method can be used in any method having @Test, @Before, @After or @Factory annotation.
TestNG: Parameterization using XML & DataProvider in Selenium*/
	/* How to pass parameter from testing.xml to Test Cases
	• What is @Parameters annotation in TestNG
	• How to configure testing.xml file with Parameters tag
	• How to define Environment Variables in testng.xml
	• Run your test cases with testing.xml file*/
	//case if the parameter name is same in suite level and test level then test level parameter will get preference over suite level. 
	
	//Now, parameters can be defined at 2 levels

//Suite level – The parameters inside the <suite> tag of TestNG XML file will be a suite level parameter.
//Test Level -- The parameters inside the <Test> tag of testing XML file will be a Test level parameter.
	
	@Test
	@Parameters ({"Browser","url","emailid"}) //it will to testng1.xml and will take the value and give it to String Variable  which is added as a paramter in
	//yahooLoginTest method.
	/*<parameter name="url" value="https://login.yahoo.com/"/>
  <parameter name="emailid" value="poojapiple@yahoo.com"/>*///These are environmental variable becoz they are general throughout the progrsm.
    
	public void yahooLoginTest(String Browser ,String url1,String emailid1) throws InterruptedException {
		
		if(Browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		    driver=new ChromeDriver();
		}else if(Browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\geckodriver.exe");
		    driver=new FirefoxDriver();
		} 
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url1);
		
		driver.findElement(By.xpath("//input[@class='phone-no ']")).clear();
		driver.findElement(By.xpath("//input[@class='phone-no ']")).sendKeys(emailid1);
		Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='login-signin']")).click();
	//created testng1.xml file.//testng.xml file is also called as template file or runner file.
	//this file is used to execute all the test cases one by one and test classes one by one.
	// and testng1.xml file.
	
	}

}	
//Data Driven by multiple approaches.
//a.Excel File
//b.Properties
//c.tetsng.xml file.
//d.Json file.
//e.DB 
//Your @Parameters do not have a corresponding value in testing.xml.
//You can solve this situation by adding @optional annotation in the corresponding parameter in the test method.
//You can have multiple different parameters ,each parameter can only have a single value.
//. If you want to use multiple values for a parameter use DataProviders
//advantages of parameterers
//. This helps prevent hardcoding values into the script. This makes code reusable. 