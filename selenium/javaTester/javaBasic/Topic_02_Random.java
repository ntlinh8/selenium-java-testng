package javaTester.javaBasic;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Random {

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt(99999));
		
		System.out.println(getRandomNumber());
	}
	
	public static int getRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(99999);
		return randomNumber;
	}
}
