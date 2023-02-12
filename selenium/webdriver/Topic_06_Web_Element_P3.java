package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_P3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, fullName, email, password;
	
	By myAccountLink = By.xpath("//div[@class='footer']//a[@title='My Account']");
	By emailTextbox = By.xpath("//input[@id='email']");
	By passwordTextbox = By.xpath("//input[@id='pass']");
	By loginButton = By.xpath("//span[text()='Login']");
	By emailErrorMessage = By.xpath("//label[text()='Email Address']//following-sibling::div/div");
	By passwordErrorMessage = By.xpath("//label[text()='Password']//following-sibling::div/div");
	

	By createAnAccountButton = By.xpath("//span[text()='Create an Account']");
	By firstnameTextbox = By.cssSelector("input#firstname");
	By lastnameTextbox = By.id("lastname");
	By emailAddressTextbox = By.cssSelector("input#email_address");
	By newPasswordTextbox = By.cssSelector("input#password");
	By confirmPasswordTextbox = By.cssSelector("input#confirmation");
	By registerButton = By.xpath("//span[text()='Register']");
	
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
		
		Random rand = new Random();
		firstName = "Linh";
		lastName = "Nguyen";
		fullName = firstName + " " + lastName;
		email = "linh" + rand.nextInt(99999) + "@gmail.com";
		password = "123456";
	}

	@Test
	public void TC_01_Login_With_Empty_Email_And_Password() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(myAccountLink).click();
		SleepInSecond(2);
		
		driver.findElement(emailTextbox).sendKeys("");
		driver.findElement(passwordTextbox).sendKeys("");
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(emailErrorMessage).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(passwordErrorMessage).getText(), "This is a required field.");
	}
	
	@Test
	public void TC_02_Login_With_Invalid_Email() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(myAccountLink).click();
		SleepInSecond(2);
		
		driver.findElement(emailTextbox).sendKeys("1232142@1231232.12312");
		driver.findElement(passwordTextbox).sendKeys("123456");
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(emailErrorMessage).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_Login_With_Password_Less_6_Characters() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(myAccountLink).click();
		SleepInSecond(2);
		
		driver.findElement(emailTextbox).sendKeys("automation@gmail.com");
		driver.findElement(passwordTextbox).sendKeys("123");
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(passwordErrorMessage).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_Login_With_Incorrect_Email_Or_Password() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(myAccountLink).click();
		driver.findElement(emailTextbox).sendKeys("automation@gmail.com");
		driver.findElement(passwordTextbox).sendKeys("123123123");
		driver.findElement(loginButton).click();
		
		driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).isDisplayed();
	}
	
	@Test
	public void TC_05_Create_A_New_Account() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(myAccountLink).click();
		SleepInSecond(2);
		driver.findElement(createAnAccountButton).click();
		SleepInSecond(2);
		
		//Enter the user information
		driver.findElement(firstnameTextbox).sendKeys(firstName);
		driver.findElement(lastnameTextbox).sendKeys(lastName);
		driver.findElement(emailAddressTextbox).sendKeys(email);
		driver.findElement(newPasswordTextbox).sendKeys(password);
		driver.findElement(confirmPasswordTextbox).sendKeys(password);
		driver.findElement(registerButton).click();
		
		//Veridfy register successful
		driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed();
		String contactInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div//following-sibling::div//p")).getText();
		Assert.assertTrue(contactInformation.contains(fullName));
		Assert.assertTrue(contactInformation.contains(email));
		
		//Log out
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		SleepInSecond(6);
		driver.findElement(By.xpath("//img[contains(@src, 'logo.png')]")).isDisplayed();
		
	}
	
	@Test
	public void TC_06_Login_With_New_Account() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(myAccountLink).click();
		SleepInSecond(2);
		
		driver.findElement(emailTextbox).sendKeys(email);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(loginButton).click();
		
		String contactInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div//following-sibling::div//p")).getText();
		Assert.assertTrue(contactInformation.contains(fullName));
		Assert.assertTrue(contactInformation.contains(email));
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