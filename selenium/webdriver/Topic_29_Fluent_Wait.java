package webdriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_29_Fluent_Wait {
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
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		FluentWait<WebElement> fluentElement;
		WebElement countdown = driver.findElement(By.cssSelector("div#javascript_countdown_time"));
		fluentElement = new FluentWait<WebElement>(countdown);
		fluentElement.withTimeout(15, TimeUnit.SECONDS)
			.pollingEvery(100, TimeUnit.MILLISECONDS)
			.ignoring(NoSuchElementException.class)
			.until(new Function<WebElement, Boolean>(){
				public Boolean apply(WebElement element) {
					//check dieu kien countdown = 00
					boolean flag = element.getText().endsWith("00");
					System.out.println("Time = " + element.getText());
					return flag;
				}	
			});
	}

	@Test
	public void TC_02() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("div#start"));
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		FluentWait<WebElement> fluentElement = new FluentWait<WebElement>(helloText);
		fluentElement.withTimeout(6, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
		.until(new Function<WebElement, Boolean>(){
			public Boolean apply(WebElement element) {
				return element.isDisplayed();
			}
		});
	}

	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
