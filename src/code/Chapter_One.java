package code;
import java.util.HashSet;
import java.util.Set;

public class Chapter_One {

	/**
	 * Checks for repeated letters in the char array passed in, using Set<Character>
	 * data structure and methods. Returns true if no letters were repeated.
	 * 
	 * @param s - any given array of chars
	 * @return
	 */
	public static boolean isUnique (String s) {
		// check if s is empty
		if (s == null | s.length() == 0) {
			return false;
		}
		else {

			// Start with empty set, for the unique element characteristic of sets
			Set<Character> set = new HashSet<Character>();

			// Change s string into array to make it irritable
			char newS[] = s.toCharArray();

			// Go through the string seeing if each char is already in the set
			for(char letter : newS) {
				if (set.contains(letter) || newS.length == 0) return false;
				else {
					set.add(letter);
				}
			}

			return true;
		}
	}

	/**
	 * Checks for repeated letters in the char array passed in.  No data structures
	 * were used to solve the problem.
	 * 
	 * @param s - any given array of chars
	 * @return result - true if there no letters were repeated
	 */
	public static boolean isUniqueNoDataStructures(char s[]) {
		boolean result = false;

		//  Starts the way as 'isUnique()'
		//  check if s is empty
		if (s == null | s.length == 0) {
			return result;
		}
		else {
			/* Take s and quicksort it,
			 * quicksort instead of mergesort bc better space complexity*/
			quicksort(s, 0, s.length-1 );
			
			result = checkForDuplicates(s);
		}

		return result;
	}

	/**
	 * Checks if there is more than one of each letter.
	 * 
	 * @param s - sorted char array of letters
	 * @return noDuplicates - true if no repeated letters
	 */
	private static boolean checkForDuplicates(char[] s) {
		boolean noDuplicates = false;

		char cur = s[0];

		/* Go through sorted chars seeing if this char
		 * is the same as the next char.*/
		for (int i = 0; i < s.length-1; i++) {
			// If there's a match stop everything and return
			if (cur == s[i +1] ) {
				noDuplicates = false;
				break;
			}
			// Otherwise change to the next letter
			else if (cur != s[i+1] ){
				cur = s[i+1];
				noDuplicates = true;
			}
		}

		return noDuplicates;
	}

	/**
	 * Helper method that sorts array. If no duplicate letter are 
	 * found then the whole array is sorted and returns true. If 
	 * duplicates are found the method stops sorting and returns false.
	 * From https://www.geeksforgeeks.org/quick-sort/
	 * 
	 * @param letters - string to be sorted
	 * @param low - starting index
	 * @param high - ending index
	 * @return hasDuplicates - whether all the letters are unique
	 */
	public static void quicksort(char[] letters, int low, int high) {

		if (low < high) {
			/* pi is partitioning index.
			 * The partition is in the right place to split the letters.*/
			int pi = partition(letters, low, high);

			// Recursively sort letters before and after partition index.
			quicksort(letters, low, pi-1);
			quicksort(letters, pi+1, high);
		}
	}

	/**
	 * Sets the last element as pivot, moves the pivot element to its correct
	 * position in the sorted array, and puts all smaller (smaller than pivot)
	 * to the left and all the greater elements to the right of pivot.
	 * From https://www.geeksforgeeks.org/quick-sort/
	 * 
	 * @param letters - string to be sorted
	 * @param low - starting index
	 * @param high - ending index
	 * @return - the index of the next element
	 */
	public static int partition(char[] letters, int low, int high) {
		int pivot = letters[high];
		int i = (low - 1); // index of the largest small elements

		// go through the letters between low and high
		for (int j = low; j < high; j++) {

			// if the current letter is smaller or equal to pivot
			if (letters[j] <= pivot) {
				i++;

				// swap letters.charAt(i) and letters.charAt(j)
				char temp = letters[i];
				letters[i] = letters[j];
				letters[j] = temp;
			}
		}

		/* swap arr[i+1] and pivot,
		 * putting the pivot in the right spot*/
		char temp = letters[i+1];
		letters[i+1] = letters[high];
		letters[high] = temp;

		// move to the next letter in string
		return i+1;
	}
}