package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {
	
	public static void main(String[] args) {	
		//Get test data from excel.
		Xls_Reader reader=new Xls_Reader("C:\\Users\\lenovo\\Documents\\ToolsQA\\OnlineStore\\src\\com\\testdata\\EbayTestDataDriven.xlsx");//creatd the object of Xls_Reader class and then pasted the path of ebaytestdata excel file.
		String Firstname=reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(Firstname);

		
		String LastName=reader.getCellData("RegTestData", "surname", 2);
		System.out.println(LastName);
		
		String EmailAddress=reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(EmailAddress);
		
		String Password=reader.getCellData("RegTestData", "password", 2);
		System.out.println(Password);
		//WebDriver Code.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	//click,move and release are the manual steps to drag one objecct from source to target.
 driver.get("https://reg.ebay.in/reg/PartialReg");
 driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(Firstname);
 driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(LastName);
 driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(EmailAddress);
 driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(Password);
driver.quit();



	
	}

}
//Data Provider in TestNG is a method used when a user needs to pass complex parameters. Complex Parameters need to be created from Java such as complex objects, objects from property files or from a database can be passed by the data provider method. The method is annotated by @DataProvider and it returns an array of objects.
//There are two parameters supported by DataProvider are Method and ITestContext.
//In real-life, you can use ITestContext to vary parameter values based on Test Methods, hosts, configurations of the test.
//There are two type of parameters supported by DataProvider method.

//Method- If the SAME DataProvider should behave differently with different test method , use Method parameter.

//Apache poi Framewrok
//First donwload the apache poi jar file and import in project
//2.Create a package and create a class from which we are writing selenium code that means creating object of XLx Reader object and passing the TestData sheet excel path and then through object refrence calling method which are present in XLS_Reader class
//3.Create package and paste the class XLs_reader.java which contains all method of excel operation
//44.Create and package and paste the excel file which u haved in some folder and from where u r reading data


//Download the apache poi library to read the data from excel.
//1.Go to google and and download apache poi and go to binary distribution and download tar.gz and clickon https wala link and it will get downloaded.
//Extract the file and import all the jar files present in folder.
//add class in com.excel.utlity by using this link https://github.com/naveenanimation20/NewExcelUtil2020_ApachePOI/blob/master/src/main/java/com/excel/lib/util/Xls_Reader.java
