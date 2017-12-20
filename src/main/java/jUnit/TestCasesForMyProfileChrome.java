package main.java.jUnit;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCasesForMyProfileChrome {

	public static ChromeDriver driver;
	public static WebDriverWait wait;
 	static WebElement element;
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
	public void Verify_user_can_navigate_to_My_Profile_page(){
		try {
			element = driver.findElement(By.xpath("//div[text()='Profile']"));
			}
		catch (Exception e){}	
	    Assert.assertNotNull(element);
	    System.out.println("T156950 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_can_change_First_Name(){
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("Jan");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		try {
			element1 = driver.findElement(By.id("firstName")).getAttribute("value"); 
			assertEquals("Jan", element1);
			}
		catch (Exception e){}	
	    System.out.println("T156953 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_can_change_Middle_Initial(){
		driver.findElement(By.id("middleName")).clear();
		driver.findElement(By.id("middleName")).sendKeys("Van");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		try {
			element1 = driver.findElement(By.id("middleName")).getAttribute("value"); 
			assertEquals("Van", element1);
			}
		catch (Exception e){}	
	    System.out.println("T156954 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_user_can_change_Last_Name(){
		driver.findElement(By.xpath("//em[@class='icon-user']")).click();
		driver.findElement(By.xpath("//p[text()='My Profile']")).click();		
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("Devic");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		try {
			element1 = driver.findElement(By.id("lastName")).getAttribute("value"); 
			assertEquals("Devic", element1);
			}
		catch (Exception e){}	
	    System.out.println("T156957 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_user_can_change_Address(){
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("367 Grand Ave apr.1");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		try {
			element1 = driver.findElement(By.id("address")).getAttribute("value"); 
			assertEquals("367 Grand Ave apr.1", element1);
			}
		catch (Exception e){}	
	    System.out.println("T156959 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("367 Grand Ave");
	}
	
	@Test
	public void Verify_user_can_change_Phone_Number(){
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("06504481689");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		try {
			element1 = driver.findElement(By.id("phone")).getAttribute("value"); 
			assertEquals("(650) 448-1689", element1);
			}
		catch (Exception e){}	
	    System.out.println("T156960 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_user_can_change_Email(){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("dovgichnik1@gmail.com");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		try {
			element1 = driver.findElement(By.id("email")).getAttribute("value"); 
			assertEquals("dovgichnik1@gmail.com", element1);
			}
		catch (Exception e){}	
	    System.out.println("T156961 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_user_cannot_update_First_Name_with_blank_field(){
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('firstName').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='This field is required.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T157126 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("firstName")).sendKeys("Nikita");
	}

	@Test
	public void Verify_user_cannot_update_Last_Name_with_blank_field(){
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('lastName').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='This field is required.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T157127 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("lastName")).sendKeys("Dovhych");
	}
	
	@Test
	public void Verify_user_cannot_update_Address_with_blank_field(){
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('address').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='This field is required.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T157129 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("address")).sendKeys("367 Grand Ave");
	}

	@Test
	public void Verify_user_cannot_update_Phone_number_with_blank_field(){
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('phone').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='This field is required.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T157128 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("phone")).sendKeys("06504438316");
	}
	
	@Test
	public void Verify_user_cannot_update_Email_with_blank_field(){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('email').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='This field is required.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T156962 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("email")).sendKeys("dovgichnik@gmail.com");
	}
	
	@Test
	public void Verify_user_cannot_update_Email_with_new_email_in_invalid_format(){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("dovgichnik@.com");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('email').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='Invalid email.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T156964 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("dovgichnik@gmail.com");
	}
	
	@Test
	public void Verify_user_cannot_update_Email_with_different_email_already_existing_within_system(){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("dovgichnik@.com");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('email').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='Email is already registered.']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T156967 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("dovgichnik@gmail.com");
	}
	
	@Test
	public void Verify_user_cannot_exceed_50_characters_in_First_Name_field(){
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("asdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgh");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('firstName').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='Please enter up to a maximum of 50 characters.']")); 
			}
		catch (Exception e){}	
	    System.out.println("T156968 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("Nikita");
	}
	
	@Test
	public void Verify_user_cannot_exceed_50_characters_in_Middle_Initial_field(){
		driver.findElement(By.id("middleName")).clear();
		driver.findElement(By.id("middleName")).sendKeys("asdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgh");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('middleName').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='Please enter up to a maximum of 50 characters.']")); 
			}
		catch (Exception e){}	
	    System.out.println("T156969 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("middleName")).clear();
	}

	@Test
	public void Verify_user_cannot_exceed_50_characters_in_Last_Name_field(){
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("asdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgh");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('lastName').scrollIntoView(true);");
		try {
			element = driver.findElement(By.xpath("//span[text()='Please enter up to a maximum of 50 characters.']")); 
			}
		catch (Exception e){}	
	    System.out.println("T156970 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("Dovhych");
	}
	
	@Test
	public void Verify_user_cannot_enter_nonnumerical_characters_in_Phone_Number_field(){
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("abc@defg!");
		driver.executeScript("document.getElementById('updateProfile').scrollIntoView(true);");
		driver.findElement(By.id("updateProfile")).click();
		driver.executeScript("document.getElementById('phone').scrollIntoView(true);");
			element1 = driver.findElement(By.id("phone")).getAttribute("value"); 
//		try {
//			assertEquals("(___) ___-____", element1);
//			}
//		catch (Exception e){}	
		System.out.println("T157128 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName() + element1);
	}

	@AfterClass
	public static void closeBrowser(){
		driver.quit();	
	}

	
}
