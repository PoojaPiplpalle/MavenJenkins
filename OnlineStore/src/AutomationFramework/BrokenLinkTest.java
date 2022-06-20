package AutomationFramework;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
//Q: how to find how many broken links are present?
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		//driver.get("https://www.freecrm.com/ ");
		driver.get("https://makemysushi.com/404? ");
		Thread.sleep(10000);
		/*driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Poojaranip14@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();*/
		
		//Links are available in form of a tag.lets say in "a" tag some wrong link is present<https://www.google123.com>thats means it is wrong link
		//Images are available in form of img tag
		//Steps:
		//1.Get the list of all links and images.[
	List<WebElement> linklist	=driver.findElements(By.tagName("a"));
	linklist.addAll(driver.findElements(By.tagName("img")));//we have added img related also in list.
	//creating listobject of links having +ref properties i.e active links.
	System.out.println("Size of linklist:"+linklist.size());
	List<WebElement> Activelinks=new ArrayList<WebElement>();
	//2.Iterate linklist using for loops and exculde all links and images which doesnt have href Attribute.
	//Thread.sleep(5000);
	for(int i=0;i<linklist.size();i++) {
		//System.out.println(linklist.get(i).getAttribute("href"));
		//There are some url starting wiht javascript so there will be error so adding one more condition and! mark make the condition of javascript false.
		if(linklist.get(i).getAttribute("href")!=null&& (!linklist.get(i).getAttribute("href").contains("javascript"))) {
			
			
			Activelinks.add(linklist.get(i));
		}
		
	}
	//Get the size of active links.
	Thread.sleep(2000);
	System.out.println("Size of Active links and images:"+Activelinks.size());
	Thread.sleep(2000);
	//3.check the href url with httpconnection api.
	//Response code:
	//200->Ok
	//404->Not found.
	//500-Internal error.
	//400-->Bad Request.
	for(int j=0;j<Activelinks.size();j++) {
		//one class is present i.e url class so create object ro url class and we have HttpURlConnection class is present.
		//we have casted and it will check href url is correct or not.
		HttpURLConnection connection=	(HttpURLConnection)new URL(Activelinks.get(j).getAttribute("href")).openConnection();	
		//Every URL is associated with HTTP protocol so we are casting to it HttpURLConnection and openConnection() will open the connection with particular url.
		//and once connection is open will return one connection object and we are storing in HttpURLConnection object.
		connection.connect();//We have connected to particular URl.
	String response=connection.getResponseMessage();//will return "OK	" if link is perfectly fine.
		connection.disconnect();
		System.out.println(Activelinks.get(j).getAttribute("href")+"----"+response);
	}
	}
}
