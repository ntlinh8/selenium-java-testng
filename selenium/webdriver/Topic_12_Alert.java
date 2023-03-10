package webdriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Alert {
	WebDriver driver;
	Alert alert;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String authenFireFox = projectPath + "\\AutoIt\\authen_firefox.exe";
	String authenChrome = projectPath + "\\AutoIt\\authen_chrome.exe";
	String name;
	String username = "admin", password = "admin";
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		name = "Automation FC";
	}

	@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
//		//Cach1: action luon
//		alert = driver.switchTo().alert();
		
		//wait trc roi moi click
		alert = explicitWait.until(ExpectedConditions.alertIsPresent()); //Wait va switch qua luon
		Assert.assertEquals(alert.getText(), "Click for JS Alert");
		alert.accept();
		
		SleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("p#result")).getText().contains("You clicked an alert successfully"));
	}

	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		//wait trc roi moi click
		alert = explicitWait.until(ExpectedConditions.alertIsPresent()); //Wait va switch qua luon
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.accept();
		
		SleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("p#result")).getText().contains("You clicked: Ok"));
	}
	
	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		//wait trc roi moi click
		alert = explicitWait.until(ExpectedConditions.alertIsPresent()); //Wait va switch qua luon
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.sendKeys(name);
		alert.accept();
		
		SleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.cssSelector("p#result")).getText().contains("You entered: " + name));
	}
	
	@Test
	public void TC_04_Authentication_Alert() {
		//Can xoa cache neu ko muon test lai
		
		//Cach 1: truyen user + pass vao url
		//Syntax: http:// + username : password + @the-internet.herokuapp.com/basic_auth
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.get(PassUserNameAndPasswordToURL("http://admin:admin@the-internet.herokuapp.com/basic_auth", "admin" , "admin"));
		SleepInSecond(7);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		
	}
	
	@Test
	public void TC_05_Authentication_Alert() {
		driver.get("https://the-internet.herokuapp.com/");
		String url = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		driver.get(PassUserNameAndPasswordToURL(url, "admin" , "admin"));
		SleepInSecond(7);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		
	}
	
	@Test
	public void TC_06_Authentication_Alert_AUTOIT() throws IOException {
		//Thuc thi mot doan file exe nhung trong command
		if(driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] {authenFireFox, username, password});
		} else if(driver.toString().contains("chrome")) {
			Runtime.getRuntime().exec(new String[] {authenChrome, username, password});
		}
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		SleepInSecond(7);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
	
	public String PassUserNameAndPasswordToURL(String url, String username, String password) {
		String[] tempURL = url.split("//");
		return tempURL[0] + "//" + username + ":" + password + "@" + tempURL[1];
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