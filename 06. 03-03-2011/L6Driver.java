/*
  Driver for NodeDeque - Deque implemented with double linked lists.
  
  Date: 03-03-2011.
  File: L6Driver.java
*/
 
/**
 * @author Vlad Burca, Steve Petkovsek
 * @version 03-03-2011
 */

 
 
 public class L6Driver {
 
	/**
	 * Driver that tests the eight methods defined in the NodeDeque.java file
	 */
	 
    public static void main(String args[]) {
		NodeDeque dq = new NodeDeque<String>();

		for (char k = 'M'; k <= 'Z'; k++) {  		     			  // Insert half of the alphabet.
			System.out.println("Adding last: " + k);
		    dq.addLast("" + k); 									// addLast()
		    System.out.println(dq.toString());
		}
		System.out.println();
		System.out.println("Size: " + dq.size()); 					 // size()
		System.out.println();
		for (char k = 'M' - 1; k >= 'A'; k--) {  					 // Insert second half of the alphabet.
			System.out.println("Adding first: " + k);
			dq.addFirst("" + k);									// addFirst()
			System.out.println(dq.toString());
		}
		System.out.println();
		System.out.println("Size: " + dq.size()); 
		System.out.println();
		System.out.println("Is empty: " + dq.isEmpty());  			 // isEmpty()
		System.out.println();
		while (!dq.isEmpty()) {
			System.out.println("First element: " + dq.getFirst());    // getFirst()
			System.out.println("Removing first element, " + dq.getFirst());
			dq.removeFirst(); 										// removeFirst()
			System.out.println(dq.toString());
			System.out.println("Last element: " + dq.getLast());      //getLast()
			System.out.println("Removing last element, " + dq.getLast());
			dq.removeLast(); 										// removeLast()
			System.out.println(dq.toString());
		}
		System.out.println();
		System.out.println("Is empty: " + dq.isEmpty());
	}
}
