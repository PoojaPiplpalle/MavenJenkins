package com.crm.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
@FindBy(xpath="//td[contains(text(),'User: Pinky krishna')]")
@CacheLookup//it will store the WebElement(usernameLabel) in cache so that speed of framework will be improved
WebElement usernameLabel;
//cache memory will be created so webelment will be stored in cache if ur writing annonation so all element will be stored in cache if u declarg every element with cache memory.
//sp whenever u r using this Webelement it will not pick from browser but from cache memory
// SO if page get refreshed then cache memory will get corrupted so we get stale element exception or DOm property of particular page got changed so cache memry corrupted 
//so dont use everytime.
//@Interview questiom
//But @CacheLookup improve the perfromance of script
//@CacheLookup, as the name suggests helps us control when to cache a WebElement and when not to. This annotation, when applied over a WebElement, instructs Selenium to keep a cache of the WebElement instead of searching for the WebElement every time from the WebPage. This helps us save a lot of time.
//Even though it is tempting to use @CacheLookup annotation for every element, it is not suitable for elements that are dynamic in nature.

//@CacheLookup is very useful for the elements that do not change on the web page once loaded. These types of elements constitute a majority of elements on the web page. So for those elements, as they will not change during test execution, we should use the @Cachelookup annotation to improve the test speed.

@FindBy(xpath="//a[contains(text(),'Contacts')]")
WebElement contactlinks;

@FindBy(xpath="//a[contains(text(),'Deals')]")
WebElement DealsLinks;

@FindBy(xpath="//a[contains(text(),'Tasks')]")
WebElement TaskLinks;

@FindBy(xpath="//a[text()='New Contact']")
WebElement newContactLink;


public HomePage() {
	
	PageFactory.initElements(driver, this);
}
public String verifyHomePageTitle() {
	
	return driver.getTitle();
	
}

public ContactPage clickOnContactsLink() {
	
	contactlinks.click();
	return new ContactPage();
	
}
public DealsPage clickOnDealsLink() {
	DealsLinks.click();
	return new DealsPage();
	
}


public TaskPage clickOnTaskLink() {
	TaskLinks.click();
	return new TaskPage();
	
}
public boolean verifyCorrectUserName() {
	
	return usernameLabel.isDisplayed();
	
}
public void clickOnNewContactLink() throws InterruptedException {
	
	Actions action=new Actions(driver);
	action.moveToElement(contactlinks).build().perform();
	newContactLink.click();
}
}
