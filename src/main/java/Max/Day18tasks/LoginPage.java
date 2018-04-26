import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//class for Login page
public class LoginPage {
	
	//click on Register Now button
	public static void register(WebDriver driver, String registerNowXpath, String registerPageUrl) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Thread.sleep(2000); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(registerNowXpath)));   
		driver.findElement(By.xpath(registerNowXpath)).click();
		wait.until(ExpectedConditions.urlToBe(registerPageUrl));
        if (driver.getCurrentUrl().equals(registerPageUrl)) {
        	System.out.println("PASS: Clicked Register button and landed at " + registerPageUrl);
        }else {
        	System.out.println("FAIL: Failed to click the Register button");
        }		
	}
	
	//click on forgot your password link
	public static void forgotPassString (WebDriver driver, String forgotPassXpath, String forgotPassUrl) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Thread.sleep(1500); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(forgotPassXpath))).click();   
		try {wait.until(ExpectedConditions.urlToBe(forgotPassUrl));
		System.out.println("PASS: Clicked on 'Forgot your password' link and landed at " + forgotPassUrl);
	    } catch (Exception ex){
	    	System.out.println("FAIL: Failed to click on 'Forgot your password' link");
	    } 
	}
	
	//enter email address
	public static void enterEmail(WebDriver driver, String email, String emailFieldXpath) {
		WebElement emailField = driver.findElement(By.xpath(emailFieldXpath));
        emailField.sendKeys(email);
        if (emailField.getAttribute("value").equals(email)) {
        	System.out.println("PASS: Entered email address " + email);
        }else {
        	System.out.println("FAIL: Failed to enter email address");
        }    
	}
	
	//enter password
	public static void enterPassword(WebDriver driver, String password, String passwordFieldXpath) {
		WebElement passwordField = driver.findElement(By.xpath(passwordFieldXpath));
		passwordField.sendKeys(password);
        if (passwordField.getAttribute("value").equals(password)) {
        	System.out.println("PASS: Entered password");
        }else {
        	System.out.println("FAIL: Failed to enter password");
        }    
	}
	
	//click submit button
	public static void submitLogin(WebDriver driver, String loginButtonXpath, String homePageUrl) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginButtonXpath))).click();
		try {wait.until(ExpectedConditions.urlToBe(homePageUrl));
		System.out.println("PASS: Successfully logged in and landed at " + homePageUrl);
	    } catch (Exception ex){
	    	System.out.println("FAIL: Failed to log in");
	    }
	}		
	
}
