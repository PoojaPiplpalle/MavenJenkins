 package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferncebetExplicitAndImplicit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Dynamic wait:
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//1.Implicitly wait--- is always applied for globally--is avaible for all the Webelements
	//2.Dynamic in nature.
		//3.it can be changed anywhere and at anytime.
		//Selenium for wait for 20-10 sec for all the webelment to which the driver is interacting to load and if the element still not visible it will throw element not found exception 
		//We are saying driver manage the timeout of implictly wait of 20 sec.
		//What do u mean by synchronisation in selenium?
		//Ans:Synch between selenium script,the selenium execution speed+web application speed
		//In selenium we have to provide synchronication through explicit wait.
		// synchronization basically explict wait and implicit wait.
	driver.get("https://www.facebook.com/");
	WebElement firstname=driver.findElement(By.name("firstname"));
	WebElement Surname=driver.findElement(By.name("lastname"));
	WebElement MobileNO=driver.findElement(By.name("reg_email__"));
	WebElement Password=driver.findElement(By.name("reg_passwd__"));
	//Creating one generic method for all the element.
	sendkeys(driver,firstname,10,"Pooja");
	sendkeys(driver,Surname,5,"Rani");//Advantage of generic explict wait method is u can change time here u have 5 sec.
	sendkeys(driver,MobileNO,5,"8551101694"); 
	sendkeys(driver,Password,10,"Poojadjsk");
	
	WebElement ForgetAccount=driver.findElement(By.linkText("Forgotten account?"));
	clickOn(driver,ForgetAccount,10);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//We can override the implicit wait and it will consider this wait and not the previous one.
	//You change and apply implicit wait anywhere and anytime becoz it is global wait.
	}
	//Feature of Explicit wait:
	//1.No explicit keyword or method.
	//2.Available with WebDriverWait with expectedconditions
	//3.specific to element.
	//4.Dynamic in nature.
	//5.we should never use implicit and explicit wait together
	public static void sendkeys(WebDriver driver,WebElement element,int timeout,String value) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));//Created WebdriverWait object and WebDriverWait class is olready present in selenium.
		//creating WebDriverWait and passing driver and timeout as a ref  and  until ExpectedConditions(class in selenium) that element should be visible and which element to clickable we will pass as a ref in elementToBeClickable(locator) 
		element.sendKeys(value);//Aftr above condition(Element is visible)satisfied then Pass value on above locator.
//driver wait for sometime until the expected conddition for element to visible and if condition is satisfied then use sendkeys method and pass the value.
	
	
	}
	public static void clickOn(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));//Created WebdriverWait object and WebDriverWait class is olready present in selenium.
		//creating WebDriverWait and passing driver and timeout as a ref and ignore StaleElementReferenceException until ExpectedConditions(class in selenium) that element should be clickable and which element to clickable we will pass as a ref in elementToBeClickable(locator) 
	element.click();//Aftr above condition(Element is clickable)satisfied then click on above locator.
Wait wait1=new FluentWait(driver);
	
} 
}//What are ajax component?.
//Asynchronous javascript component :Some components are taking time to load or without refreshing the page particular section is getting changed for eg score site where score is getting changed without refreshing the page.
//so especiLLY For ajax component we need to uuse Explicit wait or timeouts
//Q: Do we need explicit wait and implict wait together?
//Ans:We should always avoid implicit wait becoz implicit wait is global wait(all element),so will wait for 10 sec and but we have also added explicit wait for element individually so for eg firstname element it will wait for 30 sec unneccessary becoz implicit wait will be applied first.
//selenium recommend not use both wait together.


