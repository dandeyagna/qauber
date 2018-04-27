package Max.Day16tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReport {
	public static void selectRadioButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		//Creating a list out of all the WebElements of the actual radio buttons we can see
		List<WebElement> clickableRadioButtons = driver.findElements(By.xpath(".//*[@class='fa fa-circle']"));
		//Creating a list out of all the WebElements of hidden radio buttons that are actually selected
		List<WebElement> hiddenRadioButtons = driver.findElements(By.xpath(".//*[@type='radio']"));
		//iterating through the list of radio buttons and hidden radio buttons at the same time
		for (int i = 0; i < clickableRadioButtons.size(); i++) {
			//creating a single WebElement object from each item in the list
			WebElement currentClickableRadio = clickableRadioButtons.get(i);
			WebElement currentHiddenRadio = hiddenRadioButtons.get(i);
			//checking if the radio button exists, and if it does - click on it
			if(currentClickableRadio.isDisplayed()) {
				currentClickableRadio.click();	
			//at the same time, we check if the hidden radio button got activated. if it did, the test is a pass
			if(currentHiddenRadio.isSelected()) {
				System.out.println("RADIO BOX " + (i+1) + " - PASS");
			}else {
				System.out.println("RADIO BOX " + (i+1) + " - FAIL");
			}
			}	
		}
	}
}
