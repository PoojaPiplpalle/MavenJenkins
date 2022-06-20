package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParametrizedTest {

	public static void main(String[] args) {
		//Webdriver Code
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.get("https://www.facebook.com/r.php");
		
		 //Data Driven Approach:Use to create data driven framwork or driving the testdata from excel files
		 //Get testData from excel:
		 
		Xls_Reader reader=new Xls_Reader("C:\\Users\\lenovo\\Documents\\ToolsQA\\OnlineStore\\src\\com\\testdata\\EbayTestDataDriven.xlsx");
	int rowCount=	reader.getRowCount("RegTestData");
	
	reader.addColumn("RegTestData", "Status");//Adding coloumn in sheet.
	
	//Parameterization using for loop.
	for(int rowNo=2;rowNo<=rowCount;rowNo++) {
		String FirstName=reader.getCellData("RegTestData", "firstname", rowNo);
		System.out.println(FirstName);
	
		String Surname=reader.getCellData("RegTestData", "surname", rowNo);
		System.out.println(Surname);
		
		String EmailAddress=reader.getCellData("RegTestData", "emailaddress", rowNo);
		System.out.println(EmailAddress);
		
		String EmailAddress1=reader.getCellData("RegTestData", "emailaddress", rowNo);
		System.out.println(EmailAddress1);
		
		String Password=reader.getCellData("RegTestData", "password", rowNo);
		System.out.println(Password);
		
		
		
	
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

 reader.setCellData("RegTestData", "Status", rowNo, "Pass");//write the data.
 
	}
	}
}
