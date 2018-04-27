package Max.Day15tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//class for Login page
public class LoginPage {
	
	//methods for actual behavior	
	public static void register(WebDriver driver, String registerNowXpath, String registerPageUrl) throws InterruptedException {
		//click on Register Now button
		Thread.sleep(3000);                                                                               
		WebElement registerNow = driver.findElement(By.xpath(registerNowXpath));
        registerNow.click();
    	System.out.print("TEST CASE Register: ");
        if (driver.getCurrentUrl().equals(registerPageUrl)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }		
	}
	
	public static void forgotPassString (WebDriver driver, String forgotPassXpath, String forgotPassUrl) throws InterruptedException {
		//click on forgot your password link
		Thread.sleep(3000);
		WebElement forgotPass = driver.findElement(By.xpath(forgotPassXpath));
        forgotPass.click();
    	System.out.print("TEST CASE Forgot password: ");
        if (driver.getCurrentUrl().equals(forgotPassUrl)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }    
	}
	
	public static void enterEmail(WebDriver driver, String email, String emailFieldXpath) {
		//enter email
		WebElement emailField = driver.findElement(By.xpath(emailFieldXpath));
        emailField.sendKeys(email);
	}
	
	public static void enterPassword(WebDriver driver, String password, String passwordFieldXpath) {
		//enter password
		WebElement passwordField = driver.findElement(By.xpath(passwordFieldXpath));
        passwordField.sendKeys(password);
	}
	
	public static void submitLogin(WebDriver driver, String loginButtonXpath, String homePageUrl) throws InterruptedException {
		//click submit button
		Thread.sleep(3000);
		WebElement loginButton = driver.findElement(By.xpath(loginButtonXpath));
        loginButton.click();
		Thread.sleep(3000);
    	System.out.print("TEST CASE Login: ");
        if (driver.getCurrentUrl().equals(homePageUrl)) {
        	System.out.println("PASS");	
        }else {
        	System.out.println("FAIL");
        }    
	}
			
}
