package serega;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegistration {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/serega/Desktop/chromedriver");
        ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://fits.qauber.com/#/page/login");
        //String t = driver.getTitle();
        WebElement e = driver.findElementByXPath("//a[text()='Register Now']");
        Thread.sleep(5000);
        e.click();
        
        e = driver.findElementByXPath("//input[@name='account_name']");
        e.sendKeys(new String[] {"Serega"});
        
        e = driver.findElementByXPath("//input[@name='account_email']");
        e.sendKeys(new String[] {"serega@gmail.com"});
        
        Thread.sleep(5000);
        
        e = driver.findElementById("id-password");
        e.sendKeys(new String[] {"Serega"});
        
        e = driver.findElementByXPath("//input[@name='account_password_confirm']");
        e.sendKeys(new String[] {"Serega"});
        
        Thread.sleep(3000);
        
        e = driver.findElementByXPath("//button[text()='Continue registration']");
        e.click();
        
	}

}

