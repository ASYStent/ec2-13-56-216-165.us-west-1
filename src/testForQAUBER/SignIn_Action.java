package testForQAUBER;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testForQAUBER.LogIn_Page;

public class SignIn_Action {
	
	public static final String Username = "dovgichnik@gmail.com";
    public static final String Password = "1234567890";
    public static void loginToSite(){
    	Exam.wait = new WebDriverWait(Exam.driver, 20);
		Exam.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        LogIn_Page.input_UserName().sendKeys(Username);
        LogIn_Page.input_Password().sendKeys(Password);
        LogIn_Page.click_LogIn().click();
    }
	
    public static void goToPage() {
    	Exam.driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
	}
}
