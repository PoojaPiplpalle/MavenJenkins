package AutomationFramework;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownPart3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/ ");
		//WebElement day=driver.findEl ement(By.id("day"));
		//WebElement Month=driver.findElement(By.id("month"));
		//WebElement Year=driver.findElement(By.id("year"));
		//Without using select class how will we select value.
		String u="Test";
		String str="https://"+ u + ":"+ u + "@" + "https://www.facebook.com/ ";
	List<WebElement> YearList=driver.findElements(By.xpath("//select[@id='year']//option"));//parent tag and child tag
		//driver give me list of year where xpath is like this and store in YearList object 
	System.out.println(YearList.size());
	for(int i=0;i<YearList.size();i++) {
		System.out.println(YearList.get(i).getText());
		if(YearList.get(i).getText().equals("2000")) {
			YearList.get(i).click();
			
			
		}
		
	}
		
		
		
		
		
	}

}


