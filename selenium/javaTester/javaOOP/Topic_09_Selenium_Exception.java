package javaTester.javaOOP;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class Topic_09_Selenium_Exception {
	WebDriver driver;
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
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void NoSuchElementException() {
		// No element is matching with locator
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname-name")).sendKeys("");
	}
	
	@Test
	public void StaleElementReferenceException() {
		// using the element in the another page
		// after refresh page, we need to find and get element again -> cannot use a element in the 2 page (after refresh)
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		WebElement firstnameTextbox = driver.findElement(By.id("txtFirstname"));
		driver.navigate().refresh();
		firstnameTextbox.sendKeys("ElonMusk");
		
	}
	
	@Test
	public void ElementNotVisibleException() {
		// Element in DOM, but element no visible
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='qualaroo_dnt_frame']"));
	}
	
	@Test
	public void ElementNotInteractableException() {
		// element in DOM, element visible but element is not clickable
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		driver.findElement(By.xpath("//iframe[@id='qualaroo_dnt_frame']")).click();;
		
	}
	
	@Test
	public void NoAlertPrecentException() {
		// No alert 
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		alert = explicitWait.until(ExpectedConditions.alertIsPresent()); //Wait va switch qua luon
		alert.accept();
	}
	
	@Test
	public void InvalidSelectorException() {
		// locator in the xpath type. It not matching with css type
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("//input[@id='name']")).sendKeys("");
	}
	
	@Test
	public void ElementNotSelectableException() {
		// dropdown, checkbox, radio cannot ready for select
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		driver.findElement(By.xpath("//label[text()='Leather trim']//preceding-sibling::input")).click();
		
	}
	
	@Test
	public void NoSuchFrameException() {
		// no frame when switch frame
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content iframe")));
	}
	
	@Test
	public void NoSuchWindowException() {
		// no window when switch window
		driver.get("https://automationfc.github.io/basic-form/index.html");
		SwitchToWindowByTitle("Google");
	}
	
	@Test
	public void SessionNotFoundException() {
		// When click to element -> close window and switch to the previous page.
		// But that is business flow, the driver just occur in the window (which was be closed)
		// so if you doesn't switch to the previous page, the driver cannot action with this window. So the session exception will occurs
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.close();
		driver.findElement(By.id("txtFirstname")).sendKeys("");
	}
	
	@Test
	public void TimeOutException() {
		// When using explicit wait, when the timeout is closed, the expected condition is not true, the timeout exception will occurs
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("txtFirstname")));
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

	
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
