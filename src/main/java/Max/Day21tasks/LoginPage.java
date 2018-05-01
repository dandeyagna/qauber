package Max.Day21tasks;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//class for Login page
public class LoginPage {
	static WebDriver driver = new FirefoxDriver();
	private static String url = "http://fits.qauber.com/#/page/login";

	@BeforeTest
	public static void setUp() throws InterruptedException {
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	    driver.manage().window().setPosition(new Point(200,100));
	    driver.manage().window().setSize(new Dimension(1600,1200));
	    driver.get(url);
	    Thread.sleep(3000); 
	}
	
	//click on Register Now button
	@Test(dataProvider = "register", dataProviderClass = TestData.class)
	public static void register(String registerNowXpath, String registerPageUrl) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(registerNowXpath))).click();   
		wait.until(ExpectedConditions.urlToBe(registerPageUrl));
		Assert.assertEquals(registerPageUrl, driver.getCurrentUrl(), "Failed to get to registration URL.");
	}
	
	//click on forgot your password link
	@Test(dependsOnMethods = {"register"}, dataProvider = "forgotPass", dataProviderClass = TestData.class)
	public static void forgotPass (String forgotPassXpath, String forgotPassUrl) throws InterruptedException {
	    driver.get(url);
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(forgotPassXpath))).click();  
		Assert.assertEquals(forgotPassUrl, driver.getCurrentUrl(), "Failed to get to forgot password URL.");
	}
	
	//enter email address
	@Test(dependsOnMethods = {"register", "forgotPass"}, dataProvider = "email", dataProviderClass = TestData.class)
	public static void enterEmail(String email, String emailFieldXpath) {
	    driver.get(url);
		WebElement emailField = driver.findElement(By.xpath(emailFieldXpath));
        emailField.sendKeys(email);
        Assert.assertEquals(email, emailField.getAttribute("value"), "Failed to enter email.");
	}
	
	//enter password
	@Test(dependsOnMethods = {"register", "forgotPass"}, dataProvider = "password", dataProviderClass = TestData.class)
	public static void enterPassword(String password, String passwordFieldXpath) {
		WebElement passwordField = driver.findElement(By.xpath(passwordFieldXpath));
		passwordField.sendKeys(password);
		Assert.assertEquals(password, passwordField.getAttribute("value"), "Failed to enter password.");
	}
	
	//click submit button
	@Test(dependsOnMethods = {"enterEmail", "enterPassword"}, dataProvider = "submit", dataProviderClass = TestData.class)
	public static void submitLogin(String loginButtonXpath, String homePageUrl) throws InterruptedException {
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginButtonXpath))).click();
		wait.until(ExpectedConditions.urlToBe(homePageUrl));
		Assert.assertEquals(homePageUrl, driver.getCurrentUrl(), "Failed to login into the Reports page");
	}	
	
}
