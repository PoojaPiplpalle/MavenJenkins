package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	//click,move and release are the manual steps to drag one objecct from source to target.
driver.get("https://jqueryui.com/droppable/");
//So there is frame so ryt click and click on view source and search fro frame.
driver.switchTo().frame(0);//we have written 0 becoz there was only one frame available.
	//To perform Drag and Drop we need to create Action class object.
	Actions action=new Actions(driver);
	// manually we first click and hold source.
	action.clickAndHold(driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"))).moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]"))).release().build().perform();;
	//after that move to element on the	 target by using movetoElement and then release it by using release() method.
	// interview question : how to perform drag and drop?.
action.clickAndHold(driver.findElement(By.xpath(""))).moveToElement(driver.findElement(By.xpath(""))).release().build().perform();
	}

}
