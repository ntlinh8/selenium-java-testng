package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_11_While_And_DoWhile {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Ex6();
	}
	
	public static void Ex1() {
		int n = scanner.nextInt();
		while(n < 100) {
			if(n%2 == 0) {
				System.out.print(n +" ");
			}
			n++;
		}
	}
	
	public static void Ex2() {
		System.out.println("Nhap vao a: ");
		int a = scanner.nextInt();
		
		System.out.println("Nhap vao b: ");
		int b = scanner.nextInt();
		
		while(a < b) {
			if(a%3 == 0 && a%5 == 0) {
				System.out.print(a +" ");
			}
			a++;
		}
	}
	
	public static void Ex3() {
		int n = scanner.nextInt();
		int i = 0, sum = 0;
		while(i <= n) {
			if(i%2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("Sum is: " + sum);
	}
	
	public static void Ex4() {
		System.out.println("Nhap a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap b: ");
		int b = scanner.nextInt();
		
		while(a < b) {
			if(a%3 == 0) {
				System.out.print(a +" ");
			}
			a++;
		}
	}
	
	public static void Ex5() {
		System.out.println("Nhap n: ");
		int n = scanner.nextInt();
		int result = 1;
		while(n >= 1) {
			result *= n;
			n--;
		}
		System.out.println("Result is: " + result);
	}
	
	public static void Ex6() {
		int i = 1, sum = 0;
		while(i <= 10) {
			if(i%2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("Sum is " + sum);	}
}
