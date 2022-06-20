package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//MouseMovement Drag&Drop by using Actions class and PageLoadTimeOut &  ImplicitWait in Selenium
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://book.spicejet.com/");
		//Create Actions class object  for mousehov er.
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions action=new Actions(driver);//pass the driver refrence.
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//a[@id='Login']"));
		String color=element.getCssValue("Background_color");
		System.out.println(color);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='Login']"))).build().perform();
	
		
		//.build().perform();we are using this method to perfrom action whenever we are using actions classes.
		Thread.sleep(2000);
		driver.findElement(By.linkText("Travel Agent Login")).click();
	}

}
/*Methods of Action Class
Action class is useful mainly for mouse and keyboard actions. In order to perform such actions, Selenium provides various methods.

 Mouse Actions:

doubleClick(): Performs double click on the element
clickAndHold(): Performs long click on the mouse without releasing it
dragAndDrop(): Drags the element from one point and drops to another
moveToElement(): Shifts the mouse pointer to the center of the element
contextClick(): Performs right-click on the mouse
Keyboard Actions:

sendKeys(): Sends a series of keys to the element
keyUp(): Performs key release
keyDown(): Performs keypress without release
*/