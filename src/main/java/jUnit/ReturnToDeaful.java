package main.java.jUnit;

import static org.junit.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReturnToDeaful {

	public static ChromeDriver driver;
 	static WebElement element;
	
	
	public static void PasswordChande(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("987654321");
		driver.findElement(By.xpath("//button[@id='login']")).click(); 
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("987654321");
		driver.findElement(By.id("newPassword")).sendKeys("123456789");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("123456789");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
	    driver.findElement(By.xpath("//button[@class='confirm']")).click();
		System.out.println("Password returned to previous.");
	}
}
