package AutomationFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Q: what is javascriptExecutor?
		//JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver.
		//Ans: javascriptExecutor is a class and we have to  cast our driver into javascriptExecutor and once it is done with use of js ref we are calling executeScript method.
		//JavaScriptExecutor provides two methods "executescript" & "executeAsyncScript" to run javascript on the selected window or current page.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[text()='Bootstrap']")).click();	
		//driver.findElement(By.xpath("//button[@id='dropdownMenuButton' ]")).click();
		driver.get("https://www.freecrm.com/ ");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Poojaranip14@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[text()='Login']")).click();
		WebElement loginBTN=driver.findElement(By.xpath("//div[text()='Login']"));
	flash(loginBTN,driver);//highlight a element.
	drawBorder(loginBTN,driver);//draw a border.
	
	//loginBTN.click();
	//Take a screenshot.
	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("C:\\Users\\lenovo\\Documents\\ToolsQA\\OnlineStore\\src\\AutomationFramework\\element.png"));
	//Generate alert.
	//generateAlert(driver,"There is an issue with login button on login page");
	
	//Click on any element.
	clickElementByJS(loginBTN,driver);
	//Refresh the page.
	//.By using selenium.
	driver.navigate().refresh();
	//By using javascript.
	refreshBrowserByJS(driver);
	
	//Get the title of the page By JS.
	
	System.out.println(getTitleByJS(driver));
	
	//Get the page text.
	System.out.println(getInnerPageTitle(driver));
	//Scroll Page
	//scrollPageDown(driver);
	
	//Keep scrolling down until u find the text of element.
	WebElement ForgetYourPassword=driver.findElement(By.xpath("//a[text()='Forgot your password?']"));
	scrolIntoView(ForgetYourPassword,driver); 
	ForgetYourPassword.click();
	}
	public static void flash(WebElement element, WebDriver driver){
		 JavascriptExecutor js = ((JavascriptExecutor) driver);//Casting the driver into JavascriptExecutor so it will become object of javascript and we storing it in js.
		 String bgcolor=element.getCssValue("backgroundColor");
		 for(int i=0;i<20;i++) {//Using for loop to highlight the particular element 10 times
			 changeColor("rgb(0,200,0)",element,driver);//1
		changeColor(bgcolor,element,driver);//2//This method is called to again change the color to background.
		 }
		 }
	
	public static void changeColor(String color,WebElement element, WebDriver driver){
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
		 js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);// we are using 0 in arguments becoz there is only one element.//It is use to execute Javascript code.
		 
		 try {
			 Thread.sleep(20);
			 
		 }catch	(InterruptedException e) {
			 
			 
		 }
		 }
	public static void drawBorder(WebElement element,WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public static void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		js.executeScript("alert('"+ message+"')");
	}
	public static void clickElementByJS(WebElement element,WebDriver driver) {
		
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");//Go(0) means first history.
		
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getInnerPageTitle(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		String PageText =js.executeScript("return document.documentElement.innerText;").toString();
	return PageText;
	
	}
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrolIntoView(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].scrollIntoView(true);",element);//true means keeps scrolling until particluar element is visible.
	}
		}
//The script can return values. Data types returned are

/*Boolean
Long
String
List
WebElement.
//Type casting is nothing but assigning a value of one primitive data type to another. When you assign the value of one data type to another, you should be aware of the compatibility of the data type. If they are compatible, then Java will perform the conversion automatically known as Automatic Type Conversion and if not, then they need to be casted or converted explicitly.
*/
