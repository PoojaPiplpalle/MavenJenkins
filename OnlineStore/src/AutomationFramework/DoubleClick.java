package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		//Dynamic wait:
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//*[@id="example-1"]/div[2]/iframe
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://api.jquery.com/dblclick/");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1\"]/div[2]/iframe")));
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Double click the block']//parent::body//div"))).build();
		Thread.sleep(2000);
		action.doubleClick(driver.findElement(By.xpath("//span[text()='Double click the block']//parent::body//div"))).perform();




	}

}
