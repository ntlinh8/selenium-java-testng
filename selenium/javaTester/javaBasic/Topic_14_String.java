package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_14_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String course = "Automation Testing";
		String address = new String("Ho Chi Minh City");
		
		// Note, length() is a method of String class. It difference from length in Array class
		// length in array is a attribute of Array class
		System.out.println("Length is " + course.length());
		
		String arrayList[] = {"Hello", "World"};
		System.out.println("Get length of array " + arrayList.length);
		
		// charAt() -> return charactor at index position (the first charactor have index = 0)
		System.out.println("Get charactor of index " + address.charAt(4));
		
		// concat() -> noi chuoi -> thuc te it duoc su dung
		System.out.println("Noi hai chuoi voi nhau " + course.concat(address));
		
		// equal -> verify value of 2 string
		System.out.println("Compare giua hai chuoi su dung equals " + course.equals("Automation Testing"));
		
		// so sanh su dung == se la so sanh ca vung nho cua 2 bien nay
		course = "AUTOMATION TESTING";
		String newCourse = course.toUpperCase();
		System.out.println("Compare giua hai chuoi dung == " + (course == newCourse));
		
		course = "Automation Testing";
		// Compare tuong doi		System.out.println(lowerCaseText == afterText);
		System.out.println("Compare tuong doi, compare hai string ma ko quan tam den Upper case and lower case " + newCourse.equalsIgnoreCase("automation testing"));
		
		System.out.println("Tra ve true neu string start with substring " + course.startsWith("A"));
		System.out.println("Tra ve true neu string start with substring " + course.startsWith("Automation"));
		System.out.println("Tra ve true neu string start with substring " + course.startsWith("Testing"));
		
		System.out.println("Tra ve true neu string end with substring " + course.endsWith("A"));
		System.out.println("Tra ve true neu string end with substring " + course.endsWith("Automation"));
		System.out.println("Tra ve true neu string end with substring " + course.endsWith("Testing"));
		
		System.out.println("Tra ve true neu string contains with substring " + course.contains("A"));
		System.out.println("Tra ve true neu string contains with substring " + course.contains("Automation"));
		System.out.println("Tra ve true neu string contains with substring " + course.contains("Testing"));
		
		// this is the index of the first charrator in the substring
		// index of A, u and t
		System.out.println("Tra ve index cua substring " + course.indexOf("Automation"));
		System.out.println("Tra ve index cua substring " + course.indexOf("utomation"));
		System.out.println("Tra ve index cua substring " + course.indexOf("tion"));
		
		System.out.println("Tra ve substring from index of bound of index");
		System.out.println("Neu ko truyen vao end index thi mac dinh la den het string" + course.substring(6));
		System.out.println("Lay ra substring tu index 6 den 8 " + course.substring(6, 8));
		
		// split string -> cat chuoi theo 1 ki tu nao do -> return array[] with each item is instance of String
		String message = "The fee for 100 items is $500.00";
		String messageList[] = message.split(" ");
		System.out.println(messageList[messageList.length-1]);
		
		// Replace "$" by ""
		messageList[messageList.length - 1] = messageList[messageList.length - 1].replace("$", "");
		System.out.println(messageList[messageList.length - 1]);
		
		//You can convert it to float (for calculate/sort process)
		Float numberf = Float.parseFloat(messageList[messageList.length-1]);
		System.out.println(numberf + 10.4f);
		
		// Convert Float type to String type is to easy
		System.out.println(String.valueOf(numberf));
		
		// in addition, you can convert the string to upper case string, like that
		System.out.println(course.toUpperCase());
		
		// or convert the string to lower case string, like that
		System.out.println(course.toLowerCase());
		
		// you can trim space for string, like that
		String spaceString = "     Hello world, Nguyen Van A     ";
		System.out.println(spaceString.trim());
		System.out.println("-----------------------------");
		String h = "hello 1234";
		System.out.println("The correct number is " + h.substring(h.length()-4, h.length()));
		Ex2();
	}
	public static void Ex1() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String course = scanner.nextLine();
		int upperCaseNumber = 0;
		for(int i = 0; i < course.length(); i++) {
			char charactor = course.charAt(i);
			if(Character.isUpperCase(charactor)) {
				upperCaseNumber++;
			}
		}
		System.out.println(upperCaseNumber);
	}
	
	public static void Ex2() {
		String message = "Automation Testing 345 Tutorials Online 789";
		
		// Dem so ki tu a trong chuoi
		int aNumber = 0;
		for(int i = 0; i < message.length(); i++) {
			char charactor = message.charAt(i);
			if(charactor == 'a' || charactor == 'A'){
				aNumber++;
			}
		}
		System.out.println("a charater number is " + aNumber);
		System.out.println("Chuoi chua Testing hay khong " + message.contains("Testing"));
		System.out.println("Chuoi start with Automation hay khong " + message.startsWith("Automation"));
		System.out.println("Chuoi end with Online hay khong " + message.endsWith("Online"));
		System.out.println("Vi tri tu Tutorials " + message.indexOf("Tutorials"));
		message = message.replace("Online", "Offline");
		System.out.println(message);
		
		int numberNumber = 0;
		for(int i = 0; i < message.length(); i++) {
			char charactor = message.charAt(i);
			if(charactor >= '0' && charactor <= '9'){
				numberNumber++;
			}
		}
		System.out.println("So ki tu la number is " + numberNumber);
		
		
	}
	
	public static void Ex3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the random string ");
		String oldString = scanner.nextLine();
		String newString = "";
		for(int i = oldString.length()-1; i >= 0; i--) {
			char charactor = oldString.charAt(i);
			newString = newString.concat(String.valueOf(charactor));
		}
		System.out.println(newString);
	}
}
