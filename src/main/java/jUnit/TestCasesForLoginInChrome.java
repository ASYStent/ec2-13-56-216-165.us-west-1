package main.java.jUnit;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasesForLoginInChrome {
	public static ChromeDriver driver;
 	WebElement element,element2;
 	String element3;

	@BeforeClass
	public static void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/MyDoc/automation/java-webdriver-cucumber/drivers/chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        Thread.sleep(3);
	}
	
	@Test
	public void Verify_user_can_Login_in_with_valid_Email_and_Password_combination_T157171() {
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@id='login']")).click();
		try{
			element = driver.findElement(By.xpath("//h3[text()='Talents']"));
			}
	    catch (Exception e){}
	    Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_cannot_login_with_blank_Email_field_T156926(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@id='login']")).click();
	    try{
	    	element = driver.findElement(By.xpath("//*[text()='This value is required.']"));
	    	}
	    catch (Exception e){}
	    Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_user_cannot_login_with_blank_Password_field_T157172(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//button[@id='login']")).click();
	    try{
	    	element = driver.findElement(By.xpath("//*[text()='This value is required.']"));
	    	}
	    catch (Exception e){}
	    Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_Forgot_your_password_will_redirect_user_to_How_to_reset_password_page_T156927(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.linkText("Forgot your password?")).click();
		try{
			element = driver.findElement(By.xpath("//strong[text()='PASSWORD RESET']"));
			}
		catch (Exception e){}
		Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_that_user_receives_email_to_reset_password_after_entering_valid_email_address_in_Password_Reset_screen_T157173() throws InterruptedException{
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Reset']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		try{
			element = driver.findElement(By.xpath("//b[text()='[ProMyTheUs] Password reset request']"));
			}
		catch (Exception e){}
		Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_that_the_Forgot_Password_field_does_not_accept_invalid_email_T157175(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@mail.com");
		driver.findElement(By.xpath("//button[text()='Reset']")).click();
		try{
			element = driver.findElement(By.xpath("//h2[text()='Error!']"));
			}
		catch (Exception e){}
		Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_that_user_can_copy_and_paste_email_field_info_T157003() {
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
		try {
			element3 = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"); 
			assertEquals("dovgichnik@gmail.com", element3);
			}
		catch (Exception e){}
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_user_cannot_copypaste_values_from_Password_and_Retype_password_fields_T157153() {
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		try {
			element3 = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("value"); 
			assertEquals("1234567890", element3);
			}
		catch (Exception e){}
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));
	}
	
	@Test
	public void Verify_Password_field_masks_users_input_with_bullets_T157176() {
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		try{
			element = driver.findElement(By.xpath("//input[@type='password']"));
			}
	    catch (Exception e){}
	    Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_cannot_login_with_an_invalid_password_T156930() {
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='login']")).click();
	    try{
	    	element = driver.findElement(By.xpath("//div[@ng-if='SignInCtrl.errorMessage']"));
	    	}
	    catch (Exception e){}
	    Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_user_cannot_login_with_an_invalid_email_address_T156929() {
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dovgichnik@mail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@id='login']")).click();
	    try{
	    	element = driver.findElement(By.xpath("//div[@ng-if='SignInCtrl.errorMessage']"));
	    	}
	    catch (Exception e){}
	    Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void Verify_Register_Now_in_login_page_will_redirect_user_to_the_registration_page_T156948(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		driver.findElement(By.linkText("Register Now")).click();
		try{
			element = driver.findElement(By.xpath("//strong[text()='SIGNUP TO GET INSTANT ACCESS']"));
			}
		catch (Exception e){}
		Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void Verify_email_text_box_is_identified_with_both_Enter_email_content_and_letter_icon_T156932(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		try{element2 = driver.findElement(By.xpath("//input[@placeholder='Enter email']"));}
		catch (Exception e){}
		Assert.assertNotNull(element2);
		try{
			element = driver.findElement(By.xpath("//span[@class='fa fa-envelope form-control-feedback text-muted']"));
			}
		catch (Exception e){}
		Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
		
	@Test
	public void Verify_password_box_is_identified_with_both_Password_content_and_lock_icon_T156934(){
		driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
		try{element2 = driver.findElement(By.xpath("//input[@placeholder='Password']"));}
		catch (Exception e){}
		Assert.assertNotNull(element2);
		try{
			element = driver.findElement(By.className("//span[@class='fa fa-lock form-control-feedback text-muted']"));
			}
		catch (Exception e){}
		Assert.assertNotNull(element);
	    System.out.println("Passed " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser(){
		driver.quit();	
	}

}