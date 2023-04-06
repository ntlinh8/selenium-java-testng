package webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_29_Fluent_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	long totalTime = 10;
	long unitTime = 100;
	FluentWait<WebDriver> fluentDriver;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		FluentWait<WebElement> fluentElement;
		WebElement countdown = driver.findElement(By.cssSelector("div#javascript_countdown_time"));
		fluentElement = new FluentWait<WebElement>(countdown);
		fluentElement.withTimeout(Duration.ofMinutes(totalTime))
			.pollingEvery(Duration.ofMillis(unitTime))
			.ignoring(NoSuchElementException.class)
			.until(new Function<WebElement, Boolean>(){
				public Boolean apply(WebElement element) {
					//check dieu kien countdown = 00
					boolean flag = element.getText().endsWith("02");
					System.out.println("Time = " + element.getText());
					return flag;
				}	
			});
	}

	@Test
	public void TC_02() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		findElement("//div[@id='start']/button").click();
		Assert.assertTrue(findElement("//h4[text()='Hello World!']").isDisplayed());
	}
	
	public WebElement findElement(String locator) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		fluentDriver.withTimeout(Duration.ofMinutes(totalTime)).pollingEvery(Duration.ofMillis(unitTime)).ignoring(NoSuchElementException.class);
		return (WebElement) fluentDriver.until(new Function<WebDriver, WebElement>(){
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});
	}

	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
