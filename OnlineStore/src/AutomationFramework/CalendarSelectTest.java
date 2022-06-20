package AutomationFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://www.crmpro.com/index.html");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Poojaranip14@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Premamadhav1@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='item']//i[@class='calendar icon']")).click();
	//if frame is present then use:
		//driver.switchTo().frame("mainpanel");
		String date="18-September-2017";
		
	String dateArr[]= date.split("-");
	String day=dateArr[0];
	String Month=dateArr[1];
	String Year=dateArr[2];
	
	//If dropdown was present for day,month and year then:
	
	Select select=new Select(driver.findElement(By.name("Month")));
	select.selectByVisibleText(Month);
	
	Select select1=new Select(driver.findElement(By.name("Year")));
	select1.selectByVisibleText(Year);
	
	//copying xpaths for all columns.
	//it it contains table like structure for calendar.
	String Before_xpath="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String After_xpath="]/td[";
		final int totalWeekdays=7;
		boolean flag=false;
		String Day_val=null;
	for(int RowNo=2;RowNo<6; RowNo++) {
		for(int colNum=1;colNum<=totalWeekdays;colNum++) {
			try {
			 Day_val=driver.findElement(By.xpath(Before_xpath+RowNo+After_xpath+colNum+"]")).getText();
			 }catch(NoSuchElementException e) {
				 
				 System.out.println("Please enter a valid date");//if date selected is 31 sept
			 flag=false;
			 break;
			 }
			System.out.println(Day_val);//will print all the day of calendar.
			
			if(Day_val.equals(day)) {
				
				driver.findElement(By.xpath(Before_xpath+RowNo+After_xpath+colNum+"]")).click();
		flag=true;
				break;
			
			}
			
		}
		
		// To break outer loop maintain flag.
		if(flag)
		{
			
			break;//if fl ag is true break the outer loop.
		}
	}
	//if suppose we have enter 31st sep and there is no 31 st date and no row 7 so it will throw no such element exception so we can handle it thorugh try catch block.
	}

}

/*//1- Click on calendar
2- Get all td of tables using findElements method
3- using for loop get text of all elements
4- using if else condition we will check specific date
5- If date is matched then click and break the loop. 
6- Handle NoSuchElementException in case of (31st day)*/
