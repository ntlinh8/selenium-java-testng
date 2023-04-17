package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_08_Condition_Statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = 5 > 3;
		if(result) {
			System.out.println("Go to if");
		}
		
		FirefoxDriver driver = new FirefoxDriver();
		WebElement element = driver.findElement(By.className(null));
		if (element.isDisplayed()) {
			element.click();
		}
	}

}
