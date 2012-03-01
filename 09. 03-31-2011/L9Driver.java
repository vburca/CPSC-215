/**
 * @author: Vlad Burca
 * @version: 03/31/2011
 */

/*
  Author: Vlad Burca
  Filename: L9Driver.java
  Date: 03/31/2011
*/

public class L9Driver {

  /**
   * Prints all the elements of a given index list using an iterator.
   * @param l - ArrayIndexList<E>
   */
  public static <E> void print(ArrayIndexList<E> l) {
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
   * main function
   * @param args[] - String
   */
  public static void main(String args[]) {

	ArrayIndexList ail = new ArrayIndexList<String>();
	int index = 0;
	System.out.println();
	System.out.println("Regular ArrayIndexList (after each insertion): ");
	for (int i = 1; i <= 10 ; i++) {
		ail.add(index, i);
		print(ail);
		index = index + 1;
	}
	System.out.println();
	System.out.println("Reversed ArrayIndexList: ");
	ail.reverse();
	print(ail);
	ComparableArrayIndexList cail = new ComparableArrayIndexList<Integer>();
	cail.add(0, 2);
	cail.add(1, 5);
	cail.add(2, 6);
	cail.add(3, 1);
	cail.add(4, 8);
	cail.add(5, 9);
	cail.add(6, 7);
	cail.add(7, 4);
	cail.add(8, 3);
	cail.add(9, 10);
	System.out.println();
	System.out.println("Random ComparableArrayIndexList(Integer): ");
	print(cail);
	System.out.println("Sorted ComparableArrayIndexList(Integer): ");
	cail.sort();
	print(cail);
	ComparableArrayIndexList cail2 = new ComparableArrayIndexList<String>();
	cail2.add(0, "a");
	cail2.add(1, "e");
	cail2.add(2, "i");
	cail2.add(3, "z");
	cail2.add(4, "w");
	cail2.add(5, "m");
	cail2.add(6, "l");
	cail2.add(7, "c");
	cail2.add(8, "t");
	cail2.add(9, "s");
	System.out.println();
	System.out.println("Random ComparableArrayIndexList(String): ");
	print(cail2);
	System.out.println("Sorted ComparableArrayIndexList(String): ");
	cail2.sort();
	print(cail2);
 }
 
}
	
	
