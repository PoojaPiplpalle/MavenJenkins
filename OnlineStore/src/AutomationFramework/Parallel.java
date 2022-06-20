package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parallel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\WebDriverinstance\\chromedriver.exe");
		
		 WebDriver driver1 = new ChromeDriver();
		//first session of WebDriver
		    driver1.get("http://demo.guru99.com/V4/");
		    String str1=driver1.findElement(By.xpath("//a[text()='Demo Site']")).getText();
		    System.out.println(str1);
		   // Second session of WebDriver
		  WebDriver driver2 = new ChromeDriver();
		     driver2.get("http://demo.guru99.com/V4/");
		     //There are situations where you want to run multiple tests at the same time.
	//In such cases, one can use 
		/*    The parallel attribute of sui"parallel" attributete tag can accept four values:

		    	 tests:	All the test cases inside <test> tag of Testing xml file will run parallel.
		    	 classes:	All the test cases inside a Java class will run parallel
		    	 methods:	All the methods with @Test annotation will execute parallel.
		    	 instances:	Test cases in same instance will execute parallel but two methods of two different instances will run in different thread.*/
	//Check the class multiple session
		     //executing multiple testcase simultanieuly
		     //There are situations where you want to run multiple tests at the same time.
	}

}
