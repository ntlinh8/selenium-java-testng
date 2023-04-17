package javaTester.javaBasic;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Topic_08_Condition_Statement_Execise {
	public static void main(String[] args) {

	}
	
	public static void Ex1() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n%2==0) {
			System.out.println("n la so chan");
		} else {
			System.out.println("n la so le");
		}
	}
	
	public static void Ex2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao a va b");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		if (a >= b) {
			System.out.println("a lon hon hoac bang b");
		} else {
			System.out.println("a nho hon hoac bang b");
		}
	}
	
	public static void Ex3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entering the name of 2 people");
		String a = scanner.nextLine(), b = scanner.nextLine();
		if (a.equals(b)) {
			System.out.println("Two people have the same name");
		} else {
			System.out.println("Two people have the diference name");
		}
	}
	
	public static void Ex4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entering the 3 numbers");
		int[] aList = new int[3];
		int max=0;
		for(int i = 0; i < aList.length; i++) {
			aList[i] = scanner.nextInt();
			if(aList[i] > max) max = aList[i];
		}
		System.out.println("max is " + max);
	}
	
	public static void Ex5() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Entering the one number");
			int a = scanner.nextInt();
			if(a >= 10 && a <= 100) {
				System.out.println(a + " nam trong doan [10, 100]");
			}else {
				System.out.println(a + " ko nam trong doan [10, 100]");
			}
	}

	public static void Ex6() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entering the point of a student");
		float a = scanner.nextFloat();
		if (a >= 0 && a < 5.0f) {
			System.out.println("Day la diem D");
		} else if (a >= 5.0f && a < 7.5f) {
			System.out.println("Day la diem C");
		} else if (a >= 7.5f && a < 8.5f) {
			System.out.println("Day la diem B");
		} else if (a >= 8.5f && a < 10.0f) {
			System.out.println("Day la diem A");
		} else {
			System.out.println("Ban da nhap diem ko hop le");
		}
	}

	public static void Ex7() {
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

