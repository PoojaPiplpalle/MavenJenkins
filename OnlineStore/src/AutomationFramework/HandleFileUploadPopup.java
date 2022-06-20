package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		String str1=driver.getTitle();
		System.out.println(str1);
		driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("C:\\Users\\lenovo\\Documents\\ToolsQA\\xpaths.txt");//Don not use click and enter filepath in Sendkey method.
		//type should be file when u inspect the browse button/upload button.
		
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		String str2=driver.findElement(By.xpath("//*[@id='mp-tfa']/p")).getText();
		System.out.println(str2);
	
		//String str=driver.findElement(By.xpath("//*[@id=\"toc_container\"]/p")).getText();
		//System.out.println(str);
		
	}

}
