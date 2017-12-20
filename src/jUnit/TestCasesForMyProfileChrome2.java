package jUnit;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasesForMyProfileChrome2 {

	static ChromeDriver driver;
 	WebElement element;
 	String element1;

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\MyDoc\\automation\\java-webdriver-cucumber\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@id='login']")).click();
	}
	
	@Test
	public void Verify_registered_data_is_accurately_displayed_on_My_Profile_page(){
		driver.findElement(By.xpath("//em[@class='icon-user']")).click();
		driver.findElement(By.xpath("//p[text()='My Profile']")).click();
		try {
			element1 = driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"); 
			assertEquals("Nikita", element1);
			element1 = driver.findElement(By.xpath("//input[@name='//input[@name='lastName']")).getAttribute("value"); 
			assertEquals("Dovhych", element1);
			element1 = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"); 
			assertEquals("dovgichnik@gmail.com", element1);
			element1 = driver.findElement(By.xpath("//input[@name='phone']")).getAttribute("value"); 
			assertEquals("(650) 443-8316", element1);
			element1 = driver.findElement(By.xpath("//input[@placeholder='Enter country name...']")).getText(); 
			assertEquals("", element1);
			element1 = driver.findElement(By.xpath("//input[@name='address']")).getAttribute("value"); 
			assertEquals("367 Grand Ave", element1);
			element1 = driver.findElement(By.xpath("//input[@name='city']")).getAttribute("value"); 
			assertEquals("South San Francisco", element1);
			element1 = driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"); 
			assertEquals("California", element1);
			element1 = driver.findElement(By.xpath("//input[@name='zip']")).getAttribute("value"); 
			assertEquals("94080", element1);
			}
		catch (Exception e){}
	    Assert.assertNotNull(element);
	    System.out.println("T156951 isPassed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@AfterClass
	public static void closeBrowser(){
		driver.quit();	
	}

	
}
