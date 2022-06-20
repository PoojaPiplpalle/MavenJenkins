package AutomationFramework;

import java.awt.Dimension;
import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
					System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
					//System.setProperty("webdriver.chrome.driver","driver_path");
					//System.setProperty("webdriver.chrome.silentOutput", "true");
					WebDriver driver =new ChromeDriver();
			      	//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
					//Thread.sleep(2000);
					driver.manage().window().maximize();
driver.get("https://www.w3schools.com/html/html_tables.asp");

//*[@id="customers"]/tbody/tr[2]/td[1]
//*[@id="customers"]/tbody/tr[3]/td[1]
//*[@id="customers"]/tbody/tr[4]/td[1]
//*[@id="customers"]/tbody/tr[5]/td[1]
//*[@id="customers"]/tbody/tr[6]/td[1]
 //tr  means row and td means column 
// Printing the total no rows


java.util.List<WebElement> rows= driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
//to find the no of rows and there is one changes instead of driver.findelement we haves used driver.findelements.
//driver.findelements will return all no rows in this rows.

int rowCount=rows.size();
System.out.println("Total n o of rows :"+rowCount);//print no of rows
// so will remoe harcoded value i.e 7 to rowCount.



String Before_xpath="//*[@id=\"customers\"]/tbody/tr[";
String After_xpath="]/td[1]";
//for company column 
for(int i=2;i<=rowCount;i++) {
	String Actualxpath=Before_xpath+i+After_xpath;
	WebElement element =driver.findElement(By.xpath(Actualxpath));
	System.out.println(element.getText());
	if(element.getText().equals("Island Trading")) {
		System.out.println("Company name:" + element.getText() +" is found at Postion:" +(i-1));
		break;
	}
}

System.out.println("*******");
//*[@id="customers"]/tbody/tr[2]/td[2]// --for contact column

String AfterxpathContact="]/td[2]";
for(int i=2;i<=rowCount;i++) {
	String Actualxpath=Before_xpath+i+AfterxpathContact;
	WebElement element =driver.findElement(By.xpath(Actualxpath));
	System.out.println(element.getText());
	
	}

//for country column
String AfterxpathCountry = "]/td[3]";
for(int i=2;i<=rowCount;i++) {
	String Actualxpath=Before_xpath+i+AfterxpathCountry;
	WebElement element =driver.findElement(By.xpath(Actualxpath));
	System.out.println(element.getText());
	
	}

	
	//Handle the webtable column.
	//*[@id="customers"]/tbody/tr[1]/th[1]
	//*[@id="customers"]/tbody/tr[1]/th[2]
	//*[@id="customers"]/tbody/tr[1]/th[3]
	System.out.println("*******");
	java.util.List<WebElement> Col=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[1]/th"));
	int ColCount=Col.size();
	System.out.println("Total size of column:"+ColCount);
	String ColBefore_Xpath="//*[@id=\"customers\"]/tbody/tr[1]/th[";
	String ColAfter_Xpath ="]";
	
	for(int i=1;i<=ColCount;i++) {
		
WebElement element=	driver.findElement(By.xpath(ColBefore_Xpath+i+ColAfter_Xpath));
System.out.println(element.getText());
	
	}
 
	
		
	}
	
}

