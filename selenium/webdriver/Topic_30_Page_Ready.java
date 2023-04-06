package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_30_Page_Ready {
	WebDriver driver;
	Actions action;
	FluentWait<WebElement> fluentWait;
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
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void TC_01() {
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//Cach 1: check loading button is invisible
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
		
		//Cach 2: Check page ready
		isPageLoadedSuccess();
		Assert.assertTrue(driver.findElement(By.cssSelector("li.nav-item.dropdown")).isDisplayed());
	}
	
	@Test
	public void TC_02() {
		driver.get("https://blog.testproject.io/");
		action.moveToElement(driver.findElement(By.cssSelector("aside#secondary input.search-field"))).perform();
		isPageLoadedSuccess();
		driver.findElement(By.cssSelector("aside#secondary input.search-field")).sendKeys("Selenium");
		driver.findElement(By.cssSelector("aside#secondary span.glass")).click();
		List<WebElement> listTitleElement = driver.findElements(By.cssSelector("h3.post-title>a"));
		for (WebElement titleElement : listTitleElement) {
			Assert.assertTrue(titleElement.getText().contains("Selenium"));
		}
	}
	
	public boolean isPageLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active ===0);");
			}
		};
		
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
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
