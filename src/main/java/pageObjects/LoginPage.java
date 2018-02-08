package main.java.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	public LoginPage(WebDriver driver){ 
        this.driver=driver; 
    }

	WebDriver driver;
	
    @FindBy(how=How.XPATH, using="//input[@name='email']") WebElement usernameField;
    @FindBy(how=How.XPATH, using="//input[@name='password']") WebElement passwordField;
    @FindBy(how=How.XPATH, using="//button[@id='login']") WebElement buttonLogin;
    @FindBy(how=How.XPATH, using="//h3[text()='Talents']") WebElement talents;
    @FindBy(how=How.XPATH, using="//*[text()='This value is required.']") WebElement errorText;
    @FindBy(how=How.XPATH, using="//strong[text()='PASSWORD RESET']") WebElement passwordResetPage;
    @FindBy(how=How.XPATH, using="//strong[text()='SIGNUP TO GET INSTANT ACCESS") WebElement registerPage;
    @FindBy(how=How.XPATH, using="//button[text()='Reset']") WebElement buttonReset;
    @FindBy(how=How.XPATH, using="//button[text()='OK']") WebElement buttonOK;
    @FindBy(how=How.XPATH, using="//input[@type='email']") WebElement googleEmailField;
    @FindBy(how=How.XPATH, using="//span[text()='Next']") WebElement buttonNext;
    @FindBy(how=How.XPATH, using="//input[@type='password']") WebElement googlePasswordField;
    @FindBy(how=How.XPATH, using="//b[text()='[ProMyTheUs] Password reset request']") WebElement letterItem;
    @FindBy(how=How.XPATH, using="//div[text()='Invalid Email or Password.']") WebElement errorText2;
    @FindBy(how=How.XPATH, using="//input[@type='password']") boolean typeField;
    @FindBy(how=How.XPATH, using="//h2[text()='Error!']") WebElement errorText3;
    @FindBy(how=How.LINK_TEXT, using="Forgot your password?") WebElement passwordResetLink;
    @FindBy(how=How.LINK_TEXT, using="Register Now") WebElement registrationLink;
    @FindBy(how=How.TAG_NAME, using="email") WebElement emailField;
    
    

    
	public void getSingInURL(){
    	driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
	}    
	public void getGoogleMailURL() {
    	driver.get("https://mail.google.com/mail/u/0/#inbox");
	}
	public void inputUsername(String Username){
    	usernameField.sendKeys(Username);
	}
	public void inputPassword(String Password){
		passwordField.sendKeys(Password);
	}
	public void inputEmail(String Email){
		emailField.sendKeys(Email);
	}
	public void inputGoogleEmail(String Username) {
		googleEmailField.sendKeys(Username);
	}
	public void inputGooglePassword(String GPassword) {
		googlePasswordField.sendKeys(GPassword);
	}
	public void clickLogin(){
		buttonLogin.click();
	}
	public void clickPasswordReset(){
		passwordResetLink.click();
	}
	public void clickRegisterNow(){
		registrationLink.click();
	}
	public void clickReset() {
		buttonReset.click();
	}
	public void clickOK() {
		buttonOK.click();
	}
	public void clickNext() {
		buttonNext.click();
	}
	
	
	
	public void verifyLogin(String id, String title1){
 		try{
 			boolean title = talents.isDisplayed();
 			if (title==true ){
 				System.out.println("Title is displayed");
 				
//				HSSFWorkbook workbook = new HSSFWorkbook();
// 	 			HSSFSheet sheet = workbook.getSheet("Test Cases");
// 	 			
// 	 			Row row = sheet.getRow(0);
// 	 			int maxNumOfCells = 500;
// 	 			
//				for( int cellCounter = 0; cellCounter < maxNumOfCells; cellCounter ++){ // Loop through cells
//
// 	                HSSFCell cell;
//
// 	                if( row.getCell(cellCounter ) == null ){
// 	                	Cell cell0 = row.createCell(0);
// 	                	cell0.setCellValue(id);
// 	 			
// 	                	Cell cell1 = row.createCell(1);
// 	                	cell1.setCellValue(title1);
// 	 			
// 	                	Cell cell2 = row.createCell(2);
// 	                	cell2.setCellValue("executed");
// 	 			
// 	                	Cell cell4 = row.createCell(4);
// 	                	cell4.setCellValue("Pass");
// 	                } 
// 	                else {
// 	                    cell = (HSSFCell) row.getCell(cellCounter);
// 	                }
// 	            }
// 	 			
// 	 			
// 	 			try(FileOutputStream out = new FileOutputStream(new File("D:/MyDoc/automation/java-webdriver-cucumber/ProMytheUs/src/exel/report.xls"))) {
// 	 				workbook.write(out);
// 	 				System.out.println("Excel written successfully..");
// 	 			} catch (FileNotFoundException e) {
// 	 				e.printStackTrace();
// 	 			} catch (IOException e) {
// 	 				e.printStackTrace();
// 	 			}
//
 				}
		}
	    catch (Exception e){
	    }
	}
 	public void verifyError(){
 		try{
 			boolean error = errorText.isDisplayed();
 			if (error==true ){
				System.out.println("Error is displayed");
				}
 		}
 		catch(Exception e){
		}
	}
 	public void verifyPasswordReset(){
 		try{
 			boolean title = passwordResetPage.isDisplayed();
 			if(title==true){
 				System.out.println("Title is displayed");				
 			}
 		}
 		catch(Exception e){}
 	}
 	public void verifyRegisterPage(){
 		try{
 			boolean title = registerPage.isDisplayed();
 			if(title==true){
 				System.out.println("Title is displayed");
 				}
 		}
 		catch(Exception e){}
 		}
	public void verifyEmailBox() {
		try{
			boolean letter = letterItem.isDisplayed();
			if(letter==true){
 				System.out.println("Letter is found");
			}
		}
		catch(Exception e){}
	}
	public void verifyError2(){
		try{
			boolean error = errorText2.isDisplayed();
			if(error==true){
				System.out.println("Error is displayed");
			}
		}
		catch(Exception e){}
	}
	public void tryGetValueFromUsername(){
		try{
			String value = usernameField.getAttribute("value");
			if(value=="dovgichnik@gmail.com"){
				System.out.println("Value is copied");
			}
		}
		catch(Exception e){}
	}
	public void tryGetValueFromPasswordField(){
		try{
			String value = passwordField.getAttribute("value");
			if(value==null){
				System.out.println("Value didn't copied");
			}
		}
		catch(Exception e){}
	}
	public void verifyPasswordInABullet(){
		try{
			boolean tag = typeField;
			if(tag==true){
				System.out.println("The password in a bullet");
			}
		}
		catch(Exception e){}
	}
	public void verifyError3(){
		try{
			boolean error = errorText3.isDisplayed();
			if(error==true){
				System.out.println("Error is displayed");
			}
		}
		catch(Exception e){}
	}
	public void report1(String Title, String Status){
		
		FileInputStream inputFile = null;
		HSSFWorkbook workbook = null;
		String filePath = "D:/MyDoc/automation/java-webdriver-cucumber/ProMytheUs/src/exel/report.xls";

		try {
			inputFile = new FileInputStream(new File(filePath));
			workbook = new HSSFWorkbook(inputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFCell cell = null;

		cell = sheet.getRow(1).getCell(1);
		cell.setCellValue(Status);
		
		cell = sheet.getRow(1).getCell(0);
		cell.setCellValue(Title);
		
		try {
			FileOutputStream outFile = null;
			outFile = new FileOutputStream(new File(filePath));
			workbook.write(outFile);
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	}
	
}
