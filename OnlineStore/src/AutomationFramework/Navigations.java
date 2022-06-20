package AutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		//Difference between driver.get and driver.navigate().to?
		//both are used to  launch the url but driver.navigate().to will use to launch the external url
		
		driver.navigate().to("https://www.amazon.com");// if u want to move to exteral url.
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().forward();
		Thread.sleep(2000);
		 
		//driver.navigate().back();
		driver.navigate().refresh();/// it will refresh the page.
		
	}

}
