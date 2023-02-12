package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_P2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	By emailTextbox = By.xpath("//input[@id='mail']");
	By ageTitle = By.xpath("//label[text()='Age:']");
	By ageUnder18RadioButton = By.id("under_18");
	By educationTextArea = By.id("edu");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By jobRole1Dropdown = By.xpath("//select[@id='job1']");
	By developmentCheckbox = By.xpath("//label[text()='Development']");
	By slider1 = By.xpath("//input[@id='slider-1']");
	By passWordTextbox = By.xpath("//input[@id='disable_password']");
	By radioButton = By.xpath("//input[@id='radio-disabled']");
	By bioTextArea = By.xpath("//textarea[@id='bio']");
	By jobRole3Drowdown = By.xpath("//select[@id='job3']");
	By disableCheckbox = By.xpath("//input[@id='check-disbaled']");
	By slider2 = By.xpath("//input[@id='slider-2']");
	By javaLanguageCheckbox = By.cssSelector("input#java");
	
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
	public void TC_01_Verifying_Element_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email Textbox
		if(driver.findElement(emailTextbox).isDisplayed()) {
			driver.findElement(emailTextbox).sendKeys("Automation Testing");
			System.out.println("Email Textbox is displayed");
		}else {
			System.out.println("Email Textbox is NOT displayed");
		}
		
		//Age Under 18 Radio Button
		if(driver.findElement(ageUnder18RadioButton).isDisplayed()) {
			driver.findElement(ageUnder18RadioButton).click();
			System.out.println("Age Under 18 Radio Button is displayed");
		}else {
			System.out.println("Age Under 18 Radio Button is NOT displayed");
		}
		
		//Education TextArea
		if(driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Automation Testing");
			System.out.println("Education TextArea is displayed");
		}else {
			System.out.println("Education TextArea is NOT displayed");
		}
				
		//Name User 5
		if(driver.findElement(nameUser5Text).isDisplayed()) {
			System.out.println("Name User 5 is displayed");
		}else {
			System.out.println("Name User 5 is NOT displayed");
		}
		
	}

	@Test
	public void TC_02_Verifying_Element_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(driver.findElement(emailTextbox).isEnabled()) {
			System.out.println("Email Textbox is enabled");
		}else {
			System.out.println("Email Textbox is NOT enabled");
		}
		
		if(driver.findElement(ageTitle).isEnabled()) {
			System.out.println("Age Radio Button is enabled");
		}else {
			System.out.println("Age Radio Button is NOT enabled");
		}
		
		if(driver.findElement(ageTitle).isEnabled()) {
			System.out.println("Age Radio Button is enabled");
		}else {
			System.out.println("Age Radio Button is NOT enabled");
		}

		if(driver.findElement(educationTextArea).isEnabled()) {
			System.out.println("Education TextArea is enabled");
		}else {
			System.out.println("Education TextArea is NOT enabled");
		}
		
		if(driver.findElement(jobRole1Dropdown).isEnabled()) {
			System.out.println("Job Role 1 is enabled");
		}else {
			System.out.println("Job Role 1 is NOT enabled");
		}
		
		if(driver.findElement(developmentCheckbox).isEnabled()) {
			System.out.println("Development Checkbox is enabled");
		}else {
			System.out.println("Development Checkbox is NOT enabled");
		}

		if(driver.findElement(slider1).isEnabled()) {
			System.out.println("Slider 1 is enabled");
		}else {
			System.out.println("Slider 1 is NOT enabled");
		}
		
		if(driver.findElement(passWordTextbox).isEnabled()) {
			System.out.println("Password Textbox is enabled");
		}else {
			System.out.println("Password Textbox is NOT enabled");
		}
		
		if(driver.findElement(radioButton).isEnabled()) {
			System.out.println("Radio Button is enabled");
		}else {
			System.out.println("Radio Button is NOT enabled");
		}
		
		if(driver.findElement(bioTextArea).isEnabled()) {
			System.out.println("Radio Button is enabled");
		}else {
			System.out.println("Radio Button is NOT enabled");
		}
		
		if(driver.findElement(jobRole3Drowdown).isEnabled()) {
			System.out.println("Job 3 Dropdown is enabled");
		}else {
			System.out.println("Job 3 Dropdown is NOT enabled");
		}
		
		if(driver.findElement(disableCheckbox).isEnabled()) {
			System.out.println("Job 3 Dropdown is enabled");
		}else {
			System.out.println("Job 3 Dropdown is NOT enabled");
		}
		
		if(driver.findElement(slider2).isEnabled()) {
			System.out.println("Slider 2 is enabled");
		}else {
			System.out.println("Slider 2 is NOT enabled");
		}
	}
	
	@Test
	public void TC_03_Verifying_Element_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(ageUnder18RadioButton).click();
		driver.findElement(javaLanguageCheckbox).click();		
		
		Assert.assertTrue(driver.findElement(ageUnder18RadioButton).isSelected());
		Assert.assertTrue(driver.findElement(javaLanguageCheckbox).isSelected());
		
		driver.findElement(javaLanguageCheckbox).click();		
		Assert.assertFalse(driver.findElement(javaLanguageCheckbox).isSelected());
		
		if(driver.findElement(ageUnder18RadioButton).isSelected()) {
			System.out.println("Age Under 18 Radio button is selected");
		}else {
			System.out.println("Age Under 18 Radio button is NOT selected");
		}
		
		if(driver.findElement(javaLanguageCheckbox).isSelected()) {
			System.out.println("Java Language Checkbox is selected");
		}else {
			System.out.println("Java Language Checkbox is NOT selected");
		}
	}
	
	@Test
	public void TC_04_Register_Function_At_MailChimp(){
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("thuylinhnguyen.hust@gmail.com");
		By passwordTextbox = By.cssSelector("input#new_password");
		driver.findElement(passwordTextbox).sendKeys("123");

		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("aaa");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("AAA");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("!@#");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("abcdefghisdf");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
	}
	
	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}