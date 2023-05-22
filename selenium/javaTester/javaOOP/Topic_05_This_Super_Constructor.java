package javaTester.javaOOP;

public class Topic_05_This_Super_Constructor extends BaseOOP{
	private String name;
	
	// this keyword will return the current instance or current object
	// so we can call the other method from the method in one class by this.method()
	// but in the class, this way usually was not used
	// in normal, when we want to call the other method from another method, we usually method()
	
	// super keyword was used to reference to the constructor of the parent class
	// super and this keyword always requires calling in the first statement in the constructor
	// if the parent class have many constructor, we can indicate the constructor that we want.
	public Topic_05_This_Super_Constructor(String name) {
		super(name);
		this.name = name;
	}
	
	public static void main(String[] args) {
		

	}

}
