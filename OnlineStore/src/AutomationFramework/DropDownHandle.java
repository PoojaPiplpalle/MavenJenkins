package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		 
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/ ");
		// whenever your selecting dropdown make sure html tag is select when you inspect it.
		WebElement day=driver.findElement(By.id("day"));
		WebElement Month=driver.findElement(By.id("month"));
		WebElement Year  =driver.findElement(By.id("year"));
		// if u inspect the element of dropdown and there is no select class then u should not use select class to handle dropdwon.
		
		//creating object of the select class and select class we need to use inorder to select the dropdown and  select class is olready present in selenium
	//Select select =new Select(day);
	// we need to pass Webelement in constructor on which we need to perform action 
	//select.selectByVisibleText("11");
	
	
	//Select select1 =new Select(Month);
	// we need to pass Webelement in constructor on which we need to perform action 
	//select1.selectByVisibleText("Jan");
	
	
	//Select select2 =new Select(Year);
	// we need to pass Webelement in constructor on which we need to perform action 
	//select2.selectByVisibleText("2000");
	
		
		//Calling the selectValueFromDropdown from main method
		//12,Jan and 2009 are hardcoded value so we should not used this becoz everyuser has diff dob
		String dob="20-May-2009";
		String Arrdob[]=dob.split("-");//return type of split method is array
		
		selectValueFromDropdown(day,Arrdob[0]);//so replace 12 with Arrdob[0]
		selectValueFromDropdown(Month,Arrdob[1]);//so replace May with Arrdob[1]
		selectValueFromDropdown(Year,Arrdob[2]);
	}
//so if we are having 100 dropdown we need to create 100 select class object so it is not good practice
// we are creating one generic method and we will call that generic method from main method and will pass the webelement.
public static void selectValueFromDropdown(WebElement element,String value) {
	//two thing passing as a arugumnet  1. webelement and 2. value which we want to select from dropdown.
	Select select=new Select(element);
	select.selectByVisibleText(value); 
	//The Select Class in Selenium
	//Import the package org.openqa.selenium.support.ui.Select
	//Instantiate the drop-down box as a "Select" object in WebDriver
	
}

}
