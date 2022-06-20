package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class DoubleClickRightClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Dynamic wait:
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	String attile=driver.getTitle();
		Actions action=new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();

Thread.sleep(2000);
driver.findElement(By.xpath("//span[text(s)='Copy']")).click();

System.out.println(driver.switchTo().alert().getText());
driver.switchTo().alert().accept();
driver.quit();
	}

}
