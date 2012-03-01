/**
 * @author Vlad Burca, Alex Zhang
 * @version 03-17-2011
 */

/**
 * File: L8Driver.java
 *
 * This is a driver program to test your implementation of the class 
 * LinkedBinaryTree.
 *
 * @author Takunari Miyazaki
 * @see Character
 * @see Iterable
 * @see Iterator
 * @see LinkedBinaryTree
 * @see Position
 * @see String
 * @see Tree
 */

public class L8Driver {

  /**
   * This method constructs an arithmetic expression tree of an infix 
   * arithmetic expression s by simply calling the recursive version of the 
   * same method. 
   * @param T - LinkedBinaryTree<Character>
   * @param s - String
   */
  public static void preorderAET(LinkedBinaryTree<Character> T, String s) {
    preorderAET(T, T.addRoot(null), s);
  }

  /**
   * This method recursively constructs an arithmetic expression tree of an 
   * infix arithmetic expression s starting at a position v.
   * @param T - LinkedBinaryTree<Character>
   * @return preorder AET String for the tree T)
   */
  public static String preorderAET(LinkedBinaryTree<Character> T, 
    Position<Character> v, String s) {
    if (s.length() == 0)
      return "";
    if (s.charAt(0) == ' ')
      return preorderAET(T, v, s.substring(1));  // Skip spaces.
    else if (Character.isDigit(s.charAt(0))) {
      T.replace(v, (new Character(s.charAt(0))));
      return s.substring(1);
    }
    else {
      T.replace(v, (new Character(s.charAt(0))));
      T.insertLeft(v, null);
      T.insertRight(v, null);
      String t = preorderAET(T, T.left(v), s.substring(1));
      return preorderAET(T, T.right(v), t);
    }
  }

  /**
   * This method prints all the elements of the tree T in preorder.
   * @param T - LinkedBinaryTree<E>
   */
  public static <E> void preorderPrint(LinkedBinaryTree<E> T) {
	Iterator<E> i = T.iterator();
	while (i.hasNext())
		System.out.println(i.next());
  }

  /**
   * This method returns the indented parenthetic string representation of 
   * the tree T.
   * @param T - Tree<E>
   * @return a String - IPSR representation 
   */
  public static <E> String IPSR(Tree<E> T) {
	return IPSR(T, T.root(), 0);
  }
  
  /**
   * This method returns the indented parenthetic string representation of 
   * the tree T.
   * @param T - Tree<E>
   * @param v - Position<E>
   * @param depth - int
   * @return a String - IPSR representation 
   */
  public static <E> String IPSR(Tree<E> T, Position<E> v, int depth) {
  	String r = v.element().toString();
  	if (T.isInternal(v)) {
  		boolean firstTime = true;
  		Iterable<Position<E>> ii = T.children(v);
  		Iterator<Position<E>> i = ii.iterator();
  		while (i.hasNext()) {
  			Position<E> w = i.next();
  	  		if (firstTime) {
  				r = r + " ( " + IPSR(T, w, depth + 1);
  				firstTime = false;
  			} else {
  				r = r + "\n" + space(depth) + IPSR(T, w, depth + 1) + " )";
  			}
  		}
  	}
  	return r;
  }
  
  /** 
   * Method for creating depth-coresponding spacing
   * @param k - int
   * @return a String of spaces that coresponds to the "    " * depth value
   */
  private static String space(int k) {
  	if (k == 0)
  		return "    ";
  	else
  		return "    " + space(k - 1);
  }

  /**
   * This main method tests the class LinkedBinaryTree using the example 
   * from Figure 7.11, p. 301, of our main textbook.
   */
  public static void main(String[] args) {
    LinkedBinaryTree<Character> bt = new LinkedBinaryTree<Character>();
    preorderAET(bt, "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6");
    preorderPrint(bt);
    System.out.println();
    System.out.println(IPSR(bt));
    System.out.println();
  }

}
