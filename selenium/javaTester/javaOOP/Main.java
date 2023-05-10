package javaTester.javaOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static List<Student> studentList;
	
	public static void main(String[] args) {
		System.out.println("|     CHUONG TRINH QUAN LY SINH VIEN              |");
		System.out.println("|     1. Nhap du lieu                             |");
		System.out.println("|     2. In danh sach sinh vien                   |");
		System.out.println("|     3. Sap xep sinh vien theo average point     |");
		System.out.println("|     4. Xep loai sinh vien                       |");
		System.out.println("|     5. Xuat danh sach sinh vien                 |");
		System.out.println("|     0. Thoat chuong trinh                       |");
		readOption();
	}
	
	public static void readOption() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please choose the option: ");
			int option = scanner.nextInt();
			switch (option) {
			case 0:
				System.out.println("End System");
				break;
			case 1:
				enterStudentInformation();
				readOption();
				break;
			case 2:
				printStudentList();
				readOption();
				break;
			case 3:
				sortStudentWithAveragePoint();
				readOption();
				break;
			case 4:
				studentRate();
				readOption();
				break;
			case 5:
				exportStudentList();
				readOption();
				break;
			default:
				System.out.println("You entered invalid number, please enter again");
				readOption();
				break;
			}
		}
	}
	
	public static void enterStudentInformation() {
		int studentNumber;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the student number");
		studentNumber = scanner.nextInt();
		studentList = new ArrayList<Student>(studentNumber);
		
		if(studentNumber < 0) {
			System.out.println("You entered invalid number, please enter again");
			enterStudentInformation();
		}else {
			for(int i = 0; i < studentNumber; i++) {
				Student student = new Student();
				studentList.add(i, student);
			}
		}
	}
	
	public static void printStudentList() {
		if(studentList.isEmpty()) {
			System.out.println("No student in the list, please enter the student information");
			enterStudentInformation();
		}else {
			System.out.println("The Student Information");
			System.out.println("- Full Name - ID - Practice Point - Theoretical Point - Average Point -");
			for(int i = 0; i < studentList.size(); i++) {
				studentList.get(i).presenceStudent();
			}
		}
	}
	
	public static void sortStudentWithAveragePoint() {
		
	}
	
	public static void studentRate() {
		
	}
	
	public static void exportStudentList() {
		
	}
	
	
}
