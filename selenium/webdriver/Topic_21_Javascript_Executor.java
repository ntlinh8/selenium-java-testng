package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_21_Javascript_Executor {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	String emailAddress;
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		emailAddress = "elonmusk" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_Tech_Panda() {
		navigateToUrlByJS("http://live.techpanda.org/");
		SleepInSecond(7);
		Assert.assertEquals(getDomainName(), "live.techpanda.org");
		Assert.assertEquals(getURL(), "http://live.techpanda.org/");
		
		clickToElementByJS("//a[text()='Mobile']");
		SleepInSecond(7);
		clickToElementByJS("//div[@class='product-info']//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']");
		SleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Samsung Galaxy was added to your shopping cart.");
		
		clickToElementByJS("//a[text()='Customer Service']");
		SleepInSecond(5);
		Assert.assertEquals(getTitle(), "Customer Service");
		
		scrollToElementOnTop("//input[@id='newsletter']");
		sendkeyToElementByJS("//input[@id='newsletter']", emailAddress);
		SleepInSecond(2);
		clickToElementByJS("//button[@title='Subscribe']");
		SleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for your subscription.");
		
		navigateToUrlByJS("https://demo.guru99.com/v4/");
		SleepInSecond(5);
		Assert.assertEquals(getDomainName(), "demo.guru99.com");
	}

	@Test
	public void TC_02_HTML5() {
		navigateToUrlByJS("https://warranty.rode.com/");
		SleepInSecond(7);
		
		String registerButton = "//button[contains(text(),'Register')]";
		String firstnameTextbox = "//input[@id='firstname']";
		String surNameTextbox = "//input[@id='surname']";
		String emailAddressTextbox = "//div[contains(text(),'Register')]/parent::div//input[@id='email']";
		String passwordTextbox = "//div[contains(text(),'Register')]/parent::div//input[@id='password']";
		String confirmPasswordTextbox = "//div[contains(text(),'Register')]/parent::div//input[@id='password-confirm']";
		
		clickToElementByJS(registerButton);
		SleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(firstnameTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(firstnameTextbox, "automation");
		SleepInSecond(2);
		clickToElementByJS(registerButton);
		SleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(surNameTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(surNameTextbox, "testing");
		SleepInSecond(2);
		clickToElementByJS(registerButton);
		SleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(emailAddressTextbox), "Please fill out this field.");
		
		sendkeyToElementByJS(emailAddressTextbox, "he@lo@gmail.com");
		SleepInSecond(2);
		clickToElementByJS(registerButton);
		SleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(emailAddressTextbox), "Please enter an email address.");
		
		sendkeyToElementByJS(emailAddressTextbox, "helo@gmail.com");
		SleepInSecond(2);
		clickToElementByJS(registerButton);
		SleepInSecond(2);
		Assert.assertEquals(getElementValidationMessage(passwordTextbox), "Please fill out this field.");
	}
	
	@Test
	public void TC_03_Remove_Attribute() {
		navigateToUrlByJS("https://demo.guru99.com/v4/");
		SleepInSecond(7);
		sendkeyToElementByJS("//input[@name='uid']", "mngr487044");
		sendkeyToElementByJS("//input[@name='password']", "qarYvap");
		clickToElementByJS("//input[@name='btnLogin']");
		SleepInSecond(3);
		
		clickToElementByJS("//a[text()='New Customer']");
		SleepInSecond(10);
		
		sendkeyToElementByJS("//input[@name='name']", "Elon Musk");
		removeAttributeInDOM("//input[@name='dob']", "type");
		sendkeyToElementByJS("//input[@name='dob']", "23/01/1994");
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Nguyen Chi Thanh, Ba Dinh, Ha Noi");
		sendkeyToElementByJS("//input[@name='city']", "Ha Noi");
		sendkeyToElementByJS("//input[@name='state']", "Ha Noi");
		sendkeyToElementByJS("//input[@name='pinno']", "100000");
		sendkeyToElementByJS("//input[@name='telephoneno']", "0123456789");
		sendkeyToElementByJS("//input[@name='emailid']", emailAddress);
		sendkeyToElementByJS("//input[@name='password']", "abc123!@#");
		clickToElementByJS("//input[@value='Submit']");
		SleepInSecond(5);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed());
		
	}
	
	@Test
	public void TC_04_Create_An_Account() {
		navigateToUrlByJS("http://live.techpanda.org/");
		SleepInSecond(7);

		clickToElementByJS("//div[@id='header-account']//a[text()='My Account']");
		SleepInSecond(5);
		
		clickToElementByJS("//span[text()='Create an Account']");
		SleepInSecond(5);
		
		sendkeyToElementByJS("//input[@id='firstname']", "Elon");
		sendkeyToElementByJS("//input[@id='lastname']", "Musk");
		sendkeyToElementByJS("//input[@id='email_address']", emailAddress);
		sendkeyToElementByJS("//input[@id='password']", "Abc123!@#");
		sendkeyToElementByJS("//input[@id='confirmation']", "Abc123!@#");
		clickToElementByJS("//span[text()='Register']");
		SleepInSecond(5);
		Assert.assertTrue(areExpectedTextInInnerText("Thank you for registering with Main Website Store."));
		SleepInSecond(2);
		clickToElementByJS("//div[@id='header-account']//a[text()='Log Out']");
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='page-title']")));
	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}
	
	public String getDomainName() {
		return (String) jsExecutor.executeScript("return document.domain;");
	}
	
	public String getURL() {
		return (String) jsExecutor.executeScript("return document.URL;");
	}
	
	public String getTitle() {
		return (String) jsExecutor.executeScript("return document.title;");
	}
	
	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
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

	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}