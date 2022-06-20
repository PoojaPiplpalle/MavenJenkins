package AutomationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https:www.google.com");
		driver.findElement(By.name("q")).sendKeys("Testing");
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']//span"));//ui is parent and li is child and use descendent means child of li.
	System.out.println("Total no of suggestion in search box:"+list.size());
for(int i=0;i<list.size();i++) {
	System.out.println(list.get(i).getText());
	if(list.get(i).getText().equals("testing interview questions")) {
		
		list.get(i).click();
		break;
	}
	
	
}
	
	}

}
