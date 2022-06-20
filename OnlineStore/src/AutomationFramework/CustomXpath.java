package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//Q : why  you should not use absolute xpath having(Hierarchy) parent to child node becoz somtimes the element will get shift and then ur xpath will be disturbed.
		//Relative Xpath is preferred over Absolute because absolute paths are prone to errors due to any dynamic changes made in the HTML.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//Different ways to write xpath
	//1.Absolute xpath//driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Java");
	//2.Custom Xpath:-
	//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
	//3. 
	//driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java");
	//4.
	driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Java");
	//why to use contains()
	//dynamic id concept.
	// for eg element have id= test_123 then we can use By.id so after closing brower agin run the test script id might  changed to
	 //id=Test_456
	//then again test_65 id is dynamic.so you should change the script again and again so solution is use contains
	// write Like this:Handle dynamic id methods:
	
 
	//1.driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Java");
	//2.driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Java");
	//For eg id= test_test_7890_test
		
	// so for below cases you cannot use starts with either you can use contains or use one more method mentioned below.
	//id=123_test_t
	//id=456_test_t
	//id=6826_test_t
	
	//driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendkeys("Java");
	//diffrence  between absolute and custom xpath:=1.Performance is poor in case of hierarchical absolute xpaths so it is not recommended to write custom xpaths.
	//2. abosulte xpaths are not reliable one day it will work other day it wont.
	//3.Can be change at any time.
	
	}
	
	//Absolute Xpath: It uses Complete path from the Root Element to the desire element. Relative Xpath: You can simply start by referencing the element you want and go from there. Relative Xpaths are always preferred as they are not the complete paths from the root element. ... So Always use Relative Xpaths in your Automation.
}
