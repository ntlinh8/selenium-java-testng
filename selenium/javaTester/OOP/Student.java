package javaTester.OOP;

public class Student  extends Person implements IWork{

	public Student(String name, int age, boolean isHandsome, String cardId) {
		super(name, age, isHandsome, cardId);
		// TODO Auto-generated constructor stub
	}

	static void workingTime() {
		System.out.println("Work 4h");
	}
}
