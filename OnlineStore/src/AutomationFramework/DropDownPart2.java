package AutomationFramework;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPart2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\WebDriverinstance\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/ ");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@role='button'])[4]")).click();
		WebElement day=driver.findElement(By.id("day"));
		WebElement Month=driver.findElement(By.id("month"));
		WebElement Year=driver.findElement(By.id("year"));
		
	Select select=new Select(day);

	
	// question-which is best selectbyvisbletext or selectbyindex?
	//Index is risky olways we should never use it becoz lets say in country dropdown i want to select india and it came in 5 postion but after some days 2 more countries added and india comes in 7 th position so we should never use it.
	//Deselect all will deselct all the value from the dropdown.
	
	//select.isMultiple(); will return true or false on console if dropdown we can select multiple or not.
	System.out.println(select.isMultiple());
	java.util.List<WebElement> Listofdays= select.getOptions();//will print no of the values from the dropdown or size of the dropdown or give list of all option
	System.out.println(Listofdays.size());
	int TotalDays=Listofdays.size()-1;
	System.out.println("Total days in dropdown:"+TotalDays);
	// to display the value of all dropdown
	for(int i=0;i<Listofdays.size();i++) {
		Listofdays.get(i).getText();//print all the va lues from dropdown
		String dayval  =Listofdays.get(i).getText();
		if(dayval.equals("15")) {
			Listofdays.get(i).click();
			break;
		}
		System.out.println(dayval);
	}
		Select select1=new Select(Month);
		java.util.List<WebElement> listofmonth=select1.getOptions();
		System.out.println(listofmonth.size());
		int TotalMonth =listofmonth.size()-1;
		System.out.println("Total No of month:"+ TotalMonth);
		for(int i=0;i<listofmonth.size();i++) {
			
	String Monval=listofmonth.get(i).getText();
	System.out.println(Monval);
	
			
		}
		
	
	
	}

}
/*deselectAll(): It clears all selected entries. This is only valid when the drop-down element supports multiple selections.

Example: oSelect.deselectAll(); 

deselectByIndex(): It deselects the option at the given index.

Example: oSelect.deselectByIndex(2);

deselectByValue(): This method helps in deselecting the option whose “value” attribute matches the specific parameter.
Example: oSelect.deselectByValue(“13”);

deselectByVisibletext():deselectByVisibletext():This method helps in deselecting the option that displays the text matching the parameter.*/
