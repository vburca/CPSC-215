/**
 * @author: Vlad Burca
 * @version: 04-28-2011
 * File Name: L13Driver.java
 */

/**
 * File: L13Driver.java
 *
 * A driver program to test the classes ArrayBinaryTree and ExpressionTree.
 *
 * @author Takunari Miyazaki
 * @see ArrayBinaryTree
 * @see ExpressinTree
 * @see Position
 */

public class L13Driver {

  /** Inserts the prefix expression s into a tree T starting at the root. */
  public static void preOrderBuild(ArrayBinaryTree<Character> T, String s) {
    preOrderBuild(T, T.addRoot(null), s);
  }
  /** Recursively inserts the prefix expression s */
  protected static String preOrderBuild(ArrayBinaryTree<Character> T,
    Position<Character> v, String s) {
    if (s.length() == 0)
      return "";
    if (s.charAt(0) == ' ')
      return preOrderBuild(T, v, s.substring(1));
    else if (Character.isDigit(s.charAt(0))) {
	T.replace(v, new Character(s.charAt(0)));
      return s.substring(1);
    } 
    else {
      T.replace(v, new Character(s.charAt(0)));
      String newS = preOrderBuild(T, T.insertLeft(v, null), s.substring(1));
      return preOrderBuild(T, T.insertRight(v, null), newS);
    }
  }
  /** The main() method. */
  public static void main(String args[]) {

    ArrayBinaryTree<Character> bt1 = new ArrayBinaryTree<Character>();
    System.out.println("New tree: " + bt1.toString());
    System.out.println("Inserting * as the root.");
    Position<Character> p = bt1.addRoot(new Character('*'));
    System.out.println("New tree: " + bt1.toString());
    System.out.println("Inserting 2 as the left child of *.");
    bt1.insertLeft(p, new Character('2'));
    System.out.println("New tree: " + bt1.toString());
    System.out.println("Inserting + as the right child of *.");
    p = bt1.insertRight(p, new Character('+'));
    System.out.println("New tree: " + bt1.toString());
    System.out.println("Inserting 6 as the left child of +.");
    bt1.insertLeft(p, new Character('6'));
    System.out.println("New tree: " + bt1.toString());
    System.out.println("Inserting 5 as the right child of +.");
    bt1.insertRight(p, new Character('5'));
    System.out.println("New tree: " + bt1.toString());
    System.out.println("Prefix: " + bt1.preorder().toString());
    System.out.println("Postfix: " + bt1.postorder().toString());

    ArrayBinaryTree<Character> bt2 = new ArrayBinaryTree<Character>(1000);
    String exp = "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6";
    System.out.println("Inserting in preorder: " + exp);
    preOrderBuild(bt2, exp);
    System.out.println("New tree: " + bt2.toString());
    System.out.println("Prefix: " + bt2.preorder().toString());
    System.out.println("Postfix: " + bt2.postorder().toString());

    // Add a code segment to test the class ExpressionTree using the 
    // expression "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6".
    
    ExpressionTree bt3 = new ExpressionTree();
    String exp3 = "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6";
    preOrderBuild(bt3, exp3);
    System.out.println("EVAL: " + bt3.eval());

  }

}
