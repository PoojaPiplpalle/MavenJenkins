package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthTestCasexpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.freecrm.com/ ");
		Thread.sleep(2000);
		// how to write xpath for sign up button
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Poojaranip14@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		//driver.get("https://www.freecrm.com/");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='About']")).click();//for about button
		
		//for input type for login button
		//x path=//input[@type='submit' and @value='login'];
		//button[@class='ytp-large-play-button ytp-button' and @aria-label='Play']
		//for login button.
		
		
		
		
		
	}

}
