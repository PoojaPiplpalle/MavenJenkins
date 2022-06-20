package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyanamicWebTableHandle {
	
public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","driver_path");
			//System.setProperty("webdriver.chrome.silentOutput", "true");
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
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1@");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Login']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
			Thread.sleep(2000);

			//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/input
			//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div/inputs
			//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[1]/div/input
			
			//unable to print output ask saad mansuri.
			
		//	1st method to use dynamic table
		String before_xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
		String After_xpath="]/td[1]/div/input";
		for(int i=1;i<=3;i++) {
		String name	=driver.findElement(By.xpath(before_xpath+i+After_xpath)).getText();//text method is used to get the text of the row like prema.kiku and will str=ore in string variable.
			System.out.println(name);
			if(name.contains("prema gfgfg niti")) {
				//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/input
				driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" + i+ "]/td[1]/div/input")).click();
				
			}
			
		}
//Method: 2: will learn later and will ask to saad.
		
		
		
		
	}

}
