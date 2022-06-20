package AutomationFramework;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotConcept {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		 
		//Take screenshot and store as a file format
		//Q1:Can we take screenshot in selenium :ans is yes by using getScreenshotAs method.
		//Q2:
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\lenovo\\Documents\\ToolsQA\\OnlineStore\\src\\AutomationFramework\\google.png"));
	//Converting driver into takescreenshot will give you this file object and we are copying this file object(src) to which loc to generare screenshot.
	
	}

}


//step 1) Convert web driver object to TakeScreenshot

//TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Step 2) Call getScreenshotAs method to create image file

//File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Step 3) Copy file to Desired Location

///Example: In this example we will take screen capture of http://demo.guru99.com/V4/ & save it as C:/Test.png
