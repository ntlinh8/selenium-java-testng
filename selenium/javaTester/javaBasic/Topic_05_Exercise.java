package javaTester.javaBasic;

public class Topic_05_Exercise {

	public static void main(String[] args) {
		Exercise1(10,5);
		Exercise2();
		Exercise3();
	}
	
	public static void Exercise1(int a, int b) {
		System.out.println("a + b = " + (a+b));
		System.out.println("a - b = " + (a-b));
		System.out.println("a * b = " + (a*b));
		System.out.println("a / b = " + (a/b));
		
	}
	
	public static void Exercise2() {
		float a = 7.5f;
		float b = 3.8f;
		System.out.println("Area = " + (a*b));
	}
	
	public static void Exercise3() {
		String name = "Automation Testing";
		System.out.println(name);
	}
}
