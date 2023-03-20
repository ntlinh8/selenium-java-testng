package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Window_Tab {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	Alert alert;
	WebDriverWait explicitWait;
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
		jsExecutor = (JavascriptExecutor) driver;
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Tab() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		// Open new Google tab
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		SleepInSecond(2);

		// Switch to google tab and verify
		SwitchToWindowByTitle("Google");
		Assert.assertEquals(driver.getTitle(), "Google");

		// Back to default tab
		SwitchToWindowByTitle("Selenium WebDriver");

		// Open the facebook tab -> switch to facebook tab and verify the title
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		SwitchToWindowByTitle("Facebook – log in or sign up");
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

		// Back to default tab
		SwitchToWindowByTitle("Selenium WebDriver");
		
		// Open the tiki tab -> switch to tiki tab and verify the title
		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		SwitchToWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			driver.switchTo().window(id);
			SleepInSecond(2);
			System.out.println(driver.getTitle());
			if (!driver.getTitle().equals("Selenium WebDriver")) {
				SleepInSecond(2);
				driver.close();
			}
		}
		SwitchToWindowByTitle("Selenium WebDriver");
		Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");
	}

//	@Test
	public void TC_02_Tab() {
		driver.get("https://skills.kynaenglish.vn/");
		
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.cssSelector("div#k-footer div.social img[alt='facebook']")).click();
		driver.findElement(By.cssSelector("div#k-footer div.social img[alt='youtube']")).click();
		
		SwitchToWindowByTitle("Kyna.vn - Home | Facebook");
		Assert.assertEquals(driver.getTitle(), "Kyna.vn - Home | Facebook");
		
		SwitchToWindowByTitle("Kyna.vn - YouTube");
		Assert.assertEquals(driver.getTitle(), "Kyna.vn - YouTube");
		
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			driver.switchTo().window(id);
			SleepInSecond(2);
			System.out.println(driver.getTitle());
			if (!driver.getTitle().equals("Kyna.vn - Học online cùng chuyên gia")) {
				SleepInSecond(2);
				driver.close();
			}
		}
		SwitchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
		Assert.assertEquals(driver.getTitle(), "Kyna.vn - Học online cùng chuyên gia");
	}
	
//	@Test
	public void TC_03_Window() {
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		
		driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product IPhone has been added to comparison list.");
		driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
	
		SwitchToWindowByTitle("Products Comparison List - Magento Commerce");
		Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
		driver.close();
		SwitchToWindowByTitle("Mobile");
		
		driver.findElement(By.xpath("//a[text()='Clear All']")).click();
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(alert.getText(), "Are you sure you would like to remove all products from your comparison?");
		alert.accept();
		SleepInSecond(4);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The comparison list was cleared.");
	}
	
	@Test
	public void TC_04_Windown() {
		driver.get("https://dictionary.cambridge.org/vi/");
		driver.findElement(By.xpath("//div[@class='hdn hdib-s']//span[text()='Đăng nhập']")).click();
		SwitchToWindowByTitle("Login");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Log in with your email account']/parent::div//span[@data-bound-to='loginID']")).getText(), "This field is required");
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Log in with your email account']/parent::div//span[@data-bound-to='password']")).getText(), "This field is required");
		driver.close();
		SwitchToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");
		driver.findElement(By.cssSelector("input#searchword")).sendKeys("automation");
		driver.findElement(By.xpath("//button[@title='Tìm kiếm']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(@class,'superentry')]")).getText().contains("automation"));
	}

	public void SwitchToWindowByTitle(String targetTitle) {
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			driver.switchTo().window(id);
			SleepInSecond(2);
			if (driver.getTitle().equals(targetTitle)) {
				SleepInSecond(2);
				break;
			}
		}
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