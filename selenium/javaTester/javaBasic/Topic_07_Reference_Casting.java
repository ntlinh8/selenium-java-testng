package javaTester.javaBasic;

public class Topic_07_Reference_Casting {
	int studentID;
	public static void main(String[] args) {
		Topic_07_Reference_Casting student1 = new Topic_07_Reference_Casting();
		Topic_07_Reference_Casting student2 = new Topic_07_Reference_Casting();
		
		student1.studentID = 123;
		student2.studentID = 342;
		
		System.out.println(student1.studentID);
		System.out.println(student2.studentID);
		
		// Tại bước gán này, giá trị của biến student2 sẽ được tham chiếu đến khu vực vùng nhớ của student1, kiểu dữ liệu cũng sẽ bị ép về kiểu dữ liệu của student1
		// Thực tế trong trường hợp này chúng có cùng kiểu dữ liệu
		student2 = student1;
		
		//Thay đổi studen1.studentID -> giá trị của student2.studentID cũng bị thay đổi theo
		student1.studentID = 985;
		
		System.out.println(student1.studentID);
		System.out.println(student2.studentID);
	}
}
