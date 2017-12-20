package testForQAUBER;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogIn_Page {
    private static WebElement element = null;
	public static final String URL = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
	public static String URL1;
	
    public static WebElement input_UserName(){
    	element = Exam.driver.findElement(By.xpath("//input[@name='email']"));
    	return element;
    }

    public static WebElement input_Password(){
    	element = Exam.driver.findElement(By.xpath("//input[@name='password']"));
    	return element;
    }

    public static WebElement click_LogIn(){
    	element = Exam.driver.findElement(By.xpath("//button[@id='login']"));
    	return element;
    }
}
