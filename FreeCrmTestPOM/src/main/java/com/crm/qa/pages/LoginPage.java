package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
//Defining object repository or Page factory.
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//create constructor
	//How to initiliaze page factory.:
	//1.Create the constructor of class
	//Inside the construtor we have  one class PageFactory class and initelement method is presnt 
	//so call method.
	
	//Initialising page objects:
public 	LoginPage() {
	PageFactory.initElements(driver, this);//this means current class object so all these page factory object will initialise with this driver 
	
}

//Actions:
public  String validateLoginpPageTitle() {
	
	return driver.getTitle();
	
}

public boolean   validateCRMImage() {
	
	return crmLogo.isDisplayed();
}
public HomePage login(String un,String pwd) {
	
	username.sendKeys(un);
	password.sendKeys(pwd);
	LoginBtn.click();//After clicking on login button it is returning to home page that means landing page is home pagee so this method should return home page class object 
	return new HomePage();
}


}
