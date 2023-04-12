package javaTester.javaBasic;

public class Topic_04_Compare_StackAndHeapMemory {
	int number = 8;

	public static void main(String[] args) {
		
		// STACK MEMORY
		// Một vùng nhớ cho biến x
		int x = 5;

		// Một vùng nhớ cho biến y
		int y = x;

		// x = y = 5
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		x = 10;

		// x = 10, y = 5
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		//===============================================
		// HEAP MEMORY
		Topic_04_Compare_StackAndHeapMemory topic1 = new Topic_04_Compare_StackAndHeapMemory();
		Topic_04_Compare_StackAndHeapMemory topic2 = topic1;
		topic1.number = 10;

		// Ko thay đổi giá trị number của topic 1 nhưng vì nó tham chiếu đến number của
		// topic1 nên khi giá trị của topic1 thay đổi thì giá trị của topic2 cũng đổi
		// topic2.number = 10
		System.out.println(topic2.number);

	}
}
