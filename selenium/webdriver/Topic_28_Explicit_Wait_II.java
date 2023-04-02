package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Explicit_Wait_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	String duckFile = "duck.jpg";
	String mountainFile = "mountain.jpg";
	String treeFile = "tree.jpg";
	String duckFilePath = projectPath + "\\uploadFile\\" + duckFile;
	String mountainFilePath = projectPath + "\\uploadFile\\" + mountainFile;
	String treeFilePath = projectPath + "\\uploadFile\\" + treeFile;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Telerik() {
		// Result: Pass - hon 30s
		// ton thoi gian tai step wait cho element loading invisiable, do sau khi no bien mat, ko con trong DOM nen ton 30s de tim element, sau do moi check invisiable
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.calendarContainer")));
		System.out.println(driver.findElement(By.xpath("//legend[text()='Selected Dates:']/following-sibling::div/span")).getText());
		
		driver.findElement(By.xpath("//div[@class='rcMain']//tbody//a[text()='31']")).click();
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id, 'RadAjaxLoadingPanel1ctl00')]/div[@class='raDiv']")));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rcMain']//tbody//td[@class='rcSelected']/a[text()='31']")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//legend[text()='Selected Dates:']/following-sibling::div/span")).getText(), "Friday, March 31, 2023");
	}

	@Test
	public void TC_02_Go_File() {
		driver.get("https://gofile.io/welcome");
		
		driver.findElement(By.xpath("//button[contains(text(), 'Upload Files')]")).click();
		driver.findElement(By.cssSelector("input#filesUploadInput")).sendKeys(duckFilePath + "\n" + mountainFilePath + "\n" + treeFilePath);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-auto text-center']/div[text()='Your files have been successfully uploaded']")));
		
		driver.findElement(By.xpath("//div[contains(@class,'mainUploadSuccessLink')]//a")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + duckFile + "']/parent::a/parent::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Play']")));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + duckFile + "']/parent::a/parent::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Download']")));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + mountainFile + "']/parent::a/parent::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Play']")));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + mountainFile + "']/parent::a/parent::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Download']")));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + treeFile + "']/parent::a/parent::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Play']")));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + treeFile + "']/parent::a/parent::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Download']")));
		
	}
	
	@Test
	public void TC_03() {
		
	}
	
	@Test
	public void TC_04() {
		
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