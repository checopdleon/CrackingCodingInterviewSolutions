package code;
import java.util.Scanner;

public class Tester {
	
	public static String userInput() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter input: ");
		
		String input = reader.nextLine();
		reader.close();
		
		return input;
	}
	
	public static void main(String[] args) {
		String newString = userInput();
		
		boolean ans = Chapter_One.isUniqueNoDataStructures(newString.toCharArray() );
		
		System.out.println(ans);
	}
}
