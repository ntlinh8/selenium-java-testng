package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_P2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	By myAccount_link = By.xpath("//div[@class='footer']//a[text()='My Account']");
	By createAnAcount_button = By.xpath("//span[text()='Create an Account']");
	
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
	public void TC_01_Verify_URL() {
		driver.get("http://live.techpanda.org/");
		
		//Clicking on the My Account link
		driver.findElement(myAccount_link).click();
		
		//Verifying the current URL is http://live.techpanda.org/index.php/customer/account/login/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		//Clicking on the Create An Account button
		driver.findElement(createAnAcount_button).click();
		
		//Verifying the current URL is http://live.techpanda.org/index.php/customer/account/create/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
	}

	@Test
	public void TC_02_Verify_Title() {
		driver.get("http://live.techpanda.org/");
		
		//Clicking on the My Account link
		driver.findElement(myAccount_link).click();
		
		//Verifying the current title is Customer Login
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		
		//Clicking on the Create An Account button
		driver.findElement(createAnAcount_button).click();
		
		//Verifying the current title is Create New Customer Account
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		
	}
	
	@Test
	public void TC_03_Navigate_Function() {
		driver.get("http://live.techpanda.org/");
		
		//Clicking on the My Account link
		driver.findElement(myAccount_link).click();
		
		//Clicking on the Create An Account button
		driver.findElement(createAnAcount_button).click();
		
		//Verifying the current url is http://live.techpanda.org/index.php/customer/account/create/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
		//Back to the previous page
		Navigation nav = driver.navigate();
		nav.back();
		
		//Verifying the current url is http://live.techpanda.org/index.php/customer/account/login/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		//Forwarding to the next page
		nav.forward();
		
		//Verifying the current title is Create New Customer Account
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_04_Get_Page_Source_Code() {
		driver.get("http://live.techpanda.org/");
		
		//Clicking on the My Account link
		driver.findElement(myAccount_link).click();
		
		//Verifying the login page contains "Login or Create an Account" text
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		//Clicking on the Create An Account button
		driver.findElement(createAnAcount_button).click();

		//Verifying the register page contains "Create an Account" text
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
		
		
	}
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}