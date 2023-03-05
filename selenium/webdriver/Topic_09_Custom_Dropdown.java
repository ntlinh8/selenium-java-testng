package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	
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
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Jquery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		SelectDropDown("#speed-button", "#speed-menu div", "Fast");
		Assert.assertEquals(driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-text")).getText(), "Fast");
		
		SelectDropDown("#speed-button", "#speed-menu div", "Faster");
		Assert.assertEquals(driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-text")).getText(), "Faster");
		
		SelectDropDown("#speed-button", "#speed-menu div", "Medium");
		Assert.assertEquals(driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-text")).getText(), "Medium");

	}

	@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		SelectDropDown("i.dropdown.icon", "div.menu span", "Elliot Fu");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Elliot Fu");
		
		SelectDropDown("i.dropdown.icon", "div.menu span", "Jenny Hess");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Jenny Hess");
		
		SelectDropDown("i.dropdown.icon", "div.menu span", "Justen Kitsune");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Justen Kitsune");
	}
	
	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		SelectDropDown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText().trim(), "Second Option");
		
		SelectDropDown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText().trim(), "First Option");
		
	}
	
	@Test
	public void TC_04_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		EnterAndSelectDropDown("input.search", "div.menu span", "Algeria");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText().trim(), "Algeria");
		
		EnterAndSelectDropDown("input.search", "div.menu span", "Belize");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText().trim(), "Belize");
		
		EnterAndSelectDropDown("input.search", "div.menu span", "American Samoa");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText().trim(), "American Samoa");
	}
	
	public void SelectDropDown(String parentCSS, String optionCSS, String expectedItem) {
		driver.findElement(By.cssSelector(parentCSS)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(optionCSS)));
		
		List<WebElement> speedDropdownItems = driver.findElements(By.cssSelector(optionCSS));
		
		for (WebElement item : speedDropdownItems) {
			if(item.getText().trim().equals(expectedItem)) {
				item.click();
				break;
			}
		}
	}
	
	public void EnterAndSelectDropDown(String textboxCss, String optionCSS, String expectedItem) {
		driver.findElement(By.cssSelector(textboxCss)).sendKeys(expectedItem);
		SleepInSecond(2);
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(optionCSS)));
		List<WebElement> speedDropdownItems = driver.findElements(By.cssSelector(optionCSS));
		
		for (WebElement item : speedDropdownItems) {
			if(item.getText().trim().equals(expectedItem)) {
				item.click();
				break;
			}
		}
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