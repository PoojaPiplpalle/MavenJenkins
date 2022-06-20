package AutomationFramework;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapdropBox {

	public static void main(String[] args) {
		// TODO -generated method stub  
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Telling selenium driver to wait for 40 sec to load the page and thn perform action.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		//button[@type='button' and @class='multiselect dropdown-toggle btn btn-default' ]
		driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle btn btn-default')]")).click();
	List<WebElement> list=	driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
	System.out.println(list.size());
	/*for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().contains("jQuery")) {
 		list.get(i).click();

		}
if(list.get(i).getText().contains("MySQL")) {
	list.get(i).click();
	break;
	
	
}
		}*/
	
	//this for loop will select all value.
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i).getText());
		/*if(list.get(i).getText().equals("jQuery")) {
			list.get(i).click();
			
			
		}*/
		list.get(i).click();
		
		}

//This for loop is for selecting one dropdown.
/*for(int i=0;i<list.size();i++) {
System.out.println(list.get(i).getText());
if(list.get(i).getText().equals("jQuery")) {
	list.get(i).click();
	break;
	
}

}
*/
	}

}
