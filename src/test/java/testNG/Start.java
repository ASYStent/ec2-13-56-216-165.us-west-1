package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Start {
	
	public static WebDriver driver = null;
	
	@Parameters("setBrowser")
 	@BeforeTest
 	public void beforeSuite(String setBrowser) throws IOException{
 		if(setBrowser.equalsIgnoreCase("Chrome")) {
 			System.setProperty("webdriver.chrome.driver", "D:/MyDoc/automation/java-webdriver-testng-maven/drivers/chromedriver.exe");
 			driver = new ChromeDriver();
 		}
 		else if(setBrowser.equalsIgnoreCase("Firefox")) {
 			System.setProperty("webdriver.chrome.driver", "D:/MyDoc/automation/java-webdriver-testng-maven/drivers/geckodriver.exe");
 			driver = new FirefoxDriver();
 		}
  		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 		System.out.println("Browser Opened.");
	}

 	@AfterTest
 	public void closeBrowser() {
  		driver.manage().deleteAllCookies();
		driver.quit();
	    System.out.println("Finish Test Suite.");
 	}
}
