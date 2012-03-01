/* Author: Vlad Burca
   Date: 02/17/2011
   File: ArrayStringSet.java
*/

/**
 * @author: Vlad Burca
 * @version: 02/17/2011
 */

/**
 * This class implements a set of strings using an array to support five 
 * operations, namely, testing emptiness, membership, insertion, removal, and 
 * printing.
 */

public class ArrayStringSet {
    
  public static final int MAX_SIZE = 1000; // Maximum capacity

  private String elements[];
  private int size;                        // The actual size

  /**
   * Creates an array of MAX_SIZE capacity and initializes the set's size to
   * 0 (i.e., it creates an empty set).
   */
  public ArrayStringSet() {
    elements = new String[MAX_SIZE];
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   * @return true / false - whether the array is empty or not
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns, if it exists, an index that refers to a string s in the subarray 
   * that begins with index n.  Returns -1 if it does not exist, 
   * @param n - Integer value
   * @param s - String value
   * @return an integer for the position (index) in the subarray of the string s
   */
  private int find(int n, String s) {
  	if (n == size)
  		return -1;
  	else if (elements[n].equals(s))
  			 return n;
  		 else
  			 return find(n + 1, s);
  			
    // Fill in the blank here.  Use recursion.

  }

  /**
   * Returns true if this set contains a string s.
   * @param s - String value
   * @return true / false - whether the array contains string s or not
   */
  public boolean contains(String s) {
	if (find(0, s) == -1)
		return false;
	else
		return true;
		
    // Fill in the blank here.

  }

  /**
   * Inserts a string s into the array elements[] and increments size by 1..
   * @param s - String value
   */
  public void insert(String s) {
    if (!contains(s)) {
      int x = 0;
      while (x < size && s.compareTo(elements[x]) >= 0)   
      	x++;
	  size = size + 1;
	  for (int i = size - 1; i > x; i --)
	  	elements[i] = elements[i - 1];
	  elements[x] = s;
      // Fill in the blank here.

      System.out.println("Inserting " + s + "...");
    }
    else
      System.out.println("Inserting " + s + "..., but " + s + 
			 " already exists.");
  }

  /**
   * Removes a string s from the array elements[] and decrements size by 1.
   * @param s - String value
   */
  public void remove(String s) {
    int n = find(0, s);
    if (n == -1) 
      System.out.println("Removing " + s + "..., but " + s +
			 " does not exist.");
    else {
	  for (int i = n; i < size - 1; i++)
	  	elements[i] = elements[i+1];
	  size = size - 1;
	  
      // Fill in the blank here.

      System.out.println("Removing " + s + "...");
    }
  }

  /**
   * Prints all the elements of the array elements[].  Note that it uses 
   * the size as the loop bound.
   */
  public void print() {
    System.out.print("{ ");
    for (int i = 0; i < size; i++) {
      System.out.print(elements[i]);
      if (i < size - 1)
	System.out.print(", ");
    }
    System.out.println(" }");
  }

}
