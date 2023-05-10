package javaTester.javaOOP;

public class Topic_01_Class_Object {
	int id, age, score;
	String name;
	
	public Topic_01_Class_Object(int id, int age, String name, int score) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.score = score;
	}
	
	public void display() {
		System.out.println("Id is " + id );
		System.out.println("Username is " + name );
		System.out.println("Age is " + age );
		System.out.println("Score is " + score );
	}
	
}
