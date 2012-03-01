/**
 * File: NodePositionList.java
 * 
 * This class implements the ADT node list using a doubly-linked list.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see BoundaryViolationException
 * @see EmptyListException
 * @see InvalidPositionException 
 */

public class NodePositionList<E> implements PositionList<E> {

  protected int numElts;            	// Number of elements in the list
  protected DNode<E> header, trailer;	// Special sentinels

  /** 
   * Constructor that creates an empty list - O(1) time
   */
  public NodePositionList() {
    numElts = 0;
    header = new DNode<E>(null, null, null);
    trailer = new DNode<E>(header, null, null);
    header.setNext(trailer);
  }

  /** 
   * Checks if position is valid for this list and converts it to DNode if it
   * is valid - O(1) time
   */
  protected DNode<E> checkPosition(Position<E> p)
    throws InvalidPositionException {
    if (p == null)
      throw new InvalidPositionException
	("Null position passed to NodeList");
    if (p == header)
	throw new InvalidPositionException
	  ("The header node is not a valid position");
    if (p == trailer)
	throw new InvalidPositionException
	  ("The trailer node is not a valid position");
    try {
      DNode<E> temp = (DNode<E>) p;
      if ((temp.getPrev() == null) || (temp.getNext() == null))
	throw new InvalidPositionException
	  ("Position does not belong to a valid NodeList");
      return temp;
    } catch (ClassCastException e) {
      throw new InvalidPositionException
	("Position is of wrong type for this list");
    }
  }

  /**
   * Returns the number of elements in the list - O(1) time
   */
  public int size() { return numElts; }

  /**
   * Returns whether the list is empty - O(1) time
   */
  public boolean isEmpty() { return (numElts == 0); }

  /**
   * Returns the first position in the list - O(1) time
   */
  public Position<E> first() throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("List is empty");
    return header.getNext();
  }

  /**
   * Returns the last position in the list - O(1) time
   */
  public Position<E> last() throws EmptyListException {

    // Complete this blank.

    if (isEmpty())
      throw new EmptyListException("List is empty");
    return trailer.getPrev();
  }

  /**
   * Returns the position after the given one - O(1) time
   */
  public Position<E> next(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {

    // Complete this blank.

    DNode<E> v = checkPosition(p);
    DNode<E> next = v.getNext();
    if (next == trailer)
      throw new BoundaryViolationException
	("Cannot advance past the end of the list");
    return next;
  }

  /**
   * Returns the position before the given one - O(1) time
   */
  public Position<E> prev(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {
    DNode<E> v = checkPosition(p);
    DNode<E> prev = v.getPrev();
    if (prev == header)
      throw new BoundaryViolationException
	("Cannot advance past the beginning of the list");
    return prev;
  }

  /**
   * Inserts the given element at the beginning of the list, returning the new
   * position - O(1) time
   */
  public void addFirst(E element) {
    numElts++;
    DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
    header.getNext().setPrev(newNode);
    header.setNext(newNode);
  }

  /**
   * Inserts the given element at the end of the list, returning the new 
   * position - O(1) time
   */
  public void addLast(E element) {

    // Complete this blank.

    numElts++;
    DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, element);
    trailer.getPrev().setNext(newNode);
    trailer.setPrev(newNode);
  }

  /** 
   * Inserts the given element after the given position, returning the new
   * position - O(1) time
   */
  public void addAfter(Position<E> p, E element) 
      throws InvalidPositionException {

    // Complete this blank.

    DNode<E> v = checkPosition(p);
    numElts++;
    DNode<E> newNode = new DNode<E>(v, v.getNext(), element);
    v.getNext().setPrev(newNode);
    v.setNext(newNode);
  }

  /** 
   * Inserts the given element before the given position, returning the new
   * position - O(1) time
   */
  public void addBefore(Position<E> p, E element) 
      throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    numElts++;
    DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
    v.getPrev().setNext(newNode);
    v.setPrev(newNode);
  }

  /**
   * Removes the given position from the list - O(1) time
   */
  public E remove(Position<E> p) throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    numElts--;
    DNode<E> vPrev = v.getPrev();
    DNode<E> vNext = v.getNext();
    vPrev.setNext(vNext);
    vNext.setPrev(vPrev);
    E vElem = v.element();
    v.setNext(null);
    v.setPrev(null);
    return vElem;
  }

  /**
   * Replaces the element at the given position with the new element
   * and return the old element - O(1) time
   */
  public E set(Position<E> p, E element)
      throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    E oldElt = v.element();
    v.setElement(element);
    return oldElt;
  }

  /**
   * Returns an iterator of all the elements.
   */
  public Iterator<E> iterator() {
    return new ElementIterator<E>(this);
  }

}
