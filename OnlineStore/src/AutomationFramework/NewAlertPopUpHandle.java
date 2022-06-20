package AutomationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewAlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Different types of pop up:
		//1.Alerts-Javascript pop up-Alert APi(Accept and dismiss)
		//2.File upload pop up- Type- (file) and use sendkeys.
		//3.Browser window pop up-Adversimnet pop up(Window Handler APi)
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
	//	Pop up with ok and cancel button are javascript pop which are defined by develpoer.
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	//Dont use the xpath of sign in button becoz it has hierarcy pattern.
	driver.findElement(By.name("proceed")).click();//clicking on sign in button.
	//after that we need tp perform to operation
	//1.To get the text and 2.to click on ok button of pop up.
	// and there are two screen 1.background and pop up screen.so we have to switch from background screen to pop up screen.
	Alert alert=driver.switchTo().alert();//will  switch from background screen to pop up screen.
	//driver.switchTo().alert() will give you one RemotAlert class object so will store in some Alert refrence.1
//The piece of code driver.switchTo().alert() returns an object of class RemoteAlert which implements the Alert interface. The RemoteAlert is a private class inside the RemoteWebDriver class..
	//Alert interface provides the below few methods which are widely used in Selenium Webdriver.
	//driver.switchTo().alert().dismiss();
	//driver.switchTo().alert().getText();
	//driver.switchTo().alert().sendKeys("Text");//  send some data to alert bToox.
	//driver.switchTo().alert().accept();
	Thread.sleep(5000);
	//with using ref get the text of alert
	System.out.println(alert.getText());
	String Text=alert.getText();
	if(Text.equals("Please enter a valid user name")) {
		System.out.println("Correct message");
		} 
	else {
		
		System.out.println("Wrong msg");
	}
	alert.accept();//click on on button.
	//alert.dismiss();//to click on cancel button.
	driver.findElement(By.xpath("//input[@id='log in1']")).sendKeys("Pooja.rani@rediff.com");
	driver.findElement(By.name("proceed")).click();
	//Alert alert1=driver.switchTo().alert();//will switch from background screen to pop up screen.
	//alert() method will give you one alert class object so will store in some Alert refrence.so will create alert class and alert class ref.

	
	//alert1.accept();

	
	
	}

}
