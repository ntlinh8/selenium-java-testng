package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_26_ImplicitWait {
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

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	/*
	 * Knowledge: Sau khi apply implicit wait thi no se anh huong toi tat ca qua trinh findElement ngay sau do 
	 * -> chi can apply set implicit wait 1 lan duy nhat cho toan bo script
	 * 
	 * Implicit wait: wait ngầm định: ko cho 1 element nào cụ thể hoặc 1 trạng thái nào cụ thể nào
	 */
	@Test
	public void TC_01_No_Enough_Time() {
		// TH1: Khong du thoi gian element hien thi
		// Result: Fail - 2s
		
		// implicitwait = 15
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// implicitwait = 2
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	@Test
	public void TC_02_Enough_Time() {
		// TH2: Du thoi gian
		// Result: PASS - 5
		
		//implicitwait = 2
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//implicitwait = 5
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}
	
	@Test
	public void TC_03_More_Time() {
		// TH2: Thua thoi gian (vi trong 15s, tai giay thu 5 da tim thay element -> getText -> compare -> ket thuc)
		// Result: PASS - 5

		// implicitwait = 5
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// implicitwait = 15
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
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