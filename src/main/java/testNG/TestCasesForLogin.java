package main.java.testNG;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.pageObjects.LoginPage;

public class TestCasesForLogin extends Start {
	
	
//	private static String Username = "dovgichnik@gmail.com";
//	private static String Password = "123456789";
//	private static String ERUsername = "dovgichnik1@gmail.com";
//	private static String ERPassword = "12345678";
//	private static String GPassword= "***************";
 	
	@Parameters({"Username","Password"})
 	@Test (priority = 0)
 	public void Verify_user_can_Login_in_with_valid_Email_and_Password_combination(String Username, String Password){
		String id = "T157173";

 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.inputUsername(Username);
 			LG.inputPassword(Password);
 			LG.clickLogin();
			LG.verifyLogin(id, new Object(){}.getClass().getEnclosingMethod().getName());
 			
 	}
 	
	@Parameters("Password")
 	@Test (priority = 1)
	public void Verify_user_cannot_login_with_blank_Email_field(String Password){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.inputPassword(Password);
 			LG.clickLogin();
 			LG.verifyError();
 	}
 	
	@Parameters("Username")
 	@Test (priority = 2)
 	public void Verify_user_cannot_login_with_blank_Password_field(String Username){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.inputUsername(Username);
 			LG.clickLogin();
 			LG.verifyError();
 	}
 	
 	@Test (priority = 3)
 	public void Verify_Forgot_your_password_will_redirect_user_to_How_to_reset_password_page(){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.clickPasswordReset();
 			LG.verifyPasswordReset();
 	}
 	
 	@Parameters({"Username","GPassword"})
 	@Test (priority = 4)
 	public void Verify_that_user_receives_email_to_reset_password_after_entering_valid_email_address_in_Password_Reset_screen(String Username, String GPassword){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.clickPasswordReset();
 			LG.inputEmail(Username);
 			LG.clickReset();
 			LG.clickOK();
 			LG.getGoogleMailURL();
 			LG.inputGoogleEmail(Username);
 			LG.clickNext();
 			LG.inputGooglePassword(GPassword);
 			LG.clickNext();
 			LG.verifyEmailBox();
 	}
 	
 	@Parameters("Username")
 	@Test (priority = 5)
 	public void Verify_that_the_Forgot_Password_field_does_not_accept_invalid_email(String Username){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.clickPasswordReset();
 			LG.inputEmail(Username);
 			LG.clickReset();
 			LG.verifyError3();
 	}
 	
 	@Parameters("Username")
 	@Test (priority = 6)
 	public void Verify_that_user_can_copy_and_paste_email_field_info(String Username){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.inputUsername(Username);
 			LG.tryGetValueFromUsername();
 	}
 	
 	@Parameters("Password")
 	@Test (priority = 7)
 	public void Verify_user_cannot_copypaste_values_from_Password_and_Retype_password_fields(String Password){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.inputPassword(Password);
 			LG.tryGetValueFromPasswordField();
 	}
 	
 	@Parameters("Password")
 	@Test (priority = 8)
 	public void Verify_Password_field_masks_users_input_with_bullets(String Password){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.inputPassword(Password);
 			LG.verifyPasswordInABullet();
 	}
 	
 	@Parameters({"Username","ERPassword"})
 	@Test (priority = 9)
 	public void Verify_user_cannot_login_with_an_invalid_password(String Username, String ERPassword){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.inputUsername(Username);
 			LG.inputPassword(ERPassword);
 			LG.clickLogin();
 			LG.verifyError2();
 	}
 	
 	@Parameters({"ERUsername","Password"})
 	@Test (priority = 10)
 	public void Verify_user_cannot_login_with_an_invalid_email_address(String ERUsername, String Password){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
			LG.getSingInURL();
			LG.inputUsername(ERUsername);
			LG.inputPassword(Password);
			LG.clickLogin();
			LG.verifyError2();
 	}
 	
 	@Test (priority = 10)
 	public void Verify_Register_Now_in_login_page_will_redirect_user_to_the_registration_page(){
 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
 			LG.getSingInURL();
 			LG.clickRegisterNow();
 			LG.verifyRegisterPage();
 	}
// 	
// 	@Test (priority = 11)
// 	public void Verify_email_text_box_is_identified_with_both_Enter_email_content_and_letter_icon(){
// 		LoginPage LG = PageFactory.initElements(driver, LoginPage.class);
// 			
// 	}
	
}
