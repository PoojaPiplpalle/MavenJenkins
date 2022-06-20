package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrmaeHandling {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		//driver.get("https://www.crmpro.com/login.cfm ");
		//driver.get("https://www.crmpro.com/index.html?e=1");
		driver.get("https://www.freecrm.com/");
		Thread.sleep(6000);
	driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Poojaranip14@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1@");
	   Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(10000);
	//here comes the exception no such element found.olways check ryt click on above the element and if "This frame section is present it means there is a frame in the application."so before using contact xpath use method switch to
	//driver.switchTo()
	driver.switchTo().frame("mainpanel");//switch from page to mainpanel frame.
	//frame method can accept either integer or string.
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
//frames are basically webpage embedded in another webpage
//if u are not able to click on contact just ryt  click on above above the element and if "This frame section is present it means there is a frame in the application."
// and if u want confirmation about if frame exist in page so ryt click on above the element and click on view source there will be framset object.
	//and if two frame panel is present then there will be left ang main panel see screenshot.
	//Basically, we can switch over the elements in frames using 3 ways.

/*By Index
By Name or Id
By Web Element*/
	//  <frame name="leftpanel" src="https://classic.freecrm.com/system/left_panel.cfm" marginwidth="0" marginheight="0" scrolling="auto" frameborder="1">
   // <frame name="mainpanel" src="https://classic.freecrm.com/system/index.cfm" marginwidth="0" marginheight="0" scrolling="auto" frameborder="0">
	//How to switch back to the Main Frame

//We have to come out of the iframe.

//To move back to the parent frame, you can either use driver.switchTo().parentFrame() or if you want to get back to the main (or most parent) frame, you can use switchTo().defaultContent();
	//Index of the iframe starts with '0'.

/*Suppose if there are 100 frames in page, we can switch to the iframe by using index.

driver.switchTo().frame(0);
driver.switchTo().frame(1);*/
	/*
	Switch to the frame by Name or ID:

		Name and ID are attributes of iframe  through which we can switch to the it.

		driver.switchTo().frame("iframe1");
		driver.switchTo().frame("id of the element");*/
	}}
