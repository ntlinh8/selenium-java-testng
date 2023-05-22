package javaTester.OOP;

public class Employee extends Person {
	
	public Employee(String name, int age, boolean isHandsome, String cardId) {
		super(name, age, isHandsome, cardId);
		// TODO Auto-generated constructor stub
	}

	static void workingTime() {
		System.out.println("Work 12h");
	}
	
	@Override
	protected void eat(String age) {
		System.out.println("Empployee eat");
	}
}
