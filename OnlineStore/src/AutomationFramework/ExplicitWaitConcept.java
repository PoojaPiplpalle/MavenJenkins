package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
	//In Explicility wait lets say page is fully loaded but some elements are still nt visible or loaded so we are explicitly waiting for some element to load.	
	//For explicity wait write one std method.	
		clickOn(driver,driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")),20); //Login button and will till 20 sec and after 20 sec will throw error becoz xpath is incorrect.
		//Wait for 20s for login button visible or not. 
	//Waiting Explictily for log in button and if element is visible within  secs then rest of the seconds will be ignored.
		clickOn(driver,driver.findElement(By.xpath("//*[@id=\"reg_pages_msg\"]/a")),20);//Create a page link
	}
	public static void clickOn(WebDriver driver,WebElement locator,int timeout) {
		
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		new FluentWait(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(20, TimeUnit.SECONDS).ignoring(Exception.class).until(ExpectedConditions.presenceOfElementLocated((By) locator));//Created WebdriverWait object and WebDriverWait class is olready present in selenium.
		//creating WebDriverWait and passing driver and timeout as a ref and ignore StaleElementReferenceException until ExpectedConditions(class in selenium) that element should be clickable and which element to clickable we will pass as a ref in elementToBeClickable(locator) 
	locator.click();//Aftr above condition(Element is clickable)satisfied then click on above locator.
	//new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(locator));
//Q: difference between explict and implicit wait?
	//The explicit wait is used to tell the Web Driver to wait for certain conditions (Expected Conditions) or the maximum time exceeded before throwing an "ElementNotVisibleException" exception.
	//The fluent wait is used to tell the web driver to wait for a condition, as well as the frequency with which we want to check the condition before throwing an "ElementNotVisibleException" exception.
	}// In such scenarios, the fluent wait is the ideal wait to use as this will try to find the element at different frequency until it finds it or the final timer runs out.
//Wait wait = new FluentWait(WebDriver reference)
	//.withTimeout(timeout, SECONDS)s
	//.pollingEvery(timeout, SECONDS)
	//.ignoring(Exception.class);
	// the below example, we are creating reference wait for "WebDriverWait" class and instantiating using "WebDriver" reference, and we are giving a maximum time frame of 20 seconds.
//WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
//he Explicit Wait in Selenium is used to tell the Web Driver to wait for certain conditions (Expected Conditions) or maximum time exceeded before throwing "ElementNotVisibleException" exception.
	//The Fluent Wait in Selenium is used to define maximum time for the web driver to wait for a condition, as well as the frequency with which we want to check the condition before throwing an "ElementNotVisibleException" exception. It checks for the web element at regular intervals until the object is found or timeout happens.
}
