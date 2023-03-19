package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Popup_Part_III {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String	emailAddress;
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		emailAddress = "elonmusk" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_Random_Popup_In_DOM() {
		driver.get("https://www.javacodegeeks.com/");
		By lePopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
		//Vi no luon co trong DOM nen co the dung ham isDisplay de check
//		if(driver.findElement(lePopup).isDisplayed()) {
//			driver.findElement(By.cssSelector("input.lepopup-ta-left")).sendKeys(emailAddress);
//			driver.findElement(By.xpath("//span[text()='Get the Books']")).click();
//			Assert.assertEquals(driver.findElement(By.xpath("//h4[text()='Thank you!']/parent::div")), "Your sign-up request was successful. We will contact you shortly. Please");
//			SleepInSecond(5);
//		}
		if(driver.findElement(By.cssSelector("div.lepopup-popup-container")).isDisplayed()) {
			SleepInSecond(3);
			driver.findElement(By.xpath("//div[contains(@class, 'lepopup-popup-container')]//a[text()='×']")).click();
			SleepInSecond(5);
		}
		driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
		
		driver.findElement(By.cssSelector("button#search-submit")).click();
		SleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.cssSelector("ul#posts-container>li:first-child h2>a")).getText(), "Agile Testing Explained");
	}

	@Test
	public void TC_02_Random_Popup_In_DOM() {
		driver.get("https://vnk.edu.vn/");
		if(driver.findElement(By.cssSelector("div.tcb-flex-row")).isDisplayed()) {
			SleepInSecond(2);
			driver.findElement(By.xpath("//div[contains(@class,'tcb-flex-row')]/parent::div/preceding-sibling::div[contains(@class, 'tcb-icon-display')]")).click();
		}
	}
	
	@Test
	public void TC_03_Random_Not_In_DOM() {
		driver.get("https://dehieu.vn/");
		SleepInSecond(5);
		if(driver.findElements(By.cssSelector("section#popup")).size() != 0) {
			driver.findElement(By.cssSelector("button#close-popup")).click();
		}
	}

	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(99999);
		return randomNumber;
	}
	
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}