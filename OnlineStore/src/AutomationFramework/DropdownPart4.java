package AutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownPart4 {
static 	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
		
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/ ");
		
		String year_xpath="//select[@id='year']//option";
		String Month_xpath="//select[@id='month']//option";
		String Day_xpath="//select[@id='day']//option";
		selectDropDownvalues(year_xpath,"2001");
		selectDropDownvalues(Month_xpath,"Jan");
		selectDropDownvalues(Day_xpath,"18");
	}
		public static void selectDropDownvalues(String xpathvalue,String value) {
		List<WebElement> YearList= driver.findElements(By.xpath(xpathvalue));//parent tag and child tag
		//driver give me list of year where xpath is like this and store in YearList object 
	System.out.println(YearList.size());
	for(int i=0;i<YearList.size();i++) {
		System.out.println(YearList.get(i).getText());
		if(YearList.get(i).getText().equals(value)) {
			YearList.get(i ).click();
			break;
	}

}
	
	
}
}