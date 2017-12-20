package main.java.jUnit;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Support {
	
	public static ChromeDriver driver;
	public static WebDriverWait wait;
 	static WebElement element;
 	String element1;
	
	public static void Accept(){
		TestCasesForMyProfileChrome.driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		TestCasesForMyProfileChrome.driver.findElement(By.id("updateProfile")).click();
		TestCasesForMyProfileChrome.wait = new WebDriverWait(driver, 20);
		TestCasesForMyProfileChrome.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		TestCasesForMyProfileChrome.driver.findElement(By.xpath("//button[@class='confirm']")).click();
	}
	
	public static void Verify(){
		try {
			TestCasesForMyProfileChrome.element = driver.findElement(By.xpath("//span[text()='This field is required.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T157128 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

}
