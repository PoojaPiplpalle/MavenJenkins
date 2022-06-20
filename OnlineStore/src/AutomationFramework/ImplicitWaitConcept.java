package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
	//if lots of contents are present in site or slow internet so it will take time to load.so selenium will not wait to finf element and will give element not visible exception.
	// Dynamic wait: if page loaded within 2 sec then rest of seconds will be ignored which is mentioned in method.
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Telling selenium driver to wait for 40 sec to load the page and thn perform action.
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// implicitlyWait is for all the element available in the page for eg page is loaded fully but some element are not visble they are taking time to load
	//Thread.sleep is hard wait i.e static wait every time it will wait for those seconds mentioned in method.
	// Two disadvantage of Thread.sleep:
	//1.script will be paused for those many second.
	// 2.lets says element still not visible within those second then there is no use of thread .sleep.
	
	}

}
