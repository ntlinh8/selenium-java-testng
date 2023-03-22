package webdriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_23_Upload_File_AutoIT {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	String duckFile = "duck.jpg";
	String mountainFile = "mountain.jpg";
	String treeFile = "tree.jpg";
	
	String duckFilePath = projectPath + "\\uploadFile\\" + duckFile;
	String mountainFilePath = projectPath + "\\uploadFile\\" + mountainFile;
	String treeFilePath = projectPath + "\\uploadFile\\" + treeFile;
	
	String autoITChromeUploadOneTime = projectPath + "\\AutoIT\\chromeUploadOneTime.exe";
	String autoITFireFoxUploadOneTime = projectPath + "\\AutoIT\\firefoxUploadOneTime.exe";
	String autoITChromeUploadMultiple = projectPath + "\\AutoIT\\chromeUploadMultiple.exe";
	String autoITFireFoxUploadMultiple = projectPath + "\\AutoIT\\firefoxUploadMultiple.exe";
	
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

//	@Test
	public void TC_01_One_File_Per_Time() throws IOException {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		//Click on start button
		driver.findElement(By.xpath("//span[@class='btn btn-success fileinput-button']")).click();
		
		//run AutoIT script
		if (driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] {autoITFireFoxUploadOneTime, duckFilePath});
		} else {
			Runtime.getRuntime().exec(new String[] {autoITChromeUploadOneTime, duckFilePath});
		}
		
		
		//Verify the name file
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + duckFile + "']")).isDisplayed());
		
		//Click Upload button
		driver.findElement(By.xpath("//table[contains(@class,'table')]//span[text()='Start']")).click();
		SleepInSecond(5);
		
		//Verify the upload successful
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + duckFile + "']")).isDisplayed());
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + duckFile + "')]"));
	}

	@Test
	public void TC_02_Mutiple_File_Per_Time() throws IOException {
		/*
		 * Neu co attribute la multiple thi moi co the upload nhieu file trong mot lan
		 */
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		///Click on start button
		driver.findElement(By.xpath("//span[@class='btn btn-success fileinput-button']")).click();
		
		//run AutoIT script
		if (driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] {autoITFireFoxUploadMultiple, duckFilePath, mountainFilePath, treeFilePath});
		} else {
			Runtime.getRuntime().exec(new String[] {autoITChromeUploadMultiple, duckFilePath, mountainFilePath, treeFilePath});
		}
		
		SleepInSecond(2);
		
		//Verify the name file
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + duckFile + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + mountainFile + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + treeFile + "']")).isDisplayed());
		
		//Click Upload button
		List<WebElement> uploadButton = driver.findElements(By.xpath("//table[contains(@class,'table')]//span[text()='Start']"));
		for (WebElement button : uploadButton) {
			button.click();
			SleepInSecond(2);
		}
		
		//Verify the upload successful
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + duckFile + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + mountainFile + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + treeFile + "']")).isDisplayed());
		
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + duckFile + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + mountainFile + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + treeFile + "')]"));
	}

	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}