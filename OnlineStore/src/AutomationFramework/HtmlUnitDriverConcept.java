package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		//HtmlUnitDriver is not part of selenium 3.x version.
		//To use this concept,we have to download HtmlUnitDriver Jar files.
		// Go to google ad write HTMLunit driver jar download.
		// So it will not open chrome browser.
		//Advantages of HtmlUnitDriver:
		//1.Testing is happening behind the scene-No browser is launched.
		///2.Execution of testcase is fast.
		//3.Not suitable for action class--user action--Mouse Movement,double click,drag and drop..
		// It is also called ghost driver--Headless Browser means 
		//There are various headless Browser.
		//1.HtmlUnitDriver--Java//2.PhantomJS--Javascript 	
		
		
	WebDriver driver=new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/");
		Thread.sleep(2000);
		System.out.println("Before login:Title is:"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Poojaranip14@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		System.out.println("After login:Title is:"+driver.getTitle());
	
	}

} 
//A headless browser is a web-browser without a graphical user interface. This program will behave just like a browser but will not show any GUI.
