/**
 * @author: Vlad Burca
 * @version: 04-28-2011
 * File Name: ExpressionTree.java
 */


/**
 * File: ExpressionTree.java
 *
 * A subclass of ArrayBinaryTree to represent simple arithmetic expressions.
 *
 * @author Takunari Miyazaki
 * @see ArrayBinaryTree
 * @see EmptyTreeException
 */
 
import java.lang.*;

public class ExpressionTree extends ArrayBinaryTree {

  /** Evaluates the value of the entire expression tree. 
   * @return int - the value of the entire expression tree.
   */
  public int eval() throws EmptyTreeException {
	return eval(root());
    // Complete this method.

  }
  /** Recursively evaluates the value of the subtree rooted at v. 
   * @param v - Position
   * @return int - the value of the subtree rooted at v.
   */
  private int eval(Position v) {
	if (!hasLeft(v) && !hasRight(v)) {
		char digit = (Character)v.element();
		return Character.getNumericValue(digit); 
	}
	else return eval((Character)v.element(), eval(left(v)), eval(right(v)));		
	
    // Complete this method.

  }
  /** Evaluates expressions of the form "op l r" for +, -, *, and /. 
   * @param c - char
   * @param l - int
   * @param r - int
   * @return int - the value of the expresion: l [c] r, where [c] can be {+, -, *, /}.
   */
  private int eval(char c, int l, int r) {								// DONE
	switch (c) {
		case '+': return l + r;
		case '-': return l - r;
		case '*': return l * r;
		case '/': return l / r;
		default: return -1;
	}
    // Complete this method.

  }

}
