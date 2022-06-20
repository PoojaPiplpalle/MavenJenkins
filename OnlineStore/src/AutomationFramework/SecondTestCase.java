package AutomationFramework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SecondTestCase {
public static void main(String[] args) throws  InterruptedException {
		// TODO Auto-generated method stub
		//set the chromedriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
	//create a reference variable for the interface of driver and assign an object of class chromedriver,these interfaces and classe are provided in seleniuem jar file so need to import that.
	// and use a constructor to initilise a ref varibale with object 

//Webdriver is interface and ChromeDriver  is class.
		//Instantiating the Chromedriver.ie meaing creating the object of chromedriver.
WebDriver driver =new ChromeDriver();//after this chrome will be launched
driver.get("https:www.facebook.com" );//launching the  broswer session and redireting it to url
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
//The "driver.close()" method is used to close the browser window.
//Impicit wait if no elemnet found error
//driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
//Locator is a command that tells Selenium IDE which GUI elements ( say Text Box, Buttons, Check Boxes etc) its needs to operate on.
// there are toral 8 locator.
 
//id is always unique--1st pre ference.
//driver.findElement(By.id("login-username")).sendKeys("Pooja.rani@yahoo.in");
// name is unique locator--1st preference
//driver.findElement(By.name("signin")).click();
driver.findElement(By.id("login-username")).sendKeys("Pooja.rani@yahoo.in");
driver.findElement(By.id("login-username")).sendKeys(Keys.TAB);
driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
//driver.findElement(locator).sendkeys(Keys.ARROW_DOWN,Keys.ENTER);for dropdown
//driver.manage().deleteAllCookies();


//driver.findElement(By.name("signin")).click();

//By Xpath--2 nd preference.
// driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("Pooja.rani@yahoo.com");
// driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
//driver.findElement(By.xpath("//input[@id='login-signin']]")).click();
// driver.findElement(By.id("login-signin")).click();
//explicit wait if no elemt found
//WebDriverWait wait=new WebDriverWait(driver, 3);
//WebElement emailfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-signin")));
//emailfield.click();  

//CSS Selectors are string patterns used to identify an element based on a combination of HTML tag, id, class, and attributes. Locating by CSS Selector is more complicated than the previous methods, but it is the most common locating strategy of advanced Selenium users because it can access even those elements that have no ID or name.
//css selector-2nd preference
//driver.findElement(By.cssSelector`("#login-username")).sendKeys("kiku.rani@yahoo.in");
//driver.findElement(By.cssSelector("#login-signin")).click();
//css selector are faster to traverse while xpath traverse from to top to bottom through parent node.
//linkText-4th -//Locating by Link Texts 
//This type of locator applies only to hyperlink texts.
driver.findElement(By.linkText("Forgot username?")).click();
//driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
//driver.findElement(By.linkText("Create an account")).click();
	}
	}