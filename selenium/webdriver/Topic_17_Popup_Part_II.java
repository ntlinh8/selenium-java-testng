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

public class Topic_17_Popup_Part_II {
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

	@Test
	public void TC_01_Fixed_Popup_Not_In_DOM_Tiki() {
		driver.get("https://tiki.vn/");
		SleepInSecond(2);
		
		//Click on Tai khoan button and verify the popup display
		driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Đăng nhập hoặc Tạo tài khoản']")).isDisplayed());
		
		//Click on link
		driver.findElement(By.xpath("//p[text()='Đăng nhập bằng email']")).click();
		SleepInSecond(2);
		
		//Click on Login button
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Email không được để trống']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Mật khẩu không được để trống']")).isDisplayed());
		
		//Close button and verify popup is not display
		driver.findElement(By.cssSelector("button.btn-close")).click();
		Assert.assertEquals(driver.findElements(By.xpath("//p[text()='Đăng nhập hoặc Tạo tài khoản']")).size(), 0);
	}

	@Test
	public void TC_02_Fixed_Popup_Not_In_DOM_Facebook() {
		driver.get("https://www.facebook.com/");
		SleepInSecond(2);
		
		//Click on Create new account button and verify popup display
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sign Up']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()=\"It's quick and easy.\"]")).isDisplayed());
		
		//Close popup and verify popup is not display
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']")).size(), 0);
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