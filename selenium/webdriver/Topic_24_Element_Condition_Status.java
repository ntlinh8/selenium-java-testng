package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_Element_Condition_Status {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Visible_Displayed_Visibility() {
		/*
		 * Danh cho element thoa man kieu kien: hien tri tren UI (vay nen chac chan co trong DOM)
		 */
		driver.get("https://www.facebook.com/");
		
		//Wait cho den khi email textbox hien thi
		//Cho cho email textbox hien thi trong 10s
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#email")));
		driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.com");
	}

	@Test
	public void TC_02_Invisible_Undisplayed_Invisibility_I() {
		/*
		 * Ko co tren UI
		 * Co trong DOM
		 */
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		//Wait cho den khi re-enter email textbox ko hien thi
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Re-enter email address']")));
	}
	
	@Test
	public void TC_02_Invisible_Undisplayed_Invisibility_II() {
		/*
		 * Ko co tren UI
		 * Ko trong DOM
		 */
		driver.get("https://www.facebook.com/");
		
		//Wait cho den khi re-enter email textbox ko hien thi
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Re-enter email address']")));
	}
	
	@Test
	public void TC_03_Presence() {
		/*
		 * Co trong DOM
		 * Ko quan tam la co hien thi hay khong
		 */
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Re-enter email address']")));
	}

	@Test
	public void TC_04_Staleness() {
		/*
		 * Ko co trong DOM
		 */
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		//Element co trong DOM (tai day khai bao element thi da di tim trong DOM luon, nen ko can check presence nua
		WebElement reEnterEmailTextbox = driver.findElement(By.xpath("//div[text()='Re-enter email address']"));
		
		//action
		
		//Close popup
		
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		
		explicitWait.until(ExpectedConditions.stalenessOf(reEnterEmailTextbox));
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