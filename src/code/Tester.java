package code;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Tester {
	
	public static String userInput(boolean closeReader) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter input: ");
		
		String input = reader.nextLine();
		if (closeReader) {
			reader.close();
		}
		return input;
	}
	
	public static void main(String[] args) {
		// Always get an input first
		String userInput = userInput(false);
		
		// Question 1.1
//		boolean ans = Chapter_01.isUniqueNoDataStructures(userInput.toCharArray() );
//		System.out.println(ans);
		
		// Question 2.7
		// Setting up the linkedlists I'm going to pass into solution method
		LinkedList<Character> lletters = stringToLinkedList(userInput);
		LinkedList<Character> lletters0 = stringToLinkedList(userInput);
		userInput = userInput(true);
		LinkedList<Character> lletters1 = stringToLinkedList(userInput);
		
		// Getting an answer
		LinkedList<Character> ans = new LinkedList<Character>();
		ans = Chapter_02.intersection(lletters, lletters1);
		
		// Check if the answer is null before reaching in for the value
		if (!ans.isEmpty() ) {
			System.out.println(ans.getFirst().charValue());
		} else System.out.println("Lists don't intersect");
		
		// Copy a reference in one list into the other list and get the answer
		intersectLists(lletters0, lletters1);
		ans = Chapter_02.intersection(lletters0, lletters1);
		
		// Check if the answer is null before reaching in for the value
		if (!ans.isEmpty() ) {
			System.out.println(ans.getFirst().charValue());
		} else System.out.println("Lists don't intersect");
	}
	
	/**
	 * Parses the letters in a string into a LinkedList.
	 * Based on https://stackoverflow.com/questions/28880383/take-a-input-and-add-it-to-linkedlist
	 * <p>
	 * Question 2.7
	 * </p>
	 * 
	 * @param input - string to be parsed
	 * @return lletters - singly linked letters
	 */
	public static LinkedList<Character> stringToLinkedList(String input) {
		LinkedList<Character> lletters = new LinkedList<Character>();
		char[] splitLetters = input.toCharArray();
		
		for(Character l : splitLetters) {
			lletters.add(l);
		}
		
		return lletters;
	}
	
	/**
	 * Takes the last letter in one list and adds it to a random place in the other list.
	 * <p>
	 * Question 2.7
	 * </p>
	 * 
	 * @param l1 - list of letters
	 * @param l2 - list to be intersected
	 */
	public static void intersectLists(LinkedList<Character> l1, LinkedList<Character> l2) {
		
		// Pick a place to insert same reference
		int range = l2.size();
		int randomPosition = (int) (Math.random() * 10);
		while (randomPosition >= range & randomPosition == 0){
			System.out.println(l2.size() + ", l2 size" + range + ", range");
			System.out.println("in while loop, " + randomPosition);
			randomPosition = (int) (Math.random() * 10);
		}
		
		System.out.println(randomPosition);
		l2.add(randomPosition, l1.getLast() );
		
		for (Character c : l2) {
			System.out.print(c.charValue() + ", ");
		}
		System.out.println();
	}
}
