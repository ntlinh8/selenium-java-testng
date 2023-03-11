package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Action_Part_III {
	WebDriver driver;
	Actions action;
	JavascriptExecutor jsExecutor;
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
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Double_Click() {
		//Element can thao tac ko nam trong view port (neu chay tron Firefox se bi loi nay, trong khi Chrome thi ko)
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Neu la true thi element can tim se o mep tren, nguoc lai neu la false thi se o mep duoi
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Double click me']")));
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
		
	}

	@Test
	public void TC_02_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		SleepInSecond(2);
		
		//Right click on button and verify context menu display
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Quit']")).isDisplayed());
		
		//Move on the Quit button and verify the button was hover and visible
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();
		SleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-hover.context-menu-visible")).isDisplayed());
		
		//Click on Quit button and verify the context menu not display
		action.click(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();
		driver.switchTo().alert().accept();
		
		Assert.assertFalse(driver.findElement(By.xpath("//span[text()='Quit']")).isDisplayed());
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