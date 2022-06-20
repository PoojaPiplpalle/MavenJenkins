package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tooltipverification {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("http://demo.guru99.com/test/tooltip.html");
		 //Dataprovider will get the data from excel file.
		
		 //Scenario 1: Tooltip is implemented using the "title" attribute
		// Scenario 2: Tooltip is implemented using a jQuery plugin.
}
	//scenario 1:
	 @Test
	 public void testtitleattribute() {
		WebElement element=driver.findElement(By.xpath("//a[@class='github']"));
		String Expected="Github";
		//get value of title atttribute
		String actual=element.getAttribute("title");
		Assert.assertEquals(actual, "Github");
	
		
		
		
		 
	 } 
	 //scenario2:
	 @Test
	 public void jquieryplugin() {
		 
		 String expected="What's new in 3.2";
		 WebElement element=driver.findElement(By.xpath(" //a[text()='Download now']"));

	        Actions builder = new Actions(driver);							

	        builder.moveToElement(element).build().perform();
	        
	        WebElement textinsidetootip=driver.findElement(By.xpath("//div[@class='tooltip']/table/following-sibling::a"));
	     String actual  =textinsidetootip.getText();
	     Assert.assertEquals(actual, "What's new in 3.2");
	 }
	
}
