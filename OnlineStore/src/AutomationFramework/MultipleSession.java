package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleSession {

	 @Test    
	    public void executSessionOne(){
	            //First session of WebDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
	            WebDriver driver = new ChromeDriver();
	            //Goto guru99 site
	            driver.get("http://demo.guru99.com/V4/");
	            //find user name text box and fill it
	            driver.findElement(By.name("uid")).sendKeys("Driver 1");
	            
	        }
	        
	    @Test    
	        public void executeSessionTwo(){
	            //Second session of WebDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	            //Goto guru99 site
	        driver.get("http://demo.guru99.com/V4/");
	        //find user name text box and fill it
	        driver.findElement(By.name("uid")).sendKeys("Driver 2");
	        
	        }
	        
	    @Test    
	        public void executSessionThree(){
	            //Third session of WebDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	            //Goto guru99 site
	        driver.get("http://demo.guru99.com/V4/");
	        //find user name text box and fill it
	        
	        driver.findElement(By.name("uid")).sendKeys("Driver 3");
	        
	        }        
	   /* How to run Parallel Tests with Selenium
	    There are situations where you want to run multiple tests at the same time.

	    In such cases, one can use "parallel" attribute

	    Parallel Execution & Session Handling in Selenium

	    The parallel attribute of suite tag can accept four values:

	    tests	All the test cases inside <test> tag of Testing xml file will run parallel.
	    classes	All the test cases inside a Java class will run parallel
	    methods	All the methods with @Test annotation will execute parallel.
	    instances	Test cases in same instance will execute parallel but two methods of two different instances will run in different thread.
	    The attribute thread-count allows you to specify how many threads should be allocated for this execution.*/
}
