package AutomationFramework;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calederguru9 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System.out.println(Calendar.getInstance().get(Calendar.YEAR));
	System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
		Thread.sleep(10000);
		String dateTime ="12/10/2021  2:00pm";
		WebElement data=driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']"));
		data.click();
		Thread.sleep(10000);
		WebElement nextLink=driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
		WebElement midLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));
		 WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]")); 

		// //Split the date time to get only the date part
		String date_dd_MM_yyyy[]=(dateTime .split(" ")[0]).split("/");
		// //get the year difference between current year and year to set in calander
		 int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
		  midLink.click();
		  if(yearDiff!=0){

	            //if you have to move next year

	            if(yearDiff>0){

	                for(int i=0;i< yearDiff;i++){

	                    System.out.println("Year Diff->"+i);

	                    nextLink.click();

	                }

	            }

	            //if you have to move previous year

	            else if(yearDiff<0){

	                for(int i=0;i< (yearDiff*(-1));i++){

	                    System.out.println("Year Diff->"+i);

	                    previousLink.click();

	                }

	            }

	        }
	        
	        Thread.sleep(1000);

	        //Get all months from calendar to select correct one

	        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
	        
	        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
	        
	        Thread.sleep(1000);

	        //get all dates from calendar to select correct one

	        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
	        
	        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
	        
	        ///FOR TIME

	        WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

	        //click time picker button

	        selectTime.click();

	        //get list of times

	        List<WebElement> allTime = driver.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
	      
	        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];

	     //select correct time

	        for (WebElement webElement : allTime) {

	            if(webElement.getText().equalsIgnoreCase(dateTime))

	            {

	                webElement.click();

	            }

	        }

	    }

}

