package AutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\New folder\\WebDriverinstance\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		//In Interview Question: how many total links are present in website and give the text of all link?
//get the count of link on the page
		//get the text of each link.
		int sizw=driver.findElements(By.tagName("a")).size();
		System.out.println("size of :"+sizw);
	List<WebElement> linklist=driver.findElements(By.tagName("a"));
	//size of linklist.
	System.out.println(linklist.size());//if u want to count how many input/buttons are there just write input /button inside tagname method.
	// to print all the text of each link- use for loop.
	for(int i=0;i<linklist.size();i++) {
	String linktext=	linklist.get(i).getText();//get method is use to get the value of listobject.
		System.out.println(linktext);
	}
	}
	
}
