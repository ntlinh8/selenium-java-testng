package webdriver;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import okio.Timeout;

public class Topic_05_Web_Browser {
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
	public void TC_01() {
		//Close tab/windows hiện tại đang đứng - *
		driver.close();
		
		//Close hết toàn bộ các tab or windows đã tạo ra - **
		driver.quit();
		//=> Nếu chỉ có 1 browser chứa 1 tab thì hai hàm hoạt động giống nhau
		
		//Có thể lưu element vào 1 biến để sử dụng nhiều lần, eg:
		WebElement firstName = driver.findElement(By.id("txtFirstname"));
		firstName.sendKeys("Nguyen Thuy Linh");
		
		//Hoặc dùng trực tiếp
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		
		//Tìm nhiều element
		List<WebElement> elementlist = driver.findElements(By.id("txtFirstname"));
		
		//Mở ra một website- **
		driver.get("https://google.com/");
		
		//Lấy ra url tại thời điểm hiện tại, có thể lấy ra một biến hoặc dùng luôn
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://google.com/");
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://google.com/");
		
		//lấy ra source code html của trang hiện tại
		String currentSource = driver.getPageSource();
		
		//Tương tự có thể dùng trực tiếp hoặc tạo biến, dùng để verify trong source có chứa text
		Assert.assertEquals(currentSource, "https://google.com/");
		
		String curenntTitle = driver.getTitle();
		Assert.assertEquals(curenntTitle, "Google");
		
		//Lấy ra id của tab hoặc windows hiện tại - *
		String windowId = driver.getWindowHandle();
		
		//Lấy ra id của tất cả window hoặc tab hiện tại - *
		Set<String> idList = driver.getWindowHandles();
		
		//Xử lý cookie và cache
		Options otp = driver.manage();	
		
		//Lấy cookie để login - *
		Set<Cookie> cookie = otp.getCookies();
		//lần sau cần đăng nhập mh sẽ lấy cookie ra để sử dụng
		
		//Liên quan đến bài timeout in selenium - **
		Timeouts time = otp.timeouts();
		time.implicitlyWait(5, TimeUnit.SECONDS);
		
		//Khoảng thời gian chờ để load page
		time.pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//Liên quan đến bài Javascript executor
		//Khoảng thời gian chờ để script chạy xong
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		otp.logs();
		
		Window window = otp.window();
		window.maximize(); // - **
		window.fullscreen(); //thường không được sử dụng vì ko giống như user bình thường sử dụng
		
		//So với độ phân giải màn hình của máy, vị trí trên cùng bên trái là 0x0, dưới cùng bên phải là tọa độ dựa trên độ phân giải của máy
		//lấy ra vị trí của window browser ở hiện tại (thường dùng khi ko sử dụng maximize)
		window.getPosition();
		
		//Set vị trí của window đúng vào vị trí tọa độ mình mong muốn
		window.setPosition(null);
		
		//Set size của window, thường được sử dụng để test responsive
		window.setSize(null);
		
		//mô tả phím next, back, và reload trong browser
		Navigation nav = driver.navigate();
		nav.back();
		nav.forward();
		nav.refresh();
		nav.to("https://google.com/"); //tương tự như driver.get nhưng ít được sử dụng, tuy nhiên nav.to dùng tốt hơn nếu cần check history
		 
		//Dùng trong các trường hợp cần switch vào alert/frame/window
		TargetLocator tar = driver.switchTo();
		tar.alert();	//**
		tar.frame(0);	//**
		tar.window(windowId);	//**
	}

	@Test
	public void TC_02() {
		
	}

	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}