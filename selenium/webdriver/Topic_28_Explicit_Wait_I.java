package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Explicit_Wait_I {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	/*
	 * Implicit wait: wait ngầm định: ko cho 1 element nào cụ thể hoặc 1 trạng thái
	 * nào cụ thể nào Explicit wait: tên do cộng đồng đặt chứ thực ra nó là
	 * WebDriverWait. Là wait tường minh, thực thi cho một trạng thái cụ thể của
	 * element
	 */

	@Test
	public void TC_01_Exist_Element_And_No_Enough_Time_For_Condition() {
		// TH1: Khong du thoi gian element invisible
		// Result: FAIL - 2 (vi sau 2s ko thay element invisiable - expected condition
		// fail

		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();

		// Apply 2s cho element invisible
		explicitWait = new WebDriverWait(driver, 2);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

		Assert.assertTrue(driver.findElement(By.cssSelector("div#finish>h4")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	@Test
	public void TC_02_Exist_Element_And_Enough_Time_For_Condition() {
		// TH2: Du thoi gian element invisible
		// Result: PASS - 5s

		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();

		// Apply 5s cho element invisible
		explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

		Assert.assertTrue(driver.findElement(By.cssSelector("div#finish>h4")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	@Test
	public void TC_03_Exist_Element_And_More_Time_For_Condition() {
		// TH3: Thua thoi gian element invisible
		// Result: PASS - 5s

		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		// Apply 10s cho element invisible
		explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div#finish>h4")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}
	
	@Test
	public void TC_04_Exist_Element_And_No_Enough_Time_For_Condition() {
		// TH1: Khong du thoi gian element visible
		// Result: FAIL - 2 (vi sau 2s ko thay element visiable - expected condition
		// fail

		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();

		// Apply 2s cho element visible
		explicitWait = new WebDriverWait(driver, 2);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	@Test
	public void TC_05_Exist_Element_And_Enough_Time_For_Condition() {
		// TH2: Du thoi gian element visible
		// Result: PASS - 5s

		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();

		// Apply 5s cho element visible
		explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	@Test
	public void TC_06_Exist_Element_And_More_Time_For_Condition() {
		// TH3: Thua thoi gian element visible
		// Result: PASS - 5s

		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		// Apply 10s cho element visible
		explicitWait = new WebDriverWait(driver, 10);		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}
	
	@Test
	public void TC_07_No_Element() {
		// TH4: Ko thay element trong DOM
		// Result: Fail and time = implicitWait
		// in this case, time = 30
		driver.get("https://automationfc.github.io/dynamic-loading/");

		// Apply 5s cho element invisible
		explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#hello")));
	}
	
	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}