package testng;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listener.ExtendReportListener;

@Listeners(ExtendReportListener.class)
public class Topic_09_Listener {
	public static WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random rand = new Random();
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Register()  {
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
		driver.findElement(By.cssSelector("input#firstname")).sendKeys("Elon");
		driver.findElement(By.cssSelector("input#lastname")).sendKeys("Musk");
		driver.findElement(By.cssSelector("input#email_address")).sendKeys("elonmusk"+ rand.nextInt(99999) +"@gmail.com");
		driver.findElement(By.cssSelector("input#password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input#confirmation")).sendKeys("abc123");
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		
		Assert.assertFalse(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText().contains("Elon Musk"));
		
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
