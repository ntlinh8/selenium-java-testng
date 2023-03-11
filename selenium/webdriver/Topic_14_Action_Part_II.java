package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Action_Part_II {
	WebDriver driver;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Click_And_Hold_Select_Multi_Item() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		List<WebElement> elementList = driver.findElements(By.cssSelector("ol#selectable li"));
		//Click //Van giu chuot
		action.clickAndHold(elementList.get(0))
		//Di chuyen den vi tri can lay
		.moveToElement(elementList.get(7))
		//Nha chuot ra
		.release()
		.perform();
		List<WebElement> elementSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
		Assert.assertEquals(elementSelected.size(), 8);
	}

	@Test
	public void TC_02_Click_And_Hold_Select_Random_Item() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		//Dam bao chay co ca MacOS and Window
		Keys key = null;
		if(osName.contains("Windows")) {
			key = Keys.CONTROL;
		}else key = Keys.COMMAND;
		
		List<WebElement> elementList = driver.findElements(By.cssSelector("ol#selectable li"));
		
		//Nhan Control
		action.keyDown(key).perform();
		
		//Chon cac so random
		action.click(elementList.get(0))
		.click(elementList.get(3))
		.click(elementList.get(5))
		.click(elementList.get(10))
		.perform();
		
		//Nhan Control ra
		action.keyUp(key).perform();
		List<WebElement> elementSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
		Assert.assertEquals(elementSelected.size(), 4);
	}

	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}