package javaTester;

import java.util.ArrayList;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic01_Data_Type {

	public static void main(String[] args) {
		/* 
		 * Co hai kieu du lieu la kieu du lieu nguyen thuy va kieu du lieu tham chieu
		 * Kieu du lieu nguyen thuy bao gom
		 * Kieu ki tu: char
		 * Kieu so nguyen: byte, short, int, long (tuy theo kich thuoc ma su dung: byte: 1 byte = 8 bit, short: 16 bit, int 4 byte, long 8 byte)
		 * Kieu so thuc: fload, double
		 * Kieu du lieu logic: boolean -> true or false
		 * Eg:
		 * */
		byte bNumber = 127;
		short sNumber = 32767;
		int iNumber = 123424; 
		long lNumber = 324234234;
		float fNumber = 3.14f;
		double dNumber = 0.618d;
		boolean status = true;
		
		/*
		 * Kieu du lieu tham chieu bao gom
		 * Chuoi ki tu: String
		 * Class, Interface, Collection: (Set, List, Queue); Object
		 */
		//String
		String team = "Automation FC";
		
		//class
		FirefoxDriver driver; 
		
		//Interface
		WebDriver wDriver; 
		
		//Object
		Object o;
		
		//Array
		int[] point = {1, 2, 3};
		
		// Collection: (Set, List, Queue)
		// HashSet/ LinkedHashSet, TreeSet
		HashSet hashset = new HashSet<>();
		
		// ArrayList/ LinkedList/ Vector
		ArrayList arrayList = new ArrayList<>();
		// Deque/
		// Map: HashMap/ HashTable
		
		//Co the thuc hien khai bao truoc, roi khoi tao du lieu sau, vi du:
		int a; //khai bao a
		a = 10; //gan du lieu hoac khoi tao du lieu cho a
		
		//Hoac thuc hien khai bao va khoi tao dong thoi
		int b = 20;
		
		//Su khac biet giua kieu du lieu nguyen thuy va tham chieu
		// Kieu nguyen thuy
		int anpha = 5;
		int beta = anpha;
		anpha = 10; 
		//Result: anpha = 10, beta = 5
		
		//Kieu tham chieu
		String aString = "Automation FC";
		String bString = aString;
		aString = "Hello World!";
		System.out.println("aString la" + aString);
		System.out.println("bString la" + bString);
		/*
		 * Result aString = bString = "Hello World!"
		 * Kieu du lieu tham chieu la kieu du lieu co the tham chieu den vung nho cua bien khac, 
		 * khi vung nho thay doi gia tri -> tu dong thay doi theo
		 */
		
		
		
	}

}
