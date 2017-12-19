package jUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public static WebDriver driver;
	public static String URL = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
	public static String Username = "dovgichnik@gmail.com";
	public static String Password = "123456789";
	
	
	
	public static void SetLogin() {
		System.setProperty("webdriver.chrome.driver", "D:\\MyDoc\\automation\\java-webdriver-cucumber\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='login']")).click(); 
	}

}
