package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_09_Switch_Case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2();
	}
	
	public static void Ex1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entering the number");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		case 3:
			System.out.println("three");
			break;
		case 4:
			System.out.println("four");
			break;
		case 5:
			System.out.println("five");
			break;
		case 6:
			System.out.println("six");
			break;
		case 7:
			System.out.println("senven");
			break;
		case 8:
			System.out.println("eight");
			break;
		case 9:
			System.out.println("night");
			break;
		case 10:
			System.out.println("ten");
			break;
		default:
			System.out.println("Gia tri ko hop le");
			break;
		}
	}
	
	public static void Ex2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entering the 2 number");
		int a = scanner.nextInt(), b = scanner.nextInt();
		System.out.println("Entering the operator");
		String opt = scanner.nextLine();
		switch (opt) {
		case "+":
			System.out.println("Tong la " + (a+b));
			break;
		case "-":
			System.out.println("Hieu la " + (a-b));
			break;
		case "*":
			System.out.println("Nhan la " + (a*b));
			break;
		case "/":
			System.out.println("Thuong la " + (a/b));
			break;
		default:
			System.out.println("Gia tri ko hop le");
			break;
		}
	}
	
	public static void Ex3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entering the month by number");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			System.out.println("The day number is 31");
			break;
		case 2:
			System.out.println("The day number is 28");
			break;
		case 3:
			System.out.println("The day number is 31");
			break;
		case 4:
			System.out.println("The day number is 30");
			break;
		case 5:
			System.out.println("The day number is 31");
			break;
		case 6:
			System.out.println("The day number is 30");
			break;
		case 7:
			System.out.println("The day number is 31");
			break;
		case 8:
			System.out.println("The day number is 31");
			break;
		case 9:
			System.out.println("The day number is 30");
			break;
		case 10:
			System.out.println("The day number is 31");
			break;
		case 11:
			System.out.println("The day number is 30");
			break;
		case 12:
			System.out.println("The day number is 31");
			break;
			
		default:
			System.out.println("Gia tri ko hop le");
			break;
		}
	}
}
