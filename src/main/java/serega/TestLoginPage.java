package serega;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/serega/Desktop/chromedriver");
        ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://fits.qauber.com/#/page/login");
        //String t = driver.getTitle();
        WebElement e  = driver.findElement(By.xpath("//*[@id='exampleInputEmail1']"));
        e.sendKeys(new String[] {"iluhaspirid25@yahoo.com"});
        
        e  = driver.findElement(By.xpath("//*[@id='exampleInputPassword1']"));
        e.sendKeys(new String[] {"123456"});
        
Thread.sleep(10000);
        
        e = driver.findElementByXPath("//button[text()='Login']");
        e.click();
        
       /*     Thread.sleep(10000);
        
        String t = driver.getCurrentUrl();
        
        if(t.equals("http://fits.qauber.com/#/app/reports")){
            System.out.println("Test Passed!!!");
        }else{
            System.out.println("Test Failed!!!");
        }
        
        //driver.quit();
        
        //System.out.println(t);*/
        //driver.close();

	}

}
