package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ThirdtestcasePartiallink {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//set the chromedriver
System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
	//create a reference variable for the interface of driver and assign an object of class chromedriver,these interfaces and classe are provided in seleniuem jar file so need to import that.
	// and use a constructor to initilise a ref varibale with object 

//Webdriver is interface and ChromeDriver  is class.
WebDriver driver =new ChromeDriver();
//using ref var driver to call method to open an website.
driver.get("https://login.yahoo.com/"); 
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
//Partial Link -only for link but not recommended.only if link is too large we can use  pass partial link --5th preference.
//driver.findElement(By.partialLinkText("Forgot")).click();
// by cLassName-it is not recommened becoz it can be duplicate for same element.-4rth preferring
driver.findElement(By.className("phone-no")).sendKeys("kiku@yahoo.com");
//By.tagName("") 
//Select select = new Select(driver.findElement(By.tagName("select")));
//TagName can be used with Group elements like , Select and check-boxes / dropdowns.


}
}
