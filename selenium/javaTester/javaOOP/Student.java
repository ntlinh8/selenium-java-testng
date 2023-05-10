package javaTester.javaOOP;

import java.util.Scanner;

class Student {
	private int id;
	private String fullName;
	private float theoreticalPoint, practicePoint;

	public Student() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the id: ");
		this.id = Integer.valueOf(scanner.nextLine());
		
		System.out.println("Enter the fullname: ");
		this.fullName = scanner.nextLine();
		
		System.out.println("Enter the theoretical point: ");
		this.theoreticalPoint = scanner.nextFloat();
		
		System.out.println("Enter the practice point: ");
		this.practicePoint = scanner.nextFloat();
	}
	
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getFullName() {
		return fullName;
	}
	void setFullName(String fullName) {
		this.fullName = fullName;
	}
	float getTheoreticalPoint() {
		return theoreticalPoint;
	}
	void setTheoreticalPoint(float theoreticalPoint) {
		this.theoreticalPoint = theoreticalPoint;
	}
	float getPracticePoint() {
		return practicePoint;
	}
	void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	private float calculateAveragePoint() {
		return (this.theoreticalPoint + 2 * this.practicePoint)/3;
	}
	
	void presenceStudent() {
		System.out.println("- " + this.fullName + " - " + this.id + " - " + this.practicePoint + " - " + this.theoreticalPoint + " - " + calculateAveragePoint() + " -");
	}
}
