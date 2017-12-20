package jUnit;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCasesForPasswordChange {
	
	public static ChromeDriver driver;
	public static WebDriverWait wait;
 	static WebElement element;
 	static String element1;

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\MyDoc\\automation\\java-webdriver-cucumber\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@id='login']")).click();
	}
	
	@Test
	public void Verify_user_can_navigate_to_Password_Change_page(){
		driver.findElement(By.xpath("//em[@class='icon-user']")).click();
		driver.findElement(By.xpath("//p[text()='My Profile']")).click();		
		driver.findElement(By.xpath("//a[text()='Password change']")).click();
		try {
			element = driver.findElement(By.xpath("//*[text()='Password change']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T158148 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_can_change_password_after_entering_valid_Current_Password_New_Password_and_Confirm_New_Password(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("1234567890");
		driver.findElement(By.id("newPassword")).sendKeys("0987654321");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("0987654321");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']")); 
			}
		catch (Exception e){}	
	    assertNotNull(element);
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		System.out.println("T158151 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
//		ReturnToDeaful.PasswordChande();
	}

	@Test
	public void Verify_Current_Password_field_cannot_be_blank(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("");
		driver.findElement(By.id("newPassword")).sendKeys("0987654321");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("0987654321");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']")); 
			}
		catch (Exception e){}	
	    assertNull(element);
		System.out.println("T158152 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_New_Password_field_cannot_be_blank(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("1234567890");
		driver.findElement(By.id("newPassword")).sendKeys("");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("0987654321");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']")); 
			}
		catch (Exception e){}	
	    assertNull(element);
		System.out.println("T158154 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_Confirm_new_password_field_cannot_be_blank(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("1234567890");
		driver.findElement(By.id("newPassword")).sendKeys("0987654321");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']")); 
			}
		catch (Exception e){}	
	    assertNull(element);
		System.out.println("T158159 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_cannot_change_password_with_invalid_Current_Password(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("123456789");
		driver.findElement(By.id("newPassword")).sendKeys("0987654321");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("0987654321");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']")); 
			}
		catch (Exception e){}	
	    assertNull(element);
		System.out.println("T158161 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_Current_password_New_passwor_and_Confirm_password_fields_all_mask_inputs_in_bullets(){
		try {
			element = driver.findElement(By.xpath("//input[@type='password' and @id='currentPassword']"));//label[@for='currentPassword']//input[@type='passsword']
		}
		catch (Exception e){}	
	    assertNotNull(element);
		try {
			element = driver.findElement(By.xpath("//input[@id='newPassword' or @type='passsword']"));
		}
		catch (Exception e){}	
	    assertNotNull(element);
		try {
			element = driver.findElement(By.xpath("//input[@id='confirmNewPassword' or @type='passsword']"));
			}
		catch (Exception e){}	
	    assertNotNull(element);
		System.out.println("T158162 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_New_Password_cannot_be_less_than_6_characters(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("123456789");
		driver.findElement(By.id("newPassword")).sendKeys("09876");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("09876");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']"));
			}
		catch (Exception e){}	
	    assertNull(element);
		System.out.println("T158169 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_that_Confirm_New_Password_cannot_mismatch_New_Password(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("123456789");
		driver.findElement(By.id("newPassword")).sendKeys("0987654321");
		driver.findElement(By.id("confirmNewPassword")).sendKeys("987654321");
		driver.findElement(By.xpath("//form[@id='formPassword']//button[text()='Update']")).click();
		try {
			element = driver.findElement(By.xpath("//button[@class='confirm']")); 
			}
		catch (Exception e){}	
	    assertNull(element);
		System.out.println("T158170 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_cannot_copy_and_cut_values_from_Current_password_New_password_and_Confirm_password_fields(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/my-profile.html?tab=2");
		driver.findElement(By.id("currentPassword")).sendKeys("1234567890");
		try {
			element1 = driver.findElement(By.xpath("//input[@id='currentPassword' and @type='passsword']")).getAttribute("value");
		}
		catch (Exception e){}	
		driver.findElement(By.id("newPassword")).sendKeys("0987654321");
		try {
			element1 = driver.findElement(By.xpath("//input[@id='newPassword' and @type='passsword']")).getAttribute("value");
		}
		catch (Exception e){}	
		driver.findElement(By.id("confirmNewPassword")).sendKeys("0987654321");
		try {
			element1 = driver.findElement(By.xpath("//input[@id='confirmNewPassword' and @type='passsword']")).getAttribute("value");
			}
		catch (Exception e){}	
	    assertNull(element1);
		System.out.println("T158170 Passed. " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@AfterClass
	public static void closeBrowser(){
		driver.quit();	
	}

}
