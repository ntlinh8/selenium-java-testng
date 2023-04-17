package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_10_For_Loop_Statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7();
		
	}
	
	public static void Ex1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao n: ");
		int n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++ ) {
			System.out.print(i + " ");
		}
	}
	public static void Ex2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap vao b: ");
		int b = scanner.nextInt();
		for(int i = a; i <= b; i++ ) {
			System.out.print(i + " ");
		}
	}
	
	public static void Ex3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao n: ");
		int n = scanner.nextInt();
		for(int i = 1; i <= n; i++ ) {
			if(i%2==0) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void Ex4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap vao b: ");
		int b = scanner.nextInt();
		int sum = 0;
		for(int i = a; i <= b; i++ ) {
			sum += i;
		}
		System.out.println("Tong la " + sum);
	}
	
	public static void Ex5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao n: ");
		int n = scanner.nextInt();
		int sum = 0;
		for(int i = 1; i <= n; i++ ) {
			if(i%2!=0) {
				sum += i;
			}
		}
		System.out.println("Tong la " +sum);
	}
	
	public static void Ex6() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap vao b: ");
		int b = scanner.nextInt();
		for(int i = a; i <= b; i++ ) {
			if (i%3 == 0) {
				System.out.print(i +" ");
			}
		}
	}
	
	public static void Ex7() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao n: ");
		int n = scanner.nextInt();
		int result = 1;
		for(int i = 1; i <= n; i++ ) {
			result *= i;
		}
		System.out.println("Result is " +result);
	}
}
