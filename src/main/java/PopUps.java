import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUps {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\chromedriver.exe
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.globalrph.com/davescripts/popup.htm");

		driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[7]/td/div/table/"+""
						+ "tbody/tr/td[2]/div[1]/form/table/tbody/tr[4]/td[2]/p/input")).click();
		Set<String> windowIds = driver.getWindowHandles(); // get window id of
															// current window
		Iterator<String> itererator = windowIds.iterator();

		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();

		driver.switchTo().window(newAdwinID);
		// System.out.println(driver.getTitle()); No Title for PopUps
		String coupuncode = driver.findElement(By.xpath("/html/body/h2"))
				.getText();
		System.out.println(coupuncode);

		Thread.sleep(1000);
		
		driver.switchTo().window(mainWinID);
		System.out.println(driver.getTitle());

		driver.close();
	}
}

