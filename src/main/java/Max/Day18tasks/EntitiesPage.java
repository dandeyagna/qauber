package Max.Day18tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//class for the Entities page
public class EntitiesPage {
	
	//method for clicking the add entity button
	public static void clickAddEntity(WebDriver driver, String addEntityXpath, String afterAddEntityUrl) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addEntityXpath)));
		driver.findElement(By.xpath(addEntityXpath)).click();
		wait.until(ExpectedConditions.urlToBe(afterAddEntityUrl));
        if (driver.getCurrentUrl().equals(afterAddEntityUrl)) {
        	System.out.println("PASS: Click ADD entity button");  	
        }else {
        	System.out.println("FAIL: Click ADD entity button");
        }	
	}
	
	// --DISABLED-- method for clicking on the First Entity in the list
	public static void clickFirstEntity(WebDriver driver, String firstEntityXpath) throws InterruptedException {
		Thread.sleep(1000);                                                                               
		WebElement addEntity = driver.findElement(By.xpath(firstEntityXpath));
        addEntity.click();
        //	System.out.print("click add entity button: ");
        //if (driver.getCurrentUrl().equals(afterAddEntityUrl)) {
        //	System.out.print("PASS");  	
        //}else {
        //	System.out.print("FAIL");
        //}	
	}
	
	//click on the Assign Permissions button
	public static void clickAssPermissions(WebDriver driver, String assPermissionsXpath, String assPermCloseXpath) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);  
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(assPermissionsXpath)));
		WebElement assPermissionsButton = driver.findElement(By.xpath(assPermissionsXpath));
		assPermissionsButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(assPermCloseXpath)));
		WebElement assPermClose = driver.findElement(By.xpath(assPermCloseXpath));
		if (assPermClose.isEnabled()) {
			assPermissionsButton.click();
        	System.out.println("PASS: Click Assign Permissions button");  	
		}else {
			System.out.println("FAIL: Click Assign Permissions button");
		} 
	}
	
	//click on the Edit entity button for the first entity
	public static void clickEditEntity(WebDriver driver, String editEntityXpath, String editEntityUrl) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(editEntityXpath)));
		driver.findElement(By.xpath(editEntityXpath)).click();
		wait.until(ExpectedConditions.urlToBe(editEntityUrl));
        if (driver.getCurrentUrl().equals(editEntityUrl)) {
        	System.out.println("PASS: Click Edit Entity button");  	
        }else {
        	System.out.println("FAIL: Click Edit Entity button");
        }	
	}
	
	//click on the Delete entity button for the first entity
	public static void deleteEntity(WebDriver driver, String deleteEntityXpath, String deleteCancelXpath) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteEntityXpath)));                                                                     
		driver.findElement(By.xpath(deleteEntityXpath)).click();
		if (driver.findElements(By.xpath(deleteCancelXpath) ).size() != 0) {
			WebElement closeDelete = driver.findElement(By.xpath(deleteCancelXpath));
			closeDelete.click();
        	System.out.println("PASS: Click Delete Entity button");  	
		}else {
			System.out.println("FAIL: Click Delete Entity button");
		}
	
	}
	
}
