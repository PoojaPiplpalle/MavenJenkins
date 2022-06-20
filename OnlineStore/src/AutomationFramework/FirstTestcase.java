package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FirstTestcase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//set the chromedriver
System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
	//create a reference variable for the interface of driver and assign an object of class chromedriver,these interfaces and classe are provided in seleniuem jar file so need to import that.
	// and use a constructor to initilise a ref varibale with object 

//Webdriver is interface and ChromeDriver  is class.
//Normally, this is how a driver object is instantiated.
WebDriver driver =new ChromeDriver();
//using ref var driver to call method to open an website.
//WebDriver's get() method is used to launch a new browser session and directs it to the URL that you specify as its parameter.
driver.get(" https://www.google.com/");
driver.manage().deleteAllCookies();
//Maximise the window.
driver.manage().window().maximize();
//find the elements 
driver.findElement(By.className("gb_g")). click();
driver.get("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
Actions action=new Actions(driver);
action.moveToElement(driver.findElement(By.id("identifierId"))).keyDown(driver.findElement(By.id("identifierId")),Keys.SHIFT).sendKeys("poojaranip").keyUp(driver.findElement(By.id("identifierId")),Keys.SHIFT).build().perform();;

//driver.findElement(By.id("identifierId")).sendKeys("Pooja.rani@gmail.com");
Thread.sleep(2000);
//go to next button i.e next button
//driver.findElement(By.className("CwaK9")).click();	
//building a test case i.e declare a variable of string type of name at and ask the driver to get me the title of webpage that wil automatically  open
//String at=driver.getTitle();
//Expected title 
//String et="Gmail";
//close the browser  thatt is opened
//driver.close();
//if (at.equalsIgnoreCase(et))
{
	System.out.println("Testsuccessfull");
	
}
//else
{
	System.out.println("Test failed");
}
	}
	
}
//If you use this command without closing all browser windows first, your whole Java program will end while leaving the browser window open.

//system.exit(0);
//Initializing a variable means specifying an initial value to assign to it (i.e., before it is used at all). Notice that a variable that is not initialized does not have a defined value, hence it cannot be used until it is assigned such a value.
//If the variable is instance or static variable then you don't have to assign any value it's by default value is 0 (Assigned by jvm).

//If variable is local you have to assign value before using it. If you are not using any variable then it's fine not assign any value and it will not show any error.