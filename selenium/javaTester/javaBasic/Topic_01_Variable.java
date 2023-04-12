package javaTester.javaBasic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Variable {
	int globalVariable;
	static int staticGlobalVariable;
	final static int TIMEOUT = 100;

	public static void DemoLocalVariable() {
		// int localVariable;
		// System.out.println(localVariable); -> Bao loi vi chua gan cho localVariable 1 gia tri default
		int localVariable = 5;
		System.out.println(localVariable); // -> Ko bao loi
		// Color of the local variable is brown
	}

	public void DemoGlobal() {
		// Color of the global variable is blue
		Topic_01_Variable topic = new Topic_01_Variable();

		// Biến global cho toàn bộ các function trong class, chỉ có thể gọi đến trong
		// class
		System.out.println(globalVariable);

		// Nếu đang trong class khác, nếu muốn gọi đến biến global của class này, cần
		// khởi tạo đối tượng
		// topic is a local variable
		System.out.println(topic.globalVariable);
	}

	// Hàm static ko thể sd với biến ko static
	public static void StaticVarable1() {
		// System.out.println(globalVariable); -> bao loi
	}

	// Bien static global co mau xanh duong va in nghieng
	public static void StaticVarable2() {
		// Nếu dùng biến static global được khởi tạo trong chính class đang sử
		// dụng thì chỉ cần gọi tên biến
		System.out.println(staticGlobalVariable);

		// Nếu dùng biến static global được khởi tạo trong class khác thì cần gọi nó
		// thông qua class
		// Biến static của class thuộc sự sở hữu của class
		System.out.println(Topic_01_Variable.staticGlobalVariable);

		// Nếu gọi biến static qua một instance thì nó sẽ warning -> tạo hàm getter
		// setter hoặc gọi nó thông qua class
		Topic_01_Variable topic = new Topic_01_Variable();
		System.out.println(topic.staticGlobalVariable);
	}

	public void Final() {
		// Ko thể gán lại giá trị cho biến final
		// TIMEOUT = 50;
		// Topic01_Data_Type.TIMEOUT = 50;
	}
	
	public void InOutValue() {
		Scanner scanner = new Scanner(System.in);
		int age = scanner.nextInt();
		System.out.println(age);
	}
}
