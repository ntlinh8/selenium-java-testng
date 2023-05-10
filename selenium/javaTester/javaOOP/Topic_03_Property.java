package javaTester.javaOOP;

public class Topic_03_Property {
	// Property là các thuộc tính của một lớp, các object/instance được tạo ra từ một lớp sẽ kế thừa các thuộc tính của lớp cha
	// bình thường trong văn nói sẽ không có sự phân biệt rõ ràng trong cách nói giữa property và variable
	// Nhưng có thể hiểu property sẽ đi với class/object/instance
	// còn variable là các biến chung chung hơn
	
	// ở đây sẽ khởi tạo các property của một lớp
	int id;
	String name;
	boolean isHandsome;
	
	// có thể quyết định xem các object con được kế thừa những thuộc tính nào của lớp cha bằng việc sử dụng access modifier
	// một vài keyword liên quan đến non-access modifier cũng được sử dụng
	// ví dụ 
	static String address = "No. 1 Tran Thai Tong";
	
	public static void main(String[] args) {
		// Khi khởi tạo các instance của một lớp, nó cũng sẽ có các thuộc tính như lớp cha
		Topic_03_Property obj1 = new Topic_03_Property();
		Topic_03_Property obj2 = new Topic_03_Property();
		Topic_03_Property obj3 = new Topic_03_Property();
		
		System.out.println(obj1.id);
		System.out.println(obj2.name);
		System.out.println(obj3.isHandsome);
		
	}
	
}
