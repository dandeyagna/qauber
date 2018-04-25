import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
				System.out.println("PASS: Radio Box " + (i+1));
			}else {
				System.out.println("FAIL: Radio Box " + (i+1));
			}
			}	
		}
	}
	
	public static void switchTabs(WebDriver driver, int tab, String tabName, int legendKey) throws InterruptedException {
		List<WebElement> tabList = driver.findElements(By.tagName("li"));
		WebElement currentTab = tabList.get(tab);
		currentTab.click();
		Thread.sleep(1000);

		List<WebElement> tabLegendList = driver.findElements(By.tagName("legend"));	
		WebElement tabLegend = tabLegendList.get(legendKey);
		
		//System.out.println("From element " + tabLegend.getText());
		//System.out.println("From variable" + tabName);
	
		if(tabLegend.getText().equals(tabName)){
			System.out.println("PASS: Switch tab to " + tabLegend.getText());
		}else {
			System.out.println("FAIL: Problem switching tab");
		}
	}
	
	public static void enterSubjectInformation(WebDriver driver, Map easyFields, Map dropDowns, String siDriverTypeXpath, String siDriverType, String dobXpath, String DOB) {
		Iterator ef = easyFields.entrySet().iterator();
	    while (ef.hasNext()) {
	    	Map.Entry pair = (Map.Entry)ef.next();
	    	String fieldKey = (String) pair.getKey();
	    	String inputValue = (String) pair.getValue();
	    	WebElement currentField = driver.findElement(By.name(fieldKey));
	    	currentField.sendKeys(inputValue);
	        if (currentField.getAttribute("value").equals(inputValue)) {
	        	System.out.print("PASS");
	        }else {
	        	System.out.print("FAIL");
	        }    
	        System.out.println(": Entered " + inputValue + " into the " + fieldKey + " text field");
	    }  
	    
		WebElement dobField = driver.findElement(By.xpath(dobXpath));
		dobField.sendKeys(DOB);
		if (dobField.getAttribute("value").equals(DOB)) {
        	System.out.print("PASS");
        }else {
        	System.out.print("FAIL");
        }    
        System.out.println(": Entered DOB of " + DOB);
	    
		Iterator dd = dropDowns.entrySet().iterator();
	    while (dd.hasNext()) {
	    	Map.Entry pair = (Map.Entry)dd.next();
	    	String fieldKey = (String) pair.getKey();
	    	String inputValue = (String) pair.getValue();
	    	WebElement currentDropdown = driver.findElement(By.xpath(".//*[@ng-model='wizard.report." + fieldKey + "']"));
	    	Select currentDropdownSelect = new Select(currentDropdown);
	    	currentDropdownSelect.selectByValue(inputValue);  	
	    	if (currentDropdown.getAttribute("value").equals(inputValue)) {
	        	System.out.print("PASS");
	        }else {
	        	System.out.print("FAIL");
	        }    
	        System.out.println(": Selected " + inputValue + " from the " + fieldKey + " dropdown");
	    }
	    
	    List<WebElement> clickableSiTypeRadios = driver.findElements(By.xpath(siDriverTypeXpath + "span"));
	    List<WebElement> hiddenSiTypeRadios = driver.findElements(By.xpath(siDriverTypeXpath + "input"));
	    	int siDriverSelector = 0;
	    	if (siDriverType == "Driver"){
	    		siDriverSelector = 0;
	    	} else if (siDriverType == "Passenger") {
	    		siDriverSelector = 1;
	    	} else if (siDriverType == "Pedestrian") {
	    		siDriverSelector = 2;
	    	} else {
	    		System.out.println("ERROR: Invalid driver type");
	    	}
			WebElement currentDriverRadio = clickableSiTypeRadios.get(siDriverSelector);
			WebElement hiddenDriverRadio = hiddenSiTypeRadios.get(siDriverSelector);
			if(currentDriverRadio.isDisplayed()) {
				currentDriverRadio.click();	
			}
			if(hiddenDriverRadio.isSelected()) {
				System.out.print("PASS");
			}else {
				System.out.print("FAIL");
			}
			System.out.println(": Radio Box " + (siDriverSelector +1) + " - " + siDriverType + " - selected");
	    
	}
	
	public static void fifthTabActions(WebDriver driver, String diTypeXpath, String diType) {
		List<WebElement> clickableDiTypeRadios = driver.findElements(By.xpath(diTypeXpath + "span"));
		List<WebElement> hiddenDiTypeRadios = driver.findElements(By.xpath(diTypeXpath + "input"));
		    int diTypeSelector = 0;
		    if (diType == "Gang Unit"){
		    	diTypeSelector = 0;
		    } else if (diType == "Sex Crimes") {
	    		diTypeSelector = 1;
	    	} else if (diType == "Robbery") {		    		
	    		diTypeSelector = 2;
	    	} else if (diType == "Narco") {		    		
	    		diTypeSelector = 3;
	    	} else if (diType == "Vice / Intel") {		    		
	    		diTypeSelector = 4;
	    	} else {
	    		System.out.println("ERROR: Invalid driver type");
	    	}
			WebElement currentDistributionRadio = clickableDiTypeRadios.get(diTypeSelector);
			WebElement hiddenDistributionRadio = hiddenDiTypeRadios.get(diTypeSelector);
			if(currentDistributionRadio.isDisplayed()) {
				currentDistributionRadio.click();	
			}
			if(hiddenDistributionRadio.isSelected()) {
				System.out.print("PASS");
			}else {
				System.out.print("FAIL");
			}
			System.out.println(": Radio Box " + (diTypeSelector +1) + " - " + diType + " - selected");
	}
	
}
