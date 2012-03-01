/**
 * @author: Vlad Burca, Rahul Chatterjee
 * @version: 03-10-2011
 */
 
/*
  File: L7Driver.java
*/

public class L7Driver {

  /**
   * Prints all the elements of a given node list using an iterator.
   * @param l - PositionList<E>
   */
  public static <E> void print(PositionList<E> l) {
    Iterator<E> i = l.iterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	    System.out.print(", ");
    }
    System.out.println("]");
  }
  
  /**
   * Prints all the elements of a given node list in reversed order using a reverse iterator.
   * @param l - NodePositionList<E>
   */
  public static <E> void revPrint(NodePositionList<E> l) {
    Iterator<E> i = l.reverseIterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	    System.out.print(", ");
    }
    System.out.println("]");
  }
  
  /**
   * Prints every other elements of a given node list using an every other element iterator.
   * @param l - NodePositionList<E>
   */
  public static <E> void everyOtherPrint(NodePositionList<E> l) {
    Iterator<E> i = l.everyOtherIterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	    System.out.print(", ");
    }
    System.out.println("]");
  }

  /**
   * main function
   * @param args[] - String
   */
  public static void main(String args[]) {

	NodePositionList pl = new NodePositionList<String>();
	System.out.println();
  	pl.addFirst(8);
 	System.out.println("addFirst(8): ");
    System.out.print("print(): ");
    print(pl);
    System.out.print("revPrint(): ");
    revPrint(pl);
    System.out.print("everyOtherPrint(): ");
    everyOtherPrint(pl);
    System.out.println();
    System.out.println("first(): " + pl.first().element());
    Position p1 = pl.first();
    pl.addAfter(p1, 5);
    System.out.println("addAfter(p1, 5): ");
    System.out.print("print(): ");
    print(pl);
    System.out.print("revPrint(): ");
    revPrint(pl);
    System.out.print("everyOtherPrint(): ");
    everyOtherPrint(pl);
    System.out.println();
    System.out.println("next(p1): " + pl.next(p1).element());
    Position p2 = pl.next(p1);
    pl.addBefore(p2, 3);
    System.out.println("addBefore(p2, 3): ");
    System.out.print("print(): ");
    print(pl);
    System.out.print("revPrint(): ");
    revPrint(pl);
    System.out.print("everyOtherPrint(): ");
    everyOtherPrint(pl);
    System.out.println();
    System.out.println("prev(p2): " + pl.prev(p2).element());
    pl.addFirst(9);
    System.out.println("addFirst(9): ");
    System.out.print("print(): ");
    print(pl);
    System.out.print("revPrint(): ");
    revPrint(pl);
    System.out.print("everyOtherPrint(): ");
    everyOtherPrint(pl);
    System.out.println();
    System.out.println("last(): " + pl.last().element());  
    pl.remove(pl.first());
    System.out.println("remove(first()): ");
    System.out.print("print(): ");
    print(pl);
    System.out.print("revPrint(): ");
    revPrint(pl);
    System.out.print("everyOtherPrint(): ");
    everyOtherPrint(pl);
    System.out.println();
    Position p3 = pl.prev(p2);
    pl.set(p3, 7);
    System.out.println("set(p3, 7): ");
    System.out.print("print(): ");
    print(pl);
    System.out.print("revPrint(): ");
    revPrint(pl);
    System.out.print("everyOtherPrint(): ");
    everyOtherPrint(pl);
    System.out.println();
    pl.addAfter(pl.first(), 2);
    System.out.println("addAfter(first(), 2): ");
    System.out.print("print(): ");
    print(pl);
    System.out.print("revPrint(): ");
    revPrint(pl);
    System.out.print("everyOtherPrint(): ");
    everyOtherPrint(pl);
    System.out.println();
    
    /*
	for (char k = 'M'; k <= 'Z'; k++) {  		     			  // Insert half of the alphabet.
		System.out.println("Adding last: " + k);
		pl.addLast("" + k); 									// addLast()
		print(pl);
	}
	System.out.println();
	System.out.println("Size: " + pl.size()); 					 // size()
	System.out.println();
	for (char k = 'M' - 1; k >= 'A'; k--) {  					 // Insert second half of the alphabet.
		System.out.println("Adding first: " + k);
		pl.addFirst("" + k);									// addFirst()
		print(pl);
	}
	System.out.println();
	System.out.println("Size: " + pl.size()); 
	System.out.println();
	System.out.println("Is empty: " + pl.isEmpty());  			 // isEmpty()
	System.out.println();
	while (!pl.isEmpty()) {
		System.out.println("First element: " + pl.first().element());    // first().element()
		System.out.println("Removing first element, " + pl.first().element());
		pl.remove(pl.first()); 										// remove(.first())
		print(pl);
		System.out.println("Last element: " + pl.last().element());      // last().element()
		System.out.println("Removing last element, " + pl.last().element());
		pl.remove(pl.last()); 										// remove(.last())
		print(pl);
		}
	System.out.println();
	System.out.println("Is empty: " + pl.isEmpty());
    */
  
  }

}
