package javaTester.javaBasic;

public class Topic_16_For_Loop_Advanced {
	public static void main(String[] args) {
		for(int i=1, j=1, k=1; i<5 && j > -5 && k < 5; i++, j--, k=k/2) {
			System.out.println("i j k lan luot la: " + i + " " + j + " "+ k);
		}
	}
}
