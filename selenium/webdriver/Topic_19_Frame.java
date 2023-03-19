package webdriver;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Frame {
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

	@Test
	public void TC_01_iFrame() {
		driver.get("https://skills.kynaenglish.vn/");
		
		//Verify facebook iframe hien thi, vi iframe nay van thuoc kyna nen verify bthg
		Assert.assertTrue(driver.findElement(By.cssSelector("div.face-content iframe")).isDisplayed());
		
		//Switch vao iframe
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content iframe")));
		
		//verify like number of facebook page
		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText(), "165K likes");
		
		//back to main page and switch to another iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#cs_chat_iframe")));
		
		driver.findElement(By.cssSelector("div.button_bar")).click();
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Nguyen Thuy Linh");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0123456789");
		new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Java Bootcamp");
		
		//back to main page
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
		driver.findElement(By.cssSelector("button.search-button")).click();
		SleepInSecond(5);
		
		List<WebElement> courseNameList = driver.findElements(By.cssSelector("div.content h4"));
		for (WebElement name : courseNameList) {
			Assert.assertTrue(name.getText().contains("Excel"));
		}
		
	}

	@Test
	public void TC_02_Frame() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='login_page']")));
		driver.findElement(By.xpath("//div[text()='Customer ID/ User ID']/following-sibling::div/input")).sendKeys("automationtest");
		driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();
		SleepInSecond(5);
		
		driver.switchTo().defaultContent();
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Password/IPIN']/following-sibling::md-input-container")).isDisplayed());
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