package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Default_Dropdown {
	WebDriver driver;
	Select dateOfBirth, monthOfBirth, yearOfBirth;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, emailAddress, companyName, password, day, month, year;
	String countryName, provinceName, cityName, addressName, postalCode, phoneNumber;
	
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
		//Format code: Ctrl + Shift + F
		firstName = "Elon";
		lastName = "Musk";
		emailAddress = "elonmusk" + getRandomNumber() + "@gmail.com";
		companyName = "Tesla";
		password = "abc123123";
		day = "1";
		month = "May";
		year = "1980";
		countryName = "United States";
		provinceName = "AA (Armed Forces Americas)";
		cityName = "Miamy";
		addressName = "123 Bo Pox";
		postalCode = "33111";
		phoneNumber = "+13055555584";
	}
	/*
	 * co the select by value (value can truyen la string), co the select by index (index la int)
	 * select bang text (text la string)
	 * uu nhuoc diem khi dung 3 loai select
	 * 1. Index se bi thay doi neu option list co the thay doi
	 * Khó match giữa index và giá trị của option -> Trong trường hợp fail, manual test lại khó
	 * 2. value là giá trị option, có thể có hoặc không
	 * value chưa chắc đã giống giá trị của option (có thể là 1 id trong database lấy lên) -> khó match giữa index và giá trị option -> khó manual test lại
	 * 3. Text
	 * Thêm sửa xóa vẫn ổn định
	 * manual test rất dễ
	 * 
	 */
	//Ham verify la getFirstSelectedOption, boi vi sau khi chon 1 option, gia tri do se hien len dau tien -> verify da chon thanh cong
	// Ham getOption -> tra ra mot list cac option
	// isMultiple -> true: neu dropdown la multiple va nguoc lai
	
	@Test
	public void TC_01_Register_New_Account() {
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		SleepInSecond(5);
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);

		new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(day);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getOptions().size(), 32);
		new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getOptions().size(), 13);
		new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getOptions().size(), 112);
		
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		driver.findElement(By.id("register-button")).click();
		SleepInSecond(3);
		
		//Verify register completed
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		//Login with new account
		driver.findElement(By.cssSelector("a.ico-login")).click();
		SleepInSecond(3);
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		SleepInSecond(3);
		
		//Go to My Account tab
		driver.findElement(By.cssSelector("a.ico-account")).click();
		SleepInSecond(3);
		
		//Verify the account information
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);		
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);		
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);
		
	}

	@Test
	public void TC_02_Add_Address() {
		//Click address tab
		driver.findElement(By.cssSelector("li.customer-addresses.inactive>a")).click();
		SleepInSecond(5);
		
		//add new address
		driver.findElement(By.xpath("//button[text()='Add new']")).click();
		SleepInSecond(5);
		driver.findElement(By.id("Address_FirstName")).sendKeys(firstName);
		driver.findElement(By.id("Address_LastName")).sendKeys(lastName);
		driver.findElement(By.id("Address_Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Address_Company")).sendKeys(companyName);
		new Select(driver.findElement(By.id("Address_CountryId"))).selectByVisibleText(countryName);
		new Select(driver.findElement(By.id("Address_StateProvinceId"))).selectByVisibleText(provinceName);
		driver.findElement(By.id("Address_City")).sendKeys(cityName);
		driver.findElement(By.id("Address_Address1")).sendKeys(addressName);
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(postalCode);
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		SleepInSecond(5);
		
		//Verify add new address completed
		Assert.assertEquals(driver.findElement(By.className("name")).getText(), firstName+ " " + lastName);
		Assert.assertTrue(driver.findElement(By.className("email")).getText().contains(emailAddress));
		Assert.assertTrue(driver.findElement(By.className("phone")).getText().contains(phoneNumber));
		Assert.assertEquals(driver.findElement(By.className("address1")).getText(), addressName);
		Assert.assertEquals(driver.findElement(By.className("city-state-zip")).getText(), cityName+ ", " + provinceName + ", " + postalCode);
		Assert.assertEquals(driver.findElement(By.className("country")).getText(), countryName);
	}
	
	@Test
	public void TC_03_WhereToBuy() {
		driver.get("https://rode.com/en/support/where-to-buy");
		SleepInSecond(10);
		
		//Verify the dropdown is Not multiple dropdown
		Assert.assertFalse(new Select(driver.findElement(By.id("country"))).isMultiple());

		new Select(driver.findElement(By.id("country"))).selectByVisibleText("Vietnam");
		Assert.assertEquals(new Select(driver.findElement(By.id("country"))).getFirstSelectedOption().getText(), "Vietnam");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Assert.assertEquals(driver.findElements(By.cssSelector("div.align-self-stretch")).size(), 49);
		
		List<WebElement> searchResults = driver.findElements(By.cssSelector("div.align-self-stretch h4"));
		for (WebElement webElement : searchResults) {
			System.out.println(webElement.getText());
		}
	}
	
	@Test
	public void TC_04_Applitool() {
		driver.get("https://applitools.com/automating-tests-chrome-devtools-recorder-webinar/");
		
		//Choose the role and verify select success
		new Select(driver.findElement(By.id("Person_Role__c"))).selectByVisibleText("SDET / Test Automation Engineer");
		Assert.assertEquals(new Select(driver.findElement(By.id("Person_Role__c"))).getFirstSelectedOption().getText(), "SDET / Test Automation Engineer");
		
		//Choose the Framework and verify select success
		new Select(driver.findElement(By.id("Test_Framework__c"))).selectByVisibleText("TestCafe");
		Assert.assertEquals(new Select(driver.findElement(By.id("Test_Framework__c"))).getFirstSelectedOption().getText(), "TestCafe");
		
		//Choose the Country and verify select success
		new Select(driver.findElement(By.id("Self_Report_Country__c"))).selectByVisibleText("Australia");
		Assert.assertEquals(new Select(driver.findElement(By.id("Self_Report_Country__c"))).getFirstSelectedOption().getText(), "Australia");
	}
	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(99999);
		return randomNumber;
	}
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}