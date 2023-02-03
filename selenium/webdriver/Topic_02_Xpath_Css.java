package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css {
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
	public void TC_01_Register_With_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thuy Linh");
		driver.findElement(By.id("txtEmail")).sendKeys("123@456@789@");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@456@789@");
		driver.findElement(By.id("txtPassword")).sendKeys("abc123");
		driver.findElement(By.id("txtCPassword")).sendKeys("abc123");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
	}
	
	@Test
	public void TC_03_Register_With_Incorrect_Confirm_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thuy Linh");
		driver.findElement(By.id("txtEmail")).sendKeys("linh@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("linh12@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("abc123");
		driver.findElement(By.id("txtCPassword")).sendKeys("abc123");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_04_Register_With_Password_Less_Than_Six_Chars() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thuy Linh");
		driver.findElement(By.id("txtEmail")).sendKeys("linh@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("linh@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("abc");
		driver.findElement(By.id("txtCPassword")).sendKeys("abc");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void TC_05_Register_With_Incorrect_Confirm_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thuy Linh");
		driver.findElement(By.id("txtEmail")).sendKeys("linh@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("linh@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("abc123");
		driver.findElement(By.id("txtCPassword")).sendKeys("abc124");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void TC_06_Register_With_Invalid_Phone_Number() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thuy Linh");
		driver.findElement(By.id("txtEmail")).sendKeys("linh@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("linh@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("abc123");
		driver.findElement(By.id("txtCPassword")).sendKeys("abc123");
		
		//Less than 10 chars
		driver.findElement(By.id("txtPhone")).sendKeys("0123");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//More than 10 chars
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("01234567895556");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//More than 10 chars
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("8955");
		driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
	}
	
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}