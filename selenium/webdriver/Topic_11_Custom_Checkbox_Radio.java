package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Custom_Checkbox_Radio {
	WebDriver driver;
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
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		SleepInSecond(4);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@data-value='Cần Thơ']")).getAttribute("aria-checked"), "false");
		
		driver.findElement(By.xpath("//div[@data-value='Cần Thơ']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value='Cần Thơ'][@aria-checked='true']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@data-value='Cần Thơ']")).getAttribute("aria-checked"), "true");
		
	}

	@Test
	public void TC_02() {
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		
		jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input")));
		SleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input")).isSelected());
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