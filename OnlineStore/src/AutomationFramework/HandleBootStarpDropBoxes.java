package AutomationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBootStarpDropBoxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Telling selenium driver to wait for 40 sec to load the page and thn perform action.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		driver.manage().window().maximize();
		driver.findElement(By.id("dropdownMenuButton")).click();
	List<WebElement> list=	driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton'] //a"));
	System.out.println(list.size());
	for(int i=0;i<list.size();i++) {
		
		System.out.println(list.get(i).getText());
		Thread.sleep(2000);
		if(list.get(i).getText().equals("Action"))
{
	list.get(i).click();
	break;
}
	}
	
	}

}
