package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_27_Static_Wait {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	/*
	 * Knowledge: 
	 * Flexible wait bao gom 3 loai la implicit wait, explicit wait and fluent wait
	 * Nhìn chung nó sẽ chờ cho một điều kiện có xảy ra trong một thời gian cố định (đã đc set trc).
	 * Trong thời gian này, cứ sau một thời gian nhất định nó sẽ kiểm tra điều kiện một lần (thời gian cố định là unit time, hiện tại là 0.5s)
	 * Tức cứ 0.5s kiểm tra điều kiện một lần
	 * Nếu trong thời gian này điều kiện thỏa mãn -> ko chờ nữa -> thực hiện action tiếp theo
	 * Nếu hết thời gian chờ mà điều kiện vẫn ko thỏa mãn -> trả về exception/ empty list (nếu là hàm findElements)
	 * 
	 * --
	 * Ngược lại với nó là static wait (Thread.sleep của java)
	 * Nó sẽ tạm dừng thread đang chạy hiện tại trong một thời gian nhất định
	 * --
	 * Nhược điểm: 
	 * Vì nó ngưng thread trong một thời gian nhất định nên trường hợp đã thỏa mãn điều kiện -> vẫn phải đợi cho đến khi hết sleep -> Tốn thời gian
	 * Luôn stop thread với một tham số nhất định nên trong trường hợp có vde xảy ra với mạng -> cần phải điều chỉnh tăng hoặc giảm sleep theo tương ứng. 
	 * Nếu tăng nhiều quán thì tốn thời gian, mà tăng ít quá thì tỉ lệ fail tăng lên
	 */
	@Test
	public void TC_01_No_Enough_Time() {
		// TH1: Khong du thoi gian element hien thi
		// Result: Fail - 2s
		
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		SleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.cssSelector("div#finish>h4")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	@Test
	public void TC_02_Enough_Time() {
		// TH2: Du thoi gian
		// Result: PASS - 5

		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.cssSelector("div#start>button")).click();
		SleepInSecond(5);
		Assert.assertTrue(driver.findElement(By.cssSelector("div#finish>h4")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}
	
	@Test
	public void TC_03_More_Time() {
		// TH2: Thua thoi gian 
		// Result: PASS - 10 -> Ton thoi gian

		driver.get("https://automationfc.github.io/dynamic-loading/");
		SleepInSecond(10);
		Assert.assertTrue(driver.findElement(By.cssSelector("div#finish>h4")).isDisplayed());
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