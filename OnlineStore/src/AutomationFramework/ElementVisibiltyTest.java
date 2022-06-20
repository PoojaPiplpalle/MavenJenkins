package AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibiltyTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.get("https://www.freecrm.com/ ");
		driver.get("https://artoftesting.com/check-if-a-checkbox-is-checked-in-selenium-webdriver-java");
		Thread.sleep(10000);
		/*driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Poojaranip14@gmail.com");
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1@");
		//1.isDisplayed method is applicable for all the element.
		boolean b1=driver.findElement(By.xpath("//div[text()='Login']")).isDisplayed();//isDisplayed() method returns one boolean value// this is for login button.
		//if login button is displayed in the page then it will return true otherwise false.
		System.out.println(b1);//true.
		//Is Enabled method.
	boolean b2=	driver.findElement(By.xpath("//div[text()='Login']")).isEnabled();*///if element is enabled it will return true if disabled it will return false.
	//System.out.println(b2);//
		//Q :when the button is enabled then at the time of interview u can give eg of i agree to the terms and conditiom .
		//IsSelected() method is applicable to only dropdown, checkbox, radiobutton.
	WebElement Checkbox=driver.findElement(By.xpath("//input[@name='wp-comment-cookies-consent']"));
	scrolIntoView(Checkbox,driver);
	Thread.sleep(2000);
	//IsSelected() method is applicable to only dropdown,checkbox,radiobutton.
	Checkbox.click();
	boolean b4=driver.findElement(By.xpath("//input[@name='wp-comment-cookies-consent']")).isSelected();
	System.out.println(b4);//Will retun true if checkbox is olready selected.
	
	//To deselect the checkbox again click on element
	Thread.sleep(1000);
	Checkbox.click(); 
	boolean b5=driver.findElement(By.xpath("//input[@name='wp-comment-cookies-consent']")).isSelected();
	System.out.println(b5);//False
	}
	public static void scrolIntoView(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].scrollIntoView(true);",element);//true means keeps scrolling until particluar element is visible.
	}
}


/*1. isDisplayed() is the method used to verify the presence of a web element within the web page. The method returns a “true” value if the specified web element is present on the web page and a “false” value if the web element is not present on the webpage.
2. isDisplayed() is capable to check for the presence of all kinds of web elements available.
3. isEnabled() is the method used to verify if the web element is enabled or disabled within the web page.
4. isEnabled( ) is primarily used with buttons.
5. isSelected() is the method used to verify if the web element is selected or not. 6. isSelected() method is predominantly used with radio buttons, dropdowns and checkboxes.*/
