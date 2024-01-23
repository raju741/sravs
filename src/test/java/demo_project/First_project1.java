package demo_project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class First_project1 {
	
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	@Parameters({"user","pass"})
	public void browser(String name,String password) {

		driver.get("https://www.demo.guru99.com/V4/");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		driver.findElement(By.xpath("//input[@name=\"uid\"]")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value=\"LOGIN\"]")).click();
	}
	
	
	@Test(priority = 6)
	
	public void newcustomer() throws IOException  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//a[text()=\"New Customer\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("balraj");
		driver.findElement(By.xpath("//input[@type=\"radio\"])[1]")).click();
		driver.findElement(By.cssSelector("input[onblur=\"validatedob();\"]")).sendKeys("12/01/2024");
		driver.findElement(By.cssSelector("textarea[name=\"addr\"]")).sendKeys("mbnr");
		driver.findElement(By.cssSelector("input[onkeyup=\"validateCity();\"]")).sendKeys("mbnr");
		driver.findElement(By.xpath("//input[@name=\"state\"]")).sendKeys("telagana");
		driver.findElement(By.cssSelector("input[onkeyup=\"validatePIN();\"]")).sendKeys("509001");
		driver.findElement(By.cssSelector("input[onkeyup=\"validateTelephone();\"]")).sendKeys("7416484118");
		driver.findElement(By.cssSelector("input[onkeyup=\"validateEmail();\"]")).sendKeys("balubalraj1@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("BALU123");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
		    
	      	File trg=new File("C:\\Users\\BALU\\OneDrive\\Desktop\\New screen\\new custamer.png");
	      	FileUtils.copyFile(src,trg);
		//driver.switchTo().alert().accept();
		
		  
	      	
		driver.navigate().refresh();
		
	}
	
	@Test(priority = 0)
	public void newcustamer1() throws IOException {
		
		driver.findElement(By.xpath("//a[text()=\"New Customer\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"name\"]")).click();
		driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click();
		driver.findElement(By.cssSelector("input[onblur=\"validatedob();\"]")).click();
		driver.findElement(By.cssSelector("textarea[name=\"addr\"]")).click();
		driver.findElement(By.cssSelector("input[onkeyup=\"validateCity();\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"state\"]")).click();
		driver.findElement(By.cssSelector("input[onkeyup=\"validatePIN();\"]")).click();
		driver.findElement(By.cssSelector("input[onkeyup=\"validateTelephone();\"]")).click();
		driver.findElement(By.cssSelector("input[onkeyup=\"validateEmail();\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"password\"]")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		
	
		driver.switchTo().alert().accept();
		
	}
	
		 
		
	
	@Test(priority = 7)
	public void edit_customer() {
		
		driver.findElement(By.xpath("//a[text()=\"Edit Customer\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys("Bs122");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
	}
	@Test(priority = 1)
	public void editcustamer1() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()=\"Edit Customer\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"cusid\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
        driver.navigate().refresh();
		
		
	}
	

	@Test(priority = 8)
	public void delete_customer() {
		driver.findElement(By.xpath("//a[text()=\"Delete Customer\"]")).click();
		driver.findElement(By.xpath("//input[@onkeyup=\"validatecustomerid();\"]")).sendKeys("Bs122");
		driver.findElement(By.cssSelector("input[name=\"AccSubmit\"]")).click();
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
	}
	@Test(priority = 2)
	public void delete_custamer() {
		
		driver.findElement(By.xpath("//a[text()=\"Delete Customer\"]")).click();
		driver.findElement(By.xpath("//input[@onkeyup=\"validatecustomerid();\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"AccSubmit\"]")).click();
		driver.navigate().refresh();
	}
		
		
		
		
	
	
	@Test(priority = 9)
	public void new_account() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()=\"New Account\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"cusid\"]")).sendKeys("balu12345");
		
		WebElement bb=driver.findElement(By.xpath("//select[@name=\"selaccount\"]"));
		Select se=new Select(bb);
		se.selectByIndex(0);
		
	    driver.findElement(By.xpath("//input[@name=\"inideposit\"]")).sendKeys("2000");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()=\"Edit Account\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).sendKeys("65423626");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.xpath("//a[text()=\"Delete Account\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).sendKeys("65423626");
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
	}
	@Test(priority = 3)
	public void newaccount() {
		driver.findElement(By.xpath("//a[text()=\"New Account\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"cusid\"]")).click();
		
		WebElement bb=driver.findElement(By.xpath("//select[@name=\"selaccount\"]"));
		Select se=new Select(bb);
		se.selectByIndex(0);
		
	    driver.findElement(By.xpath("//input[@name=\"inideposit\"]")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()=\"Edit Account\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		
		
		
		driver.findElement(By.xpath("//a[text()=\"Delete Account\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
	
	}
	
	
	
		
		
		@Test(priority = 11)
	public void deposit()  {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()=\"Deposit\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).sendKeys("65423628823");
		driver.findElement(By.cssSelector("input[name=\"ammount\"]")).sendKeys("5000");
		driver.findElement(By.xpath("//input[@name=\"desc\"]")).sendKeys("saving");
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[text()=\"Withdrawal\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).sendKeys("8765432");
		driver.findElement(By.cssSelector("input[name=\"ammount\"]")).sendKeys("3000");
		driver.findElement(By.xpath("//input[@name=\"desc\"]")).sendKeys("saving");
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Fund Transfer\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"payersaccount\"]")).sendKeys("8765432");
		driver.findElement(By.cssSelector("input[name=\"payeeaccount\"]")).sendKeys("23456789");
		driver.findElement(By.cssSelector("input[name=\"ammount\"]")).sendKeys("23000");
		driver.findElement(By.cssSelector("input[name=\"desc\"]")).sendKeys("current");
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		
	}
		@Test(priority = 4)
		public void deposit1() {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//a[text()=\"Deposit\"]")).click();
			driver.findElement(By.cssSelector("input[name=\"accountno\"]")).click();
			driver.findElement(By.cssSelector("input[name=\"ammount\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"desc\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
			driver.switchTo().alert().dismiss();
			
			driver.navigate().refresh();
			driver.findElement(By.xpath("//a[text()=\"Withdrawal\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"accountno\"]")).click();
			driver.findElement(By.cssSelector("input[name=\"ammount\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"desc\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
			driver.switchTo().alert().dismiss();
			
			driver.navigate().refresh();	
			
			
			driver.findElement(By.xpath("//a[text()=\"Fund Transfer\"]")).click();
			driver.findElement(By.cssSelector("input[name=\"payersaccount\"]")).click();
			driver.findElement(By.cssSelector("input[name=\"payeeaccount\"]")).click();
			driver.findElement(By.cssSelector("input[name=\"ammount\"]")).click();
			driver.findElement(By.cssSelector("input[name=\"desc\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
			
		}
		
		
		
		
	@Test(priority = 12)
	public void changepassword() {
		
		driver.findElement(By.xpath("//a[text()=\"Change Password\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"oldpassword\"]")).sendKeys("Balu123");
		driver.findElement(By.xpath("//input[@name=\"newpassword\"]")).sendKeys("sravs123");
		driver.findElement(By.xpath("//input[@name=\"confirmpassword\"]")).sendKeys("sravs123");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[text()=\"Balance Enquiry\"]")).click();
		driver.findElement(By.cssSelector("input[onkeyup=\"validateaccountno();\"]")).sendKeys("8765432");
		driver.findElement(By.cssSelector("input[name=\"AccSubmit\"]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
	}
	@Test(priority = 5)
	public void changepassword1() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()=\"Change Password\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"oldpassword\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"newpassword\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"confirmpassword\"]")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		driver.switchTo().alert().dismiss();
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[text()=\"Balance Enquiry\"]")).click();
		driver.findElement(By.cssSelector("input[onkeyup=\"validateaccountno();\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
	}
		
	
	
	
	
	@Test(priority = 13)
	public void ministatement() {
		driver.findElement(By.xpath("//a[text()=\"Mini Statement\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).sendKeys("8765432");
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Customised Statement\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountno\"]")).sendKeys("8765432");
		driver.findElement(By.xpath("//input[@onkeyup=\"fromdate();\"]")).sendKeys("12/01/2024");
		driver.findElement(By.xpath("//input[@onkeyup=\"todate();\"]")).sendKeys("13/01/2024");
		driver.findElement(By.cssSelector("input[name=\"amountlowerlimit\"]")).sendKeys("3000");
		driver.findElement(By.cssSelector("input[name=\"numtransaction\"]")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
	}
	
	@Test(priority = 6)
	public void ministatement1() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()=\"Mini Statement\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"accountno\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		
	
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[text()=\"Customised Statement\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountno\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"fdate\"]")).click();
		driver.findElement(By.xpath("//input[@onkeyup=\"todate();\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"amountlowerlimit\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"numtransaction\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"AccSubmit\"]")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
	}
	
	
	
	
	@Test(priority = 6)
	public void logout() {
		
		driver.findElement(By.xpath("//a[text()=\"Log out\"]")).click();
		
		
	}
	
	
	
	
	
	
}
