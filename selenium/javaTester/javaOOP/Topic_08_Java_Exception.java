package javaTester.javaOOP;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Topic_08_Java_Exception {
	// In java, there are 2 main error type
	// Exception and error are extends Throwable class
	// Errors are mistake about the JVM, and hardware of computer (StackOverFlowError, VitualMachineError, or OutOfMemoryError)
	// With exception, there are 2 exception type.
	// 1. Compile exception: Exception occurs when coding
	// 2. Runtime exception: Exception occurs when running
	public static void main(String[] args) {
		// This is a java exception
		
		// 1. NullPointerException
		String name = null;
		System.out.println(name.length());
		
		// 2. NumberFormatException: we cannot convert "java" string to integer
		name = "java";
		int age = Integer.parseInt(name);
		System.out.println(age);
		
		// 3. ArrayIndexOutOfBoundsException
		int element[] = {1,2,4,34,234};
		System.out.println(element[5]);
		
		// 4. FileNotFoundException
		File file = new File("C:\\Automation.txt");
		FileReader fr;
		try {
			// The statements may cause the exception
			fr = new FileReader(file);
			fr.close();
		} catch (IOException e) {
			// if the exception occurs, this statement will execute
			// We have 3 ways to show the detail exception
			
			//1. return short description of this throwable
			e.toString();
			
			//2. return the detail message string of this throwable
			e.getMessage();
			
			//3. return short description of this throwable
			e.printStackTrace();
		} finally {
			// if the finally block occurs, the statement in the finally block always executes after running the statement in try-catch block
			System.out.println("Finally");
		}
		
		System.out.println("Finally2");
		
		// How to handle the exception? try-catch and finally statement
		// Above is a example. We will give the block code which can have a mistake into try block
		// If the exception occurs, the statement in catch block will execute
		// We can have a try block and no catch block, so the opposite will no occurs 
		// It meaning when using try-catch statement, try statement is required, catch statement is optional
		
	}
	
	
}