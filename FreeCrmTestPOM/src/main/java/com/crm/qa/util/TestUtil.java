package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;



import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

public static long PAGE_LOAD_TIMEOUT=100;
public static long IMPLICIT_WAIT=100;

public void switchToFrame() {
	
	int size=driver.findElements(By.tagName("frame")).size();
	System.out.println(size);
	for(int i=0;i<=size;i++) {
		
		driver.switchTo().frame(i);
		
	}
	driver.switchTo().frame("mainpanel");
}

public void switchToFrame1() {
	
	driver.switchTo().frame("leftpanel");
}
public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");

	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}
}
