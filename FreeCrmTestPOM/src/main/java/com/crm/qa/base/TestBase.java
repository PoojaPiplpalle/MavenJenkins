package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver  driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
		
		 prop=new Properties();
		 try {
			FileInputStream ip=new FileInputStream("C:\\Users\\lenovo\\Documents\\ToolsQA\\FreeCrmTestPOM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void 	initialization() {
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))  {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		    driver=new ChromeDriver();
		}
		

		e_driver = new EventFiringWebDriver(driver);//create object(e_driver) of eventfiringWebDriver class and create ref variable e_driver and driver as parameter
		/*WebEventListener class
		create WebEventListener class in com.crm.qa.util package. and copy paste the code
		In TestBase.Java after launching the chrome create object(e_driver) of eventfiringWebDriver class and create ref variable e_driver and driver as parameter
		create object(eventListener) of WebEventListener class
		ad register eventListener with eventfiringWebDriver Object.
		 and assign e_driver to driver.*/

		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		//WebEventListener class->It is use to generate the selenium action logs.
		eventListener = new WebEventListener();//create object(eventListener) of WebEventListener class
		e_driver.register(eventListener);//and register eventListener with eventfiringWebDriver Object.
		driver = e_driver;//assign e_driver to driver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
}
