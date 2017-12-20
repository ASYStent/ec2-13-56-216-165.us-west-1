package testForQAUBER;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam {

	public static WebDriver driver;
	WebElement element;
	WebElement element2 = null;
	public static WebDriverWait wait;

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:/MyDoc/automation/java-webdriver-cucumber/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		SignIn_Action.goToPage();
		SignIn_Action.loginToSite();
	}

	@Test
	public void Test() {
		driver.findElement(By.xpath("//a[text()='New']")).click();
//		wait = new WebDriverWait(driver, 2);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@placeholder, 'Enter category name...')]")));
		element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@placeholder, 'Enter category name...')]")));
		while(element2.isDisplayed() == true) {
	    element2.click();
	    element2 = driver.findElement(By.xpath("//div[contains(@placeholder, 'Enter category name...')]"));
	        }
		driver.findElement(By.xpath("//*[@id='ui-select-choices-row-0-0']/span")).click();
		driver.findElement(By.xpath("//span[text()='Quick Tests']")).click();
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		try {
			element = driver.findElement(By.xpath("//*[text()='USA']"));
		} catch (Exception e) {
		}
		Assert.assertNotNull(element);
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " is Passed");
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}
