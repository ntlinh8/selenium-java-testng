package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_12_Break_And_Continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1();
	}
	public static void Ex1() {
		String[] browserList = {"Chrome", "Firefox", "IE", "Edge", "Coccoc", "Brave"};
		int i = 0;
		while (i < browserList.length) {
			if(browserList[i].contains("IE")) {
				i++;
				continue;
			}
			System.out.println(browserList[i]);
			i++;
		}
	}
	public static void Ex2() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the month number: ");
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
			System.out.println("JAN");
			break;
		case 2:
			System.out.println("FEB");
			break;
		case 3:
			System.out.println("MAR");
			break;
		case 4:
			System.out.println("APRIL");
			break;
		case 5:
			System.out.println("MAY");
			break;
		case 6:
			System.out.println("JUNE");
			break;
		case 7:
			System.out.println("JULY");
			break;
		case 8:
			System.out.println("AUG");
			break;
		case 9:
			System.out.println("SEP");
			break;
		case 10:
			System.out.println("OCT");
			break;
		case 11:
			System.out.println("NOV");
			break;
		case 12:
			System.out.println("DEC");
			break;
		default:
			break;
		}
	}
}
