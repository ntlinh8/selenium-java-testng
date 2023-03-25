package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_25_FindElement_FindElements {
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/*
	 * Knowledge: inplicit wait apply cho tat ca cac ham find Element bao gom findElement and findElements
	 * thuc hien tim element trong 15s, 0.5s tim 1 lan. 
	 * Neu trong 15s tim thay element -> ko can wait nua -> run tiep step tiep theo
	 * neu het 15s ko thay element -> 
	 * findElement -> FAIL: throw exception: noSuchElement. 
	 * findElements -> List = 0
	 * 
	 * Warning of implicit wait: nen than trong khi dung voi Xpath. 
	 * Cần tối ưu xpath để get element trước khi tăng implicit wait lên
	 */
	@Test
	public void TC_01_FindElement() {
//		thao tac 1 lan
//		driver.findElement(By.cssSelector(""));
//		Thao tac nhieu lan 
//		WebElement textbox = driver.findElement(By.cssSelector(""));
//		textbox.sendKeys("");

		/*
		 * 3 Cases
		 * Case 1: find only a node
		 * Case 2: find nodes
		 * Case 3: no node matched
		 */
		
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		//TH1: co 1 element match trong DOM
		//Vi co element -> ko can dung den 15s ma chi trong 1s dau tien da tim thay
		//PASS - 1s
		driver.findElement(By.cssSelector("input#email"));
		
		//TH2: co nhieu hon 1 element match trong DOM
		//Vi co element nen tim thay ngay trong 1s dau tien, ham findElement chi quan tam den element dau tien thoi, ko quan tam den cai con lai
		//PASS - 1s
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hello");
		
		//TH3: Khong co element trong DOM
		// wait het 15s -> throw exception NoSuchElement -> ko the chay step tiep theo
		//Fail - 15s
		driver.findElement(By.xpath("//input[@type='check']"));
		
		//Decheck element ko co trong DOM co cac cach sau
		//Staleness
		//getlist Element -> xong verify size = 0
	}

	@Test
	public void TC_02_FindElement() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		/*
		 * 3 Cases
		 * Case 1: find only a node
		 * Case 2: find nodes
		 * Case 3: no node matched
		 */
		
		//TH1: thuc hien tim element trong 15s, 0.5s tim 1 lan
		//Vi co element -> ko can dung den 15s ma chi trong 1s dau tien da tim thay -> tra ra list element ngay
		//PASS - 1s
		List<WebElement> listTextbox = driver.findElements(By.cssSelector("input#email"));
		Assert.assertEquals(listTextbox.size(), 1);
		
		//TH2: Thuc hien tim element trong
		// Vi co element nen tim thay ngay trong 1s dau tien, ham findElement chi quan tam den element dau tien thoi, ko quan tam den cai con lai
		//PASS - 1s
		listTextbox = driver.findElements(By.xpath("//input[@type='email']"));
		Assert.assertEquals(listTextbox.size(), 2);
		
		//TH3: Khong co element trong DOM
		// wait het 15s -> tra ra list = 0 element
		// FASS - 15s
		listTextbox = driver.findElements(By.xpath("//input[@type='check']"));
		Assert.assertEquals(listTextbox.size(), 0);
	}

	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}