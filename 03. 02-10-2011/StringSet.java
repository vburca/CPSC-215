/* Author: Vlad Burca, Brandon Lewis
   Date: 02-10-2011
   File: StringSet.java
 */

/**
 * @author: Vlad Burca, Brandon Lewis
 * @version: 02-10-2011
 */


/**
 * This class implements a set of strings using a linked list to support five 
 * operations, namely, testing emptiness, membership, insertion, removal, and 
 * printing.
 */

public class StringSet {
    
  private Node head;
  private int size;                       // The actual size

  /**
   * Creates an empty list and initializes the set's size to 0 (i.e., it 
   * creates an empty set).
   */
  public StringSet() {
    head = null;
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns, if it exists, a node containing a string s in the sublist 
   * that begins with n.
   */
  private Node find(Node n, String s) {
  	if (n == null)
  		return n;
  	else
  		if (n.getElement().equals(s))
  			return n;
  		else
  			return find(n.getNext(), s);
  }

  /**
   * Returns true if the set contains a string s.
   */
  public boolean contains(String s) {
	if (find(head, s) != null)
		return true;
	else
		return false;

  }

  /**
   * Inserts a string s into the list and increments size by 1.
   */
  public void insert(String s) {
    if (!contains(s)) {
      Node newN = new Node(s, null);
      if (head == null)
      	head = newN;  
        else if (s.compareTo(head.getElement()) < 0) {
      				newN.setNext(head);
      				head = newN;
      			}    				
      else {	
	  	Node cur = head;
	 	while ((cur.getNext() != null) && (s.compareTo((cur.getNext()).getElement()) >= 0))
	  		cur = cur.getNext();
	  	if (cur.getNext() == null)
	  		 cur.setNext(newN);
	  	else {
	 		newN.setNext(cur.getNext());
	 		cur.setNext(newN);
	 	    }
		}
	  size++;
      System.out.println("Inserting " + s + "...");
    }
    else
      System.out.println("Inserting " + s + "..., but " + s + 
                         " already exists.");
  }

  /**
   * Removes a string s from the list and decrements size by 1.
   */
  public void remove(String s) {
    Node r = find(head, s);
    if (r == null) 
      System.out.println("Removing " + s + "..., but " + s +
		         " does not exist.");
    else {
	  Node cur = head;
	  if (cur == r)
	  	head = cur.getNext();
	  else {
	  	while (cur.getNext() != r)
	  		cur = cur.getNext();
	 	cur.setNext(r.getNext());
	 	}
	  size--;
      System.out.println("Removing " + s + "...");
    }
  }

  /**
   * Prints all the strings in the list.
   */
  public void print() {
    Node n = head;
    System.out.print("{ ");
    while (n != null) {
      System.out.print(n.getElement());
      if (n.getNext() != null) 
	System.out.print(", ");
      n = n.getNext();
    }
    System.out.println(" }");
  }

}
