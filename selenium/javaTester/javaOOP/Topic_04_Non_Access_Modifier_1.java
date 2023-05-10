package javaTester.javaOOP;

public class Topic_04_Non_Access_Modifier_1 {
	static String browserName1 = "chrome"; //static
	String browserName2; //non-static
	final String color = "red";
	
	// Convention -> với các biến hằng số và static -> Upper case + snake case
	static final String FULL_NAME = "";
	
	public static void main(String[] args) {
		// Biến static là biến tĩnh, thuộc về phạm vi của class -> có thể lấy trực tiếp từ class
		// Biến static sẽ được khởi tạo khi Java Vitrual Environment JVM được chạy, sẽ kết thúc khi process này kết thúc -> 
		// biến static có thể dùng cho tất cả các instance
		// Có thể gán lại giá trị
		// Trong các class khác có thể gọi đến trực tiếp biến static như dòng 15
		System.out.println(browserName1);
		browserName1 = "firefox";
		System.out.println(Topic_04_Non_Access_Modifier_1.browserName1);
		
		
		// Biến non-static thuộc về instance -> cần khởi tạo đối tượng thì mới có thể sử dụng -> dòng sau sẽ lỗi
		// System.out.println(browserName2);
		// thay vì đó, khi muốn truy cập đến một biến non-static -> cần khởi tạo đối tượng
		Topic_04_Non_Access_Modifier_1 object1 = new Topic_04_Non_Access_Modifier_1();
		System.out.println(object1.browserName2);
		
		// tương tự như với các method, có thể gọi trực tiếp clickToElement2
		// với hàm static -> ko cho phép ghi đè
		clickToElement2("");
		Topic_04_Non_Access_Modifier_1.clickToElement2("");
		
		// ko thể gọi trực tiếp đến static method
		// clickToElement1(""); -> ko được phép
		object1.clickToElement1("");
		
		// thông thường ko có static class, chỉ có thể tạo static class với nested class -> thường ko đc sử dụng
		
		// final: phạm vi sử dụng cho cả variable, method và class
		// với final variable -> tạo 1 biến hằng số, ko được ghi đè
		// với final method -> ko được override lại method
		// với final class
		
		//abstract class -> ko được phép khởi tạo, chỉ được kế thừa
	}
	
	public void clickToElement1(String elementName) {
		System.out.println(elementName);
	}
	public static void clickToElement2(String elementName) {
		System.out.println(elementName);
	}
	
	public final void setCarName() {
		
	}


}
