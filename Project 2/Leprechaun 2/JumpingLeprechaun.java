/**
 * @author 	Alex Zhang;
 *		Vlad Burca.
 * @version 05 - 02 - 2011.
 * File Name: JumpingLeprechaun.java
 */
 
 
import java.util.*;

public class JumpingLeprechaun<E> implements Comparable<E> {

	/**	
	 *	Declaring global variables	
	 */
	private double x;
	private double g = 1000000;
	private JumpingLeprechaun left, right;
	private int index;

	/**
	 *	Constructor method for JumpingLeprechaun.
	 *	Constructs a new JumpingLeprechaun Object based on the given 
	 *	number on JumpingLeprechaun Objects and the given index. It generates a random
	 *	initial horizon value for this specific JumpingLeprechaun Object; sets the 
	 *	left and right leprechauns to null.
	 * 
	 *	@param int n - the number of JumpingLeprechaun Objects;
	 *	@param int i - the index of the specific JumpingLeprechaun Object created;
	 */
	public JumpingLeprechaun(int n, int i) {
		Random generator = new Random();
		double pos = n * generator.nextDouble();
		x = pos;
		index = i;
		left = null;
		right = null;
	}
	
	/**
	 *	jump method for JumpingLeprechaun.
	 *	Calls the setHorizon method with a new horizon value 
	 *	for the JumpingLeprechaun Object.
	 * 
	 *	@param double r - a random integer between -1 and 1;
	 */
	public void jump(double r) {
		setHorizon(x + r * g);
	}
	
	/**
	 *	setHorizon method for JumpingLeprechaun.
	 *	Assigns the JumpingLeprechaun Object's horizon value the received 
	 *	new horizon value.
	 * 
	 *	@param double newPos - a new horizon value based on the formula
	 *							x + r * g;
	 */
	private void setHorizon(double newPos) {
		x = newPos;
	}
	
	/**
	 *	setGold method for JumpingLeprechaun.
	 *	Sets the gold of the JumpingLeprechaun Object to the new given value of gold.
	 * 
	 *	@param double newGold - the new value of gold;
	 */
	public void setGold(double newGold) {
		g = newGold;
	}

	/**
	 *	getHorizon method for JumpingLeprechaun.
	 *	Returns the horizon value of the JumpingLeprechaun Object.
	 * 
	 *	@return double - the value of the horizon instance variable;
	 */
	public double getHorizon() {
		return x;
	}
	
	/**
	 *	getGold method for JumpingLeprechaun.
	 *	Returns the gold value of the JumpingLeprechaun Object.
	 * 
	 *	@return double - the value of the gold instance variable;
	 */
	public double getGold() {
		return g;
	}
	
	/**
	 *	getIndex method for JumpingLeprechaun.
	 *	Returns the index value of the JumpingLeprechaun Object.
	 * 
	 *	@return int - the value of the index instance variable;
	 */
	public int getIndex() {
		return index;
	}
	
	
	/**
	 *	visualize method for JumpingLeprechaun.
	 *	Returns a String representation of the JumpingLeprechaun Object,
	 *	containing the horizon value and the gold value.
	 * 
	 *	@return String - the String representation of the JumpingLeprechaun Object;
	 */
	public String visualize() {
		return "I am Leprechaun: " + index + ", I am at: " + x + " and I have: " + g + " gold.";
	}
	
	/**
	 *	steal method for JumpingLeprechaun.
	 *	Method that calls the leftNeighbor and rightNeighbor methods in order to
	 *	set the left and right instance variable of the JumpingLeprechaun Object.
	 *	It does the "stealing" operations on the left / right neighbors (if they exist),
	 *	by incrementing the current JumpingLeprechaun's Object with half of the gold value of
	 *	left and right; decreasing the value of gold of left and right to one half.
	 *
	 *	@param tm the map in which the Leprechaun is present so that it can find it's relative position
	 */
	public void steal(TreeMap tm) {
		leftNeighbor(tm);
		rightNeighbor(tm);
		if (left == null && right != null) {
			setGold(getGold() + right.getGold());
			right.setGold(0);
		}
		if (left != null && right == null) {
			setGold(getGold() + left.getGold());
			left.setGold(0);
		}
		if (left != null && right != null) {
			setGold(getGold() + right.getGold()/2 + left.getGold()/2);
			right.setGold(right.getGold()/2);
			left.setGold(left.getGold()/2);
		}
	}

	/**
	 *	leftNeighbor method for JumpingLeprechaun.
	 *	Sets the left neighbor of the current JumpingLeprechaun Object, by giving a
	 *	TreeMap Object; it creates a headMap starting with that JumpingLeprechaun Object
	 *	as the root and calls the head.lastKey method in order to get the left neighbor.
	 *
	 *	@param tm the map in which the Leprechaun is present so that it can find it's own neighbors
	 */
	private void leftNeighbor (TreeMap tm) {
		SortedMap head = tm.headMap(x, false);
		if (!head.isEmpty())
			left = (JumpingLeprechaun)tm.get(head.lastKey());
		else
			left = null;
	}
	
	/**
	 *	rightNeighbor method for JumpingLeprechaun.
	 *	Sets the right neighbor of the current JumpingLeprechaun Object, by giving a
	 *	TreeMap Object; it creates a tailMap starting with that JumpingLeprechaun Object
	 *	as the root and calls the tail.firstKey method in order to get the right neighbor.
 	 *
	 *	@param tm the map in which the Leprechaun is present so that it can find it's own neighbors
	 */
	private void rightNeighbor (TreeMap tm) {
		SortedMap tail = tm.tailMap(x, false);
		if (!tail.isEmpty())
			right = (JumpingLeprechaun)tm.get(tail.firstKey());
		else
			right = null;
	}

	public JumpingLeprechaun getRight() {return right;}
	public JumpingLeprechaun getLeft() {return left;}
	
	/**
	 *	compareTo method for JumpingLeprechaun.
	 *	Implements the compareTo method from Comparable interface.
	 *	Compares two horizon values (double).
	 *
	 *	@param e the element getting compared for the put method of the TreeMap
	 *	@return int - an integer value, based on the different of the compared E Objects;
	 */
	public int compareTo(E e) {
		int myhorizon = (int)x;
		double ehorizon = (Double)e;
		int hishorizon = (int)ehorizon;
		return myhorizon - hishorizon;
	}
}
	

