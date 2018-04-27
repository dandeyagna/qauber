package Max.Day16tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//class for the Entities page
public class EntitiesPage {
	
	//method for clicking the add entity button
	public static void clickAddEntity(WebDriver driver, String addEntityXpath, String afterAddEntityUrl) throws InterruptedException{
		//sleep to let the page load
		Thread.sleep(1000);                                                                               
		WebElement addEntity = driver.findElement(By.xpath(addEntityXpath));
        addEntity.click();
        
        //check if it actually went to the correct URL, and then mark pass/fail
    	System.out.print("TEST CASE Click ADD entity button: ");
        if (driver.getCurrentUrl().equals(afterAddEntityUrl)) {
        	System.out.println("PASS");  	
        }else {
        	System.out.println("FAIL");
        }	
	}
	
	//method for clicking on the First Entity in the list
	public static void clickFirstEntity(WebDriver driver, String firstEntityXpath) throws InterruptedException {
		//sleep to let the page load
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
		//sleep to let the page load
		Thread.sleep(1000);                                                                               
		WebElement assPermissions = driver.findElement(By.xpath(assPermissionsXpath));
        assPermissions.click();
		//sleep to let the page load
		Thread.sleep(2000);  
		driver.switchTo().activeElement();
		
		//check if the "Assign Permissions" modal popped up and then mark parss/fail
		if (driver.findElements(By.xpath(assPermCloseXpath) ).size() != 0) {
			WebElement closeAss = driver.findElement(By.xpath(assPermissionsXpath));
			closeAss.click();
        	System.out.println("TEST CASE Click Assign Permissions button: PASS");  	
		}else {
			System.out.println("TEST CASE Click Assign Permissions button: FAIL");
		} 
	}
	
	//click on the Edit entity button for the first entity
	public static void clickEditEntity(WebDriver driver, String editEntityXpath, String editEntityUrl) throws InterruptedException {
		//sleep to let the page load
		Thread.sleep(1000);                                                                               
		WebElement editEntity = driver.findElement(By.xpath(editEntityXpath));
        editEntity.click();

        //check if it actually went to the correct URL, and then mark pass/fail
        System.out.print("TEST CASE Click EDIT entity button: ");
        if (driver.getCurrentUrl().equals(editEntityUrl)) {
        	System.out.println("PASS");  	
        }else {
        	System.out.println("FAIL");
        }	
	}
	
	//click on the Delete entity button for the first entity
	public static void deleteEntity(WebDriver driver, String deleteEntityXpath, String deleteCancelXpath) throws InterruptedException {
		//sleep to let the page load
		Thread.sleep(1000);                                                                               
		WebElement deleteEntity = driver.findElement(By.xpath(deleteEntityXpath));
        deleteEntity.click();
		//sleep to let the page load
		//Thread.sleep(3000);  
		//driver.switchTo().activeElement();
		
		//check if the "Delete Entity" modal popped up, and then mark pass/fail
		if (driver.findElements(By.xpath(deleteCancelXpath) ).size() != 0) {
			WebElement closeDelete = driver.findElement(By.xpath(deleteCancelXpath));
			closeDelete.click();
        	System.out.println("TEST CASE Click Delete Entity button: PASS");  	
		}else {
			System.out.println("TEST CASE Click Delete Entity button: FAIL");
		}
	
	}
	
}
