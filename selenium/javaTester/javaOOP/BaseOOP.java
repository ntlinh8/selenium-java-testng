package javaTester.javaOOP;

public class BaseOOP {
	public BaseOOP() {
		System.out.println("Constructor 01");

	}

	public BaseOOP(String name) {
		System.out.println("Constructor 02 - " + name);

	}

	public BaseOOP(String name, int age) {
		System.out.println("Constructor 03 - "+ name);
		System.out.println("Constructor 03 - "+ age);
	}
	
	protected void clickToElement() {
		System.out.println("Click To Element");
	}

}
