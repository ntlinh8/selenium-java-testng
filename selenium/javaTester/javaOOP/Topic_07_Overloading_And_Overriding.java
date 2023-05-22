package javaTester.javaOOP;
import javaTester.OOP.Student;

public class Topic_07_Overloading_And_Overriding {
	
	// in Vietnamese, overloading is nạp chồng phương thức and overriding is ghi đè phương thức
	// when we have some method which have a same name, it's overloading
	// Khi có nhiều hàm có cùng tên, đó gọi là overloading
	// tức một hàm có nhiều hình thái khác nhau
	// mặc dù có tên giống nhau nhưng số param hoặc kiểu param phải khác nhau
	// như vậy mới đảm bảo được là mặc dù các hàm này cùng tên nhưng thực chất chúng ko giống nhau
	// contructor cũng có thể apply overloading
	// Trong quá trình code, dựa vào số biến và kiểu dữ liệu đầu vào, JVM có thể nhận biết mình đang chọn hàm nào
	// Quá trình định vị hàm này diễn ra ngay tại quá trình compile code
	// overloading chỉ diễn ra bên trong một lớn
	
	// khác với overloading, overriding là ghi đè một hàm của lớp cha.
	// Nếu lớp con ko muốn sử dụng hàm của lớp cha, hoặc muốn thay đổi cách hoạt động của hàm đó tại lớp hiện tại, chúng có thể ghi đè lại hàm này
	// thông thường, quá trình ghi đè sẽ diễn ra một cách ngầm định khi khởi tạo 1 hàm trong class con có cùng tên, cùng số lượng và kiểu param như lớp cha
	// nhưng chúng ta cũng có thể gọi nó một cách tường minh với @Override
	// đương nhiên, chúng ta ko thể ghi đè vào các hàm có non-acccess modifier là final or static or abstract
	// Khi override, có thể sửa lại access modifier, nhưng chỉ có thể override tạo ra 1 method có access modifier rộng hơn method ban đầu, b có thể xem thêm trong module javaTester.OOP
	public static void main(String[] args) {
		Student s = new Student("An", 12, true, "123123123");
		System.out.println(s.getName());
	}

}
