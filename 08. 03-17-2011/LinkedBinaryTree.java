/**
 * @author Vlad Burca, Alex Zhang
 * @version 03-17-2011
 */

/**
 * File: LinkedBinaryTree.java
 *
 * An implementation of the BinaryTree interface by means of a linked 
 * structure.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see BinaryTree
 * @see BoundaryViolationException
 * @see BTPosition
 * @see EmptyTreeException
 * @see InvalidPositionException
 * @see Iterable
 * @see Iterator
 * @see NodePositionList
 * @see NonEmptyTreeException
 * @see Position
 * @see PositionList
 */

public class LinkedBinaryTree<E> implements BinaryTree<E> {

  protected BTPosition<E> root;	// reference to the root
  protected int size;		// number of nodes

  /**  Creates an empty binary tree. */
  public LinkedBinaryTree() { 		    
    root = null;                // start with an empty tree
    size = 0;
  }

  /** Returns the number of nodes in the tree. */
  public int size() {
    return size; 
  }

  /** Returns whether the tree is empty. 
   * @return boolean
   */
  public boolean isEmpty() {
    return (size == 0);
  }

  /** Returns whether a node is internal. 
   * @param v - Position<E>
   * @return boolean
   */
  public boolean isInternal(Position<E> v) throws InvalidPositionException {
    checkPosition(v);           // auxiliary method
    return (hasLeft(v) || hasRight(v));
  }

  /** Returns whether a node is external.
   * @param v - Position<E>
   * @return boolean
   */
  public boolean isExternal(Position<E> v) throws InvalidPositionException {	
	checkPosition(v);
	return (!hasLeft(v) && !hasRight(v));

  }

  /** Returns whether a node is the root. 
   * @param v - Position<E>
   * @return boolean
   */
  public boolean isRoot(Position<E> v) throws InvalidPositionException { 
    checkPosition(v);
    return (v == root()); 
  }

  /** Returns whether a node has a left child. 
   * @param v - Position<E>
   * @return boolean
   */
  public boolean hasLeft(Position<E> v) throws InvalidPositionException { 
    BTPosition<E> vv = checkPosition(v);
    return (vv.getLeft() != null);
  }

  /** Returns whether a node has a right child. 
   * @param v - Position<E>
   * @return boolean
   */
  public boolean hasRight(Position<E> v) throws InvalidPositionException { 		
	BTPosition<E> vv = checkPosition(v);
	return (vv.getRight() != null);

  }

  /** Returns the root of the tree. 
   * @return root - Position<E>
   */ 
  public Position<E> root() throws EmptyTreeException {
    if (root == null)
      throw new EmptyTreeException("The tree is empty");
    return root;
  } 

  /** Returns the left child of a node.
   * @param v - Position<E>
   * @return left position - Position<E>
   */
  public Position<E> left(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException { 
    BTPosition<E> vv = checkPosition(v);
    Position<E> leftPos = vv.getLeft();
    if (leftPos == null)
      throw new BoundaryViolationException("No left child");
    return leftPos;
  }

  /** Returns the right child of a node. 
   * @param v - Position<E>
   * @return right position - Position<E>
   */
  public Position<E> right(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException {				
	BTPosition<E> vv = checkPosition(v);
	Position<E> rightPos = vv.getRight();
	if (rightPos == null)
		throw new BoundaryViolationException("No right child");
	return rightPos;

  }  

  /** Returns the parent of a node. 
   * @param v - Position<E>
   * @return parent position - Position<E>
   */
  public Position<E> parent(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException { 
    BTPosition<E> vv = checkPosition(v);
    Position<E> parentPos = vv.getParent();
    if (parentPos == null)
      throw new BoundaryViolationException("No parent");
    return parentPos; 
  }

  /** Returns an iterable collection of the children of a node. 
   * @param v - Position<E>
   * @return children - Iterable<Position<E>>
   */
  public Iterable<Position<E>> children(Position<E> v) 
    throws InvalidPositionException { 
    PositionList<Position<E>> children = new NodePositionList<Position<E>>();
    if (hasLeft(v))
      children.addLast(left(v));
    if (hasRight(v))
      children.addLast(right(v));
    return children;
  }

  /** Returns an iterable collection of the tree nodes. 
   * @return positions - Iterable<Position<E>>
   */
  public Iterable<Position<E>> positions() {
    PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
    if(size != 0)
      preorderPositions(root(), positions);
    return positions;
  }

  /** Returns an iterator of the elements stored at the nodes. 
   * @return elements iterator - Iterator<E>
   */
  public Iterator<E> iterator() {
    Iterable<Position<E>> positions = positions();
    Iterator<Position<E>> i = positions.iterator();
    PositionList<E> elements = new NodePositionList<E>();
    while (i.hasNext())
      elements.addLast((i.next()).element());
    return elements.iterator();
  }

  /** Replaces the element at a node. 
   * @param v - Position<E>
   * @param o - E
   * @return the replaced element - E
   */
  public E replace(Position<E> v, E o) 
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    E temp = v.element();
    vv.setElement(o);
    return temp;
  }

  // Additional accessor method
  /** Return the sibling of a node 
   * @param v - Position<E>
   * @return the position of the siblings - Position<E>
   */
  public Position<E> sibling(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException {
      BTPosition<E> vv = checkPosition(v);
      BTPosition<E> parentPos = vv.getParent();
      if (parentPos != null) {
	BTPosition<E> sibPos;
	BTPosition<E> leftPos = parentPos.getLeft();
	if (leftPos == vv)
	  sibPos = parentPos.getRight();
	else
	  sibPos = parentPos.getLeft();
	if (sibPos != null)
	  return sibPos;
      }
      throw new BoundaryViolationException("No sibling");
  }

  // Additional update methods
  /** Adds a root node to an empty tree 
   * @param e - E
   * @return the position root - Position<E>
   */
  public Position<E> addRoot(E e) throws NonEmptyTreeException {
    if(!isEmpty())
      throw new NonEmptyTreeException("Tree already has a root");
    size = 1;
    root = createNode(e,null,null,null);
    return root;
  }

  /** Inserts a left child at a given node. 
   * @param v - Position<E>
   * @param e - E
   * @return the inserted position - Position<E>
   */
  public Position<E> insertLeft(Position<E> v, E e)
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    Position<E> leftPos = vv.getLeft();
    if (leftPos != null)
      throw new InvalidPositionException("Node already has a left child");
    BTPosition<E> ww = createNode(e, vv, null, null);
    vv.setLeft(ww);
    size++;
    return ww;
  }

  /** Inserts a right child at a given node. 
   * @param v - Position<E>
   * @param e - E
   * @return the inserted position - Position<E>
   */
  public Position<E> insertRight(Position<E> v, E e)							// DONE
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    Position<E> rightPos = vv.getRight();
    if (rightPos != null)
    	throw new InvalidPositionException("Node already has a right child");
    BTPosition<E> ww = createNode(e, vv, null, null);
    vv.setRight(ww);
    size++;
    return ww;
  }

  /** Removes a node with zero or one child. 
   * @param v - Position<E>
   * @return the removed element - E
   */
  public E remove(Position<E> v)
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    BTPosition<E> leftPos = vv.getLeft();
    BTPosition<E> rightPos = vv.getRight();
    if (leftPos != null && rightPos != null)
      throw new 
        InvalidPositionException("Cannot remove node with two children");
    BTPosition<E> ww; 	        // the only child of v, if any
    if (leftPos != null)
      ww = leftPos;
    else if (rightPos != null)
      ww = rightPos;
    else 		        // v is a leaf
      ww = null;
    if (vv == root) { 	        // v is the root
      if (ww != null)
	ww.setParent(null);
      root = ww;
    }
    else { 		        // v is not the root
      BTPosition<E> uu = vv.getParent();
      if (vv == uu.getLeft())
	uu.setLeft(ww);
      else
	uu.setRight(ww);
      if(ww != null)
	ww.setParent(uu);
    }
    size--;
    return v.element();
  }

  /** Attaches two trees to be subtrees of an external node. 
   * @param v - Position<E>
   * @param T1 - BinaryTree<E>
   * @param T2 - BinaryTree<E>
   */
  public void attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) 
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    if (isInternal(v))
      throw new InvalidPositionException("Cannot attach from internal node");
    if (!T1.isEmpty()) {
      BTPosition<E> r1 = checkPosition(T1.root());
      vv.setLeft(r1);
      r1.setParent(vv);		// T1 should be invalidated
    }
    if (!T2.isEmpty()) {
      BTPosition<E> r2 = checkPosition(T2.root());
      vv.setRight(r2);
      r2.setParent(vv);		// T2 should be invalidated
    }
  }

  /** If v is a good node, cast to BTPosition, else throw exception. 
   * @param v - Position<E>
   * @return a binary tree position of the corresponding position of the given node- BTPosition<E> 
   */
  protected BTPosition<E> checkPosition(Position<E> v) 
    throws InvalidPositionException {
    if (v == null || !(v instanceof BTPosition))
      throw new InvalidPositionException("The position is invalid");
    return (BTPosition<E>) v;
  }

  /** Creates a new binary tree node 
   * @param element - E
   * @param parent - BTPosition<E>
   * @param left - BTPosition<E>
   * @param right - BTPosition<E>
   * @return a binary tree position for the created node - BTPosition<E>
   */
  protected BTPosition<E> createNode(E element, BTPosition<E> parent, 
    BTPosition<E> left, BTPosition<E> right) {
    return new BTNode<E>(element,parent,left,right);
  }

  /** Creates a list of the nodes in the subtree of a node in preorder. 
   * @param v - Position<E>
   * @param pos - PositionList<Position<E>>
   */
  protected void preorderPositions(Position<E> v, 
    PositionList<Position<E>> pos) 
    throws InvalidPositionException {
    pos.addLast(v);
    if (hasLeft(v))
      preorderPositions(left(v), pos);
    if (hasRight(v))
      preorderPositions(right(v), pos);
  }

}
