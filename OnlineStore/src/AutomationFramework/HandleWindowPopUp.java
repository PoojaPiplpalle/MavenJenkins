package AutomationFramework;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://popuptest.com/goodpopups.html");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Good PopUp #3']")).click();;
	//This will open another window i.echild window.and there are two window background one is parent window and opened one is child window.
// so we need to get the window id of parent and child window.
		//In selenium web driver there are methods through which we can handle multiple windows.
	Set<String> Handler=driver.getWindowHandles();// we are using this method becoz there are two windows.so this method will give one set object.
	//so on right side we write set object of string type,handler is object name.
	//so handler representing one set object which contains two window id's
	//Set object doesnt store vlaue on the basis of indexing.so how to get the values from set object.
	//to get the values of set object we need to use iterator.
	Iterator<String> it=Handler.iterator();//we have created one object of iterator to fetch the  value of handler which contains window id's.
	//so it(iterator object) will fetch the value by pointing on the top of set object i.e handler.
String ParentWindowId=it.next();
System.out.println("Parent Window id:"+ParentWindowId);//it.next() method will shift the it from top to the  next item to fetch the value.

String ChildWindowId=it.next();
System.out.println("ChildWindowId :"+ ChildWindowId);
//now we have to switch from parent to child window.

driver.switchTo().window(ChildWindowId);
System.out.println("Child Window Title :"+driver.getTitle());//will get the title of child window and then  will click on cross icon to close the pop up.
	driver.close();//close the child pop up but  if we use driver.quit() it will close both the window.
	driver.switchTo().window(ParentWindowId);
	System.out.println("Title of parent Window:"+driver.getTitle());
	
	//difference between driver.quit()-close all browsers and Driver.close() will close the specific browser.
	}

}
