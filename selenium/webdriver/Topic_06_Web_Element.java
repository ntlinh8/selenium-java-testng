package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	//Thay vì khai báo đối tương WebElement trên đây gây ra lỗi thì chỉ cần khai báo đối tương By, khi đó nó sẽ chưa thực hiện đi tìm element
	By firstName_textbox = By.id("firstName");
	
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
		WebElement element = driver.findElement(By.id(""));
		WebElement firstName = driver.findElement(firstName_textbox);
		
		//Dùng cho textbox, textarea, dropdown (editable)
		//Xóa dữ liệu trc khi nhập
		element.clear(); //*
		
		//Input dữ liệu vào textbox
		element.sendKeys("hello");//**
		
		//Click vào link, button, radio, checkbox,...
		element.click();//**
		
		//Lấy ra giá trị của 1 attribute
		String placeholder = element.getAttribute("placeholder");//**
		
		//Lấy ra giá trị CSS của một element, thường được sử dụng để test GUI
		String color = element.getCssValue("background-color");//*
		
		//lấy ra vị trí của element so với vị trí của web
		Point point = element.getLocation();
		point.x = 324;
		point.y = 234;
		
		//Lấy ra kích thước bên trong của element
		Dimension di = element.getSize();
		di.getHeight();
		di.getWidth();
		System.out.println(di.getHeight());
		System.out.println(di.getWidth());
		
		//Lấy ra cả vị trí và kích thước
		Rectangle re = element.getRect();
		re.x = 132;
		re.y = 124 ;
		//Chụp hình lại nếu test case failed
		element.getScreenshotAs(OutputType.FILE);//*
		element.getScreenshotAs(OutputType.BASE64);
	
		//Lấy ra tag name của element
		element.getTagName();
		 
		//Dùng để verify message /label
		//Nằm bên ngoài thẻ -> get text
		//Nằm bên trong thẻ => get attribute
		element.getText();//**
		
		//Verify element hiển thị hoặc ko
		element.isDisplayed();//**
		Assert.assertTrue(element.isDisplayed());
		
		//Verify element enable hay không
		element.isEnabled();
		Assert.assertTrue(element.isEnabled());
		
		//Verify element đã được chọn hay chưa
		//Khác với 2 TH trên có thể thực hiện kiểm tra với tất cả các loại element khác nhau
		//isSelect chỉ được dùng cho những element có thể select được như radio button, checkbox, dropdown option
		//Tuy nhiên trong thực tế, dropdown option trong selenium đã có keyword khác để handle vậy nên isSelected thường ko được sử dụng với dropdown
		element.isSelected();
		Assert.assertTrue(element.isSelected());//**
		
		//Element nằm trong thẻ form
		//Tương ứng như nhấn phím enter trên bàn phím
		element.submit();
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