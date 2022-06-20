package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class FacebookTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://www.facebook.com/r.php");
		 //Dataprovider will get the data from excel file.
}
	
	@DataProvider//will fetch data from excel file.
	public Iterator<Object[]> GetTestData() {
		ArrayList<Object[]> TestData=TestUtil.GetDatafromexcel();//GetDatafromexcel() returning Mydata object that is arraylist object
		return TestData.iterator();//we need to iterate the arraylist object and it will iterate each and every element in proper sequence becoz arraylist stores the value in sequence so it will return one by one value in sequnce.
		}
	//We need to make the the connection between @Dataprovider and @test.
	@Test(dataProvider="GetTestData")
	public void FacebookRegTest(String FirstName,String Surname,String EmailAddress,String EmailAddress1,String Password   ) {// we need to no of parameter same as excel file columns 
		driver.findElement(By.xpath("//input[@name='firstname']")).clear();
		 driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
		 
		 driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Surname);
		 
		 driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
		 driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(EmailAddress);
		 
		 driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).clear();
		 driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(EmailAddress1);
		 
		 driver.findElement(By.xpath("//input[@type='password' and @name='reg_passwd__']")).clear();
		 driver.findElement(By.xpath("//input[@type='password' and @name='reg_passwd__']")).sendKeys(Password);

		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
}

//Seqeunce of execution:

//1.Before method will execute 
//@Test will contain data provider so it is getting data from GetTestData 
// it will jump to GetDatafromexcel() and will call this method.
//open the TestUtil.java class where this method is declared so will make the connection with excel file and will fetch all the col value and store in Object array add in particular arraylist becoz arraylist store data in sequential order
//return arraylist.so arraylist myData will contains all the data and will store in testData

//then test.iterator will iterate the value one by one then it will go @test  FacebookRegTest() parameter and will start the mapping with parametre ,so
// first value of itertor will go to Firstname then go on.
//One by one all test casee will be executed.
//using Apache poi we can read the data from excel that is Xls_Reader.java file