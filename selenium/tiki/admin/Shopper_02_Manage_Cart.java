package tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopper_02_Manage_Cart {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	/*
	 * Knowledge
	 * Neu co before test and after test thi khi run truc tiep file java -> van run qua before and after
	 * Neu run bang XML thi ko run qua -> can set alwaysRun =true
	 */
	@BeforeTest(alwaysRun = true)
	public void initBrowser() {
		System.out.println("initBrowser");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	@Test(groups={"admin", "cart"})
	public void Card_01_Create_Cart() {
	}

	@Test(groups={"admin", "cart"})
	public void Card_02_View_Cart() {
	}

	@Test(groups={"admin", "cart"})
	public void Card_03_Update_Cart() {
	}

	@Test(groups={"admin", "cart"})
	public void Card_04_Delete_Cart() {
	}
	
	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		System.out.println("closeBrowser");
		driver.quit();
	}
}
