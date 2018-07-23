package code;

import java.util.LinkedList;
import java.util.ListIterator;

public class Chapter_02 {
	
	/**
	 * Finds a matching node between two singly linked lists and 
	 * returns a list of length 1. Iterates through the longer 
	 * list seeing if matching node exist in the other list.
	 * <p>
	 * Question 2.7
	 * </p>
	 * 
	 * @param list1 - the head node of the first list
	 * @param list2 - the head node of the second list
	 * @return node - the node that is in both lists
	 */
	public static LinkedList<Character> intersection(LinkedList<Character> list1, LinkedList<Character> list2) {
		LinkedList<Character> longList = new LinkedList<Character>();
		LinkedList<Character> shortList = new LinkedList<Character>();
		boolean matchFound = false;
		
		// Set iterator to the longer list
		if (list1.size() >= list2.size() ) {
			longList = (LinkedList<Character>) list1.clone();
			shortList = list2;
		} else {
			longList = (LinkedList<Character>) list2.clone();
			shortList = list1;
		}
		
		/* Check if any of the nodes in longer list are in the other list., 
		 * from https://stackoverflow.com/questions/4767615/java-iterating-a-linked-list */
		int index = 0;
		while(index < longList.size() ) {
			// if there's a match, make the matching element the only element in the longlist
			if (shortList.contains(longList.get(index)) ) {
				matchFound = true;
				longList.clear();
				longList.addFirst(list1.get(index-1) );
				break;
			}
			index++;
		}
		if (!matchFound) longList.clear();
		
		return longList;
	}
}
