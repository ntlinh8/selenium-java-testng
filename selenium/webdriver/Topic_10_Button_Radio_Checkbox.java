package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

public class Topic_10_Button_Radio_Checkbox {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Button() {
		/*
		 * https://www.selenium.dev/documentation/webdriver/support_features/colors/
		 */
		
		driver.get("https://www.fahasa.com/customer/account/create");
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		
		//Verify button is disable
		By loginButton = By.cssSelector("button.fhs-btn-login");
		Assert.assertFalse(driver.findElement(loginButton).isEnabled());
		Assert.assertTrue(driver.findElement(loginButton).getCssValue("background-image").contains("rgb(224, 224, 224)"));
		
		driver.findElement(By.id("login_username")).sendKeys("0123456789");
		driver.findElement(By.id("login_password")).sendKeys("123123123");
		
		//Verify button is enable and color is C92127
		Assert.assertTrue(driver.findElement(loginButton).isEnabled());
		Color loginButtonColor = Color.fromString(driver.findElement(loginButton).getCssValue("background-color"));
		Assert.assertEquals(loginButtonColor.asHex().toUpperCase(), "#C92127");
		
	}

	@Test
	public void TC_02_Default_Checkbox_Radio() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		SleepInSecond(3);
		
		//Select and verify the checkbox is selected
		driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::input")).isSelected());
		
		//UnSelect and verify the checkbox is unselected
		driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::input")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::input")).isSelected());
		
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		
		driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']//preceding-sibling::input")).click();
		if(!driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']//preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']//preceding-sibling::input")).click();
		}
		
	}
	
	@Test
	public void TC_03_Custom_Checkbox_Radio_Angular_Material() {
		driver.get("https://material.angular.io/components/radio/examples");
		
		driver.findElement(By.xpath("//label[contains(text(), 'Summer')]/preceding-sibling::div/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(), 'Summer')]/preceding-sibling::div/input")).isSelected());
		
		driver.get("https://material.angular.io/components/checkbox/examples");
		
		driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input")).isSelected());
		driver.findElement(By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input")).isSelected());
		
		driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input")).isSelected());
		driver.findElement(By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input")).isSelected());
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