package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Popup_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);

		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Fixed_In_DOM_NgoaiNgu() {
		driver.get("https://ngoaingu24h.vn/");
		SleepInSecond(5);
		By popup = By.xpath("//div[@id='modal-register-v1'][@class='modal fade']");
		
		//Verify the popup is not display
		Assert.assertFalse(driver.findElement(popup).isDisplayed());
		
		//Click on Login button and verify the popup display
		driver.findElement(By.cssSelector("button.login_.icon-before")).click();
		Assert.assertTrue(driver.findElement(popup).isDisplayed());
		
		//Entering the information and click on login button
		driver.findElement(By.cssSelector("div.modal.fade.in input#account-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("div.modal.fade.in input#password-input")).sendKeys("automationfc");
		SleepInSecond(2);
		driver.findElement(By.xpath("//div[@class='modal fade in']//button[text()='Đăng nhập']")).click();
		
		//Verify the error message display
		SleepInSecond(10);
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Tài khoản không tồn tại!']")).isDisplayed());
	}

//	@Test
	public void TC_02_Fixed_In_DOM_Kyna() {
		driver.get("https://skills.kynaenglish.vn/");
		By loginPopup = By.cssSelector("div#k-popup-account-login");
		
		//Verify popup is not display
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		
		//Click login button and verify the popup display
		driver.findElement(By.cssSelector("a.login-btn")).click();
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		
		//Enter the information and verify the error message display
		driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
		SleepInSecond(2);
		driver.findElement(By.cssSelector("button#btn-submit-login")).click();
		SleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
		
		//Close popup and verify popup is not display
		driver.findElement(By.cssSelector("button.k-popup-account-close")).click();
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
	}
	
	@Test
	public void TC_03() {
		
	}
	
	@Test
	public void TC_04() {
		
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