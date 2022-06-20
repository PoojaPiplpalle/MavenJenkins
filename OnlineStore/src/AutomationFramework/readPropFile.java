package AutomationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class readPropFile {
static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*Selenium WebDriver Session - 9: How to read properties file using Java

		+How to c reate environment/config variable using properties file
		+How to use properties file concept in Selenium
		+Data Driven testing using properties file
		+Object repository in Selenium Webdriver*/ 
//in this class we will write the code to read the properties file
		//To read the properties file we need to create the object of properties class
		Properties prop=new Properties();//Properties class is already present in java.
	FileInputStream ip=new FileInputStream("C:/Users/lenovo/Documents/ToolsQA/OnlineStore/src/AutomationFramework/config.properties");//this class is already present in java
	// and FileInputStream class will connect with properties file and will create stream between java code and config.properties file
	//once stream established between code and properties file then load the particulR FILE.
	prop.load(ip);
	
	System.out.println(prop.getProperty("name"));//give null becox u have commented in propertiesfile.
	//System.out.println(prop.getProperty("Name"));//give null becoz no key is present.
	System.out.println(prop.getProperty("age"));
	//For url
	String url=prop.getProperty("url");
	System.out.println(url);
	
/*	String Password_xpath=prop.getProperty("Password_xpath");
	String Password=prop.getProperty("Password");*/
	String Browsername=prop.getProperty("browser");
	System.out.println(Browsername);
	
	if (Browsername.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}else if(Browsername.equals("FF")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\geckodriver.exe");
		 driver=new FirefoxDriver();	
		
	}else if(Browsername.equals("IE")) {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\internetexplorerdriver");
		 driver=new InternetExplorerDriver();	
		
	}
	driver.get(url);//we should avoid hardcoded value in script instead we should define in config file
	Thread.sleep(2000);
	/*String Password_xpath=prop.getProperty("Password_xpath");
	String Password=prop.getProperty("Password");*/
	//driver.findElement(By.xpath(prop.getProperty("Firstname_xpath"))).sendKeys(prop.getProperty("Firstname"));
	
//driver.findElement(By.xpath(prop.getProperty("Lastname_xpath"))).sendKeys(prop.getProperty("Lastname"));
	//String Password_xpath=prop.getProperty("Password_xpath");
	//String Password=prop.getProperty("Password");
	//driver.findElement(By.xpath(prop.getProperty("Password_xpath"))).sendKeys(prop.getProperty("Password"));
	driver.findElement(By.xpath(prop.getProperty("Email_xpath"))).sendKeys(prop.getProperty("Email"));
	
	}

}

/*What is an Object Repository?
An object repository is a common storage location for all objects. In Selenium WebDriver context, objects would typically be the locators used to uniquely identify web elements.

The major advantage of using object repository is the segregation of objects from test cases. If the locator value of one webelement changes, only the object repository needs to be changed rather than making changes in all test cases in which the locator has been used. Maintaining an object repository increases the modularity of framework implementation.
*/

//wherein the key refers to the name given to the object and value refers to the properties used to uniquely identify an object within the web page.

//Object Repository using Properties file
//Object Repository using XML file


//Object Repository using Properties file:
//In this approach, properties file is a text file wherein data is stored on the form of key-value pairs. The below tutorial will address the following topics.

//Reading data from properties file can be done using the built-in Properties class provided in java.util package.

//Reading data from properties file can be done using load method offered by Properties class in java. 
//properties.getProperty(“driverPath”) :Properties object gives us a .getProperty method which takes the Key of the property as a parameter and return the Value of the matched key from the .properties file.