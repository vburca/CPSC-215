/**
 * @author: Vlad Burca
 * @version: 04-28-2011
 * File Name: ArrayBinaryTree.java
 */


/**
 * File: ArrrayBinaryTree.java
 *
 * A speedy implementation of the BinaryTree interface using an array.  
 * Within the array, there is a null element at index 0, the root of the tree 
 * at index 1, and the rest of the tree is contained as follows.  If node n 
 * has index i, then the left child of n will have index 2i, and the right 
 * child of n will have index 2*i + 1.  Traversing the contents of the array
 * in order of increasing index yields a level-order traversal.
 *
 * @author Takunari Miyazaki
 * @see ArrayIndexList
 * @see BinaryTree
 * @see BoundaryViolationException
 * @see EmptyTreeException
 * @see IndexList
 * @see InvalidPositionException
 * @see Iterable
 * @see Iterator
 * @see NonEmptyTreeException
 * @see Position
 */

public class ArrayBinaryTree<E> implements BinaryTree<E>  {

  public static final int CAP = 100; // the default capacity of an array
  protected Position<E> T[];         // an array of tree positions
  protected int size;                // the number of nodes
  protected int maxIndex;            // the maximum index of a node

  /** Nested class for an array-based binary tree node. */
  protected static class BTPos<E> implements Position<E> {
    E element;      // element stored at this position
    int index;      // index of this position in the array
    public BTPos(E elt, int i) { 
      element = elt;
      index = i; 
    }
    public E element() { return element; }
    public int index() { return index; }
    public E setElement(E elt) {
      E temp = element;
      element = elt;
      return temp;
    }
    public String toString() {
      return("(" + element + ", " + index + ")");
    }
  }

  /** default constructor */
  public ArrayBinaryTree() { 
    T = (Position<E>[]) new Position[CAP];
    T[0] = null; // the location at index 0 is deliberately empty
    size = 0;
    maxIndex = 0;
  }
  /** parametric constructor */
  public ArrayBinaryTree(int cap) { 
    T = (Position<E>[]) new Position[cap];
    T[0] = null; // the location at index 0 is deliberately empty
    size = 0;
    maxIndex = 0;
  }
  /** Returns the number of (internal and external) nodes. */
  public int size() { return size; } 
  /** Returns whether the tree is empty. */ 
  public boolean isEmpty() { return (size == 0); }
  /** Updates maxIndex. */
  protected void updateMaxIndex(int i) { if (i > maxIndex) maxIndex = i; } 
  /** Determines whether the given position is a valid node. */
  protected BTPos<E> checkPosition(Position<E> v) 
    throws InvalidPositionException {
    if (v == null || !(v instanceof BTPos))
      throw new InvalidPositionException("Position is invalid");
    return (BTPos<E>) v;
  }
  /** Returns whether v is an internal node. */
  public boolean isInternal(Position<E> v) throws InvalidPositionException {
    return hasLeft(v);  // if v has a right child it will have a left child
  }
  /** Returns whether v is an external node. */
  public boolean isExternal(Position<E> v) throws InvalidPositionException {
    return !isInternal(v);
  }
  /** Returns whether v is the root node. */
  public boolean isRoot(Position<E> v) throws InvalidPositionException { 
    BTPos<E> vv = checkPosition(v);
    return vv.index() == 1;
  }
  /** Returns whether v has a left child. */
  public boolean hasLeft(Position<E> v) throws InvalidPositionException { 
    BTPos<E> vv = checkPosition(v);
    if (2*vv.index() > maxIndex) return false;
    else return (T[2*vv.index()] != null);
  }
  /** Returns whether v has a right child. 
   * @param v - Position<E>
   * @return boolean 
   */
  public boolean hasRight(Position<E> v) throws InvalidPositionException { 			// DONE
	BTPos<E> vv = checkPosition(v);
	if (2*vv.index() + 1 > maxIndex) return false;
	else return (T[2*vv.index() + 1] != null);
    // Complete this method.

  }
  /** Returns the root of the tree. */
  public Position<E> root() throws EmptyTreeException {
    if (isEmpty()) throw new EmptyTreeException("Tree is empty");
    return T[1];
  }
  /** Returns the left child of v. */
  public Position<E> left(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException { 
    if (!hasLeft(v)) throw new BoundaryViolationException("No left child");
    BTPos<E> vv = checkPosition(v);
    return T[2*vv.index()];
  }
  /** Returns the right child of v. 
   * @param v - Position<E>
   * @return Position<E> - right child of v.
   */ 
  public Position<E> right(Position<E> v) 											// DONE
    throws InvalidPositionException, BoundaryViolationException {
	if (!hasRight(v)) throw new BoundaryViolationException("No right child");
	BTPos<E> vv = checkPosition(v);
	return T[2*vv.index() + 1];
    // Complete this method.

  }
  /** Returns the parent of v. */
  public Position<E> parent(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException { 
    if (isRoot(v)) throw new BoundaryViolationException("No parent");
    BTPos<E> vv = checkPosition(v);
    return T[vv.index()/2];
  }
  /** Returns an iterable collection of the children of v. */ 
  public Iterable<Position<E>> children(Position<E> v) 
    throws InvalidPositionException { 
    IndexList<Position<E>> children = new ArrayIndexList<Position<E>>();
    if (hasLeft(v))
      children.add(children.size(), left(v));
    if (hasRight(v))
      children.add(children.size(), right(v));
    return children;
  }
  /** Returns an iterable collection of all the nodes in the tree. */
  public Iterable<Position<E>> positions() {
    IndexList<Position<E>> P = new ArrayIndexList<Position<E>>();
    for (int i = 1; i <= maxIndex; i++)
      if (T[i] != null)
        P.add(P.size(), T[i]);
    return P;
  }
  /** Returns an iterator of the elements stored at all nodes in the tree. */
  public Iterator<E> iterator() { 
    IndexList<E> list = new ArrayIndexList<E>();
    for (int i = 1; i <= maxIndex; i++)
      if (T[i] != null)
        list.add(list.size(), T[i].element());
    return list.iterator();
  } 
  /** Replaces the element at v. */
  public E replace(Position<E> v, E o) throws InvalidPositionException {
    BTPos<E> vv = checkPosition(v);
    return vv.setElement(o);
  }
  /** Adds an element at the root. */
  public Position<E> addRoot(E e) {
    if (!isEmpty()) throw new NonEmptyTreeException("Tree is not empty");
    BTPos<E> p = new BTPos<E>(e, 1);
    T[1] = p;
    size++;
    updateMaxIndex(1);
    return p;
  }
  /** Inserts a new node with an element e at the left child of v. */
  public Position<E> insertLeft(Position<E> v, E e) {
    if (hasLeft(v)) 
      throw new InvalidPositionException("Node already has a left child.");
    BTPos<E> vv = checkPosition(v);
    int i = 2*vv.index();
    BTPos<E> p = new BTPos<E>(e, i);
    T[i] = p;
    size++;
    updateMaxIndex(i);
    return p;
  }
  /** Inserts a new node with an element e at the right child of v. 
   * @param v - Position<E>
   * @param e - E
   * @return Position<E> - a Position object of the inserted node.
   */
  public Position<E> insertRight(Position<E> v, E e) {									// DONE
	if (hasRight(v))
		throw new InvalidPositionException("Node already has a left child.");
	BTPos<E> vv = checkPosition(v);
	int i = 2*vv.index() + 1;
	BTPos<E> p = new BTPos<E>(e, i);
	T[i] = p;
	size++;
	updateMaxIndex(i);
	return p;
    // Complete this method.

  }
  /** Returns a String represention of the tree. */
  public String toString() {
    if (isEmpty())
      return "[]";
    StringBuffer sb = new StringBuffer("[");
    for (int i = 0; i <= maxIndex; i++) {
      if (T[i] != null)
        sb.append(T[i].toString());
      else        
        sb.append("null");
      if (i < maxIndex)
        sb.append(", ");
    }
    return sb.toString() + "]";
  }
  /** Returns an iterable collection of the elements in preorder. 
   * @return Iterable<E> - an Iterable collection of elements in preorder.
   */
  public Iterable<E> preorder() {												// DONE
	ArrayIndexList<E> preo = new ArrayIndexList<E>();
	preorder(root(), preo);
	return preo;
    // Complete this method.

  }
  
  /** Returns an iterable collection of the elements in preorder. 
   * @param v - Position<E>
   * @param posAL - ArrayIndexList<E>
   */
  protected void preorder(Position<E> v, ArrayIndexList<E> preoAL) throws InvalidPositionException {
  	preoAL.add(preoAL.size(), v.element());
  	if (hasLeft(v))
  		preorder(left(v), preoAL);
  	if (hasRight(v))
  		preorder(right(v), preoAL);
  }      
      
  /** Returns an iterable collection of the elements in postorder. 
   * @return Iterable<E> - an Iterable collection of elements in postorder.
   */
  public Iterable<E> postorder() {												// DONE
	ArrayIndexList<E> poso = new ArrayIndexList<E>();
	postorder(root(), poso);
	return poso;
    // Complete this method.

  }
  
  /** Returns an iterable collection of the elements in postorder. 
   * @param v - Position<E>
   * @param posAL - ArrayIndexList<E>
   */
  protected void postorder(Position<E> v, ArrayIndexList<E> posoAL) throws InvalidPositionException {
  	if (hasLeft(v))
  		postorder(left(v), posoAL);
  	if (hasRight(v))
  		postorder(right(v), posoAL);
  	posoAL.add(posoAL.size(), v.element());
  }

} 
