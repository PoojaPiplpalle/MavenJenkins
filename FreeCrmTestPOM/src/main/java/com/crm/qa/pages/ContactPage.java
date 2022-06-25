package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	//Page Object Model is an Object Repository design pattern in Selenium WebDriver.
	//POM creates our testing code maintainable, reusable.
	//Page Factory is an optimized way to create object repository in POM concept.
//	Page Factory in Selenium is an inbuilt Page Object Model concept for Selenium WebDriver but it is very optimized. It is used for initialization of Page objects or to instantiate the Page object itself. It is also used to initialize Page class elements without using "FindElement/s."
	//we use annotations @FindBy to find WebElement. We use initElements method to initialize web elements
@FindBy(xpath="//td[contains(text(),'contacts']")
WebElement contactlabel;

@FindBy(xpath="//select[@name='title']")
WebElement selectTitle;



@FindBy(id="first_name")
WebElement firstName;

@FindBy(id="surname")
WebElement lastName;


@FindBy(xpath="//input[@name='client_lookup']")
WebElement company;


@FindBy(xpath="//input[@type='submit' and @value='Save']")
WebElement saveBtn;
//to select the checkbox of various contact we need to pass "name of contact" in xpath everytime.so this below xpath we are not using now.
/*
@FindBy(xpath="//a[text()='Krishna piple']//parent::td[@class='datalistrow']//preceding-sibling::td//input[@name='contact_id']")
WebElement CheckBoxselection;*/
//initiliase pagefactory.
 
public ContactPage() {
	
	PageFactory.initElements(driver, this);
}

public boolean verifyContactLabel() {
	return contactlabel.isDisplayed();
	
}
public void selectContactsByName(String name) {
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td//input[@name='contact_id']")).click();
	
}
public void createNewContact(String Title,String Ftname,String Ltname,String Comp) {
	Select select=new Select(selectTitle);
	select.selectByVisibleText(Title);
	//firstName.clear();
	firstName.sendKeys(Ftname);
	//lastName.clear();
	lastName.sendKeys(Ltname);
	//company.clear();
	company.sendKeys(Comp);
	saveBtn.click();
	

}

}
