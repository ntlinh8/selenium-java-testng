package javaTester.javaBasic;

public class Topic_13_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7();
	}
	public static void Ex1() {
		int arr[] = {2,7,6,8,9};
		int max = arr[0];
		for (int i : arr) {
			if(i > max) {
				max = i;
			}
		}
		System.out.println("Max is " + max);
	}
	
	public static void Ex2() {
		int arr[] = {2,7,6,8,9};
		System.out.println("Sum is " + (arr[0] + arr[arr.length-1]));
	}
	
	public static void Ex3() {
		int arr[] = {2,7,6,8,9,16,17,20};
		for (int i : arr) {
			if(i%2==0) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void Ex4() {
		int arr[] = {3, -7, 2, 5, 9, -6, 10, 12};
		int sum = 0;
		for (int i : arr) {
			if(i%2 != 0 && i > 0) {
				sum += i;
			}
		}
		System.out.println("Sum is " + sum);
	}
	
	public static void Ex5() {
		int arr[] = {3, -7, 2, 5, 9, -6, 10, 12};
		for (int i : arr) {
			if(i >= 0 && i <= 10) {
				System.out.print(i+" ");
			}
		}
	}
	
	public static void Ex6() {
		int arr[] = {3, 5, 7, 30, 10, 5, 8, 23, 0, -5};
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		System.out.println("Sum is " + sum);
		System.out.println("Average is " + (sum/arr.length));
	}
	
	public static void Ex7() {
		Topic_13_Student studen1 = new Topic_13_Student(12342, 13, "Nguyen Van A", 5);
		Topic_13_Student studen2 = new Topic_13_Student(12431, 13, "Le Thi B", 7);
		Topic_13_Student studen3 = new Topic_13_Student(12211, 13, "Banh Van C", 10);
		studen1.display();
		System.out.println("=======");
		studen2.display();
		System.out.println("=======");
		studen3.display();
	}
}
