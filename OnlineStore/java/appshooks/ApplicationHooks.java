package appshooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

//import cucumber.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
private DriverFactory driverfactory;
private WebDriver driver;
private ConfigReader configReader;
Properties prop;

@Before(order= 0)//First this will be executing
public void getProperty() {
	configReader=new ConfigReader();
	prop=configReader.init_prop();
	}

@Before(order =1)
public void launchBrowser() {
	String browsername=prop.getProperty("browser");
	driverfactory =new DriverFactory();
	driverfactory.init_driver(browsername);
}

//Cucumber executes Hooks in a certain order but there is a way to change the order of the execution according to the need for the test. @After(order = int): This runs in decrements order, which means the opposite of @Before. Value 1 would run first and 0 would be after 1
@After(order = 0)//It will execute after order=1
public void quitBrowser() {
	DriverFactory.getDriver().quit();
	
}

@After(order = 1)
public void tearDown(Scenario scenario) {
	if(scenario.isFailed()) {
		//take screenshot
		String screenshotname=scenario.getName().replaceAll(" ","_");
		byte[] sourcepath=((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
		//Convert driver into screenshot so this method will create screenshot and it will be stored under the sourcepath
		scenario.attach(sourcepath, "image/png", screenshotname);
		//then attach the screenshot.
		
		//If scneario is failed then u can see the screenshot in the report and u can view it from the console link │ View your Cucumber Report at:  //https://reports.cucumber.io/reports/b9cf7d8d-a4de-4f1f-8b89-f45e3bc001dc.
		//Check the screenshot whic i have captured
	}                                 
		
	}


}
