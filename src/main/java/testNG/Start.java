package main.java.testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Start {
	
	public static WebDriver driver = null;
	
 	@BeforeTest
 	public void beforeSuite() throws IOException{
 		System.setProperty("webdriver.chrome.driver", "D:\\MyDoc\\automation\\java-webdriver-cucumber\\drivers\\chromedriver.exe");
 		driver = new ChromeDriver();
 		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
 		System.out.println("Browser Opened.");
 	}

 	@AfterTest
 	public void closeBrowser() {
  		driver.manage().deleteAllCookies();
		driver.quit();
	    System.out.println("Finish Test Suite.");
 	}
}
