package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class SelectCalendarByJS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); //Telling selenium driver to wait for 40 sec to load the page and thn perform action.
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get( "https://www.spicejet.com");
		WebElement Date=driver.findElement(By.id("ctl00_mainContent_view_date1"));
		String dateVal="31-12-2020";  
		
		
		selectDateByJS(driver,Date,dateVal);
	}
public static void selectDateByJS(WebDriver driver,WebElement element,String dateVal) {
	
	 JavascriptExecutor js = ((JavascriptExecutor) driver);
	 js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');" ,element);
}
}
