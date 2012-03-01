/**
 * File: NodeDeque.java
 *
 * This is a partial implementation of the class NodeDeque.  You are to 
 * complete the implementation in Laboratory 6.
 */
 
/**
 * @author Vlad Burca, Steve Petkovsek
 * @version 03-03-2011
 */


public class NodeDeque<E> implements Deque<E> {

  protected DLNode<E> header, trailer;  // sentinels
  protected int size;                   // number of elements

  /**
   * Constructs a new NodeDeque object.
   */
  public NodeDeque() {
    header = new DLNode<E>();
    trailer = new DLNode<E>();
    header.setNext(trailer);
    trailer.setPrev(header);
    size = 0;
  }
  /**
   * Returns the size of the dequeue.
   * @return the size of the dequeue.
   */
  public int size() {   
    return size;
  }

  /**
   * Checks if the dequeue is empty or not.
   * @return true/false.
   */
  public boolean isEmpty() {    
    if (size == 0)
      return true;
    return false;
  }

  /**
   * Inspects the first element of the dequeue.
   * @return the first element of the dequeue.
   * @exception EmptyDequeException.
   */
  public E getFirst() throws EmptyDequeException {  
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return header.getNext().getElement();
  }

  /**
   * Adds an element at the beginning of the dequeue and increases its size.
   * @param E o .
   */
  public void addFirst(E o) {  
    DLNode<E> second = header.getNext();
    DLNode<E> first = new DLNode<E>(o, header, second);
    second.setPrev(first);
    header.setNext(first);
    size++;
  }

  /**
   * Removes the last element of the dequeue, returns the last element and decreases the size.
   * @return last element.
   * @exception EmptyDequeException.
   */
  public E removeLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> last = trailer.getPrev();
    E o = last.getElement();
    DLNode<E> secondtolast = last.getPrev();
    trailer.setPrev(secondtolast);
    secondtolast.setNext(trailer);
    size--; 
    return o;
  }
  
  /** 
   * Returns the last element; an exception is thrown if deque is empty.
   * @return last element.
   * @exception EmptyDequeException.
   */
  public E getLast() throws EmptyDequeException {
  	if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return trailer.getPrev().getElement();  
  }
  
  /**
   * Inserts an element to be the last in the deque and increases the size.
   * @param E element.
   */
  public void addLast (E element){
  	DLNode<E> secondlast = trailer.getPrev();
  	DLNode<E> last = new DLNode<E>(element, secondlast, trailer);
  	trailer.setPrev(last);
  	secondlast.setNext(last);
  	size++;
  }
  
  /** 
   * Removes the first element; an exception is thrown if deque is empty; the size is decreased.
   * @return the first element.
   * @exception EmptyDequeException.
   */
  public E removeFirst() throws EmptyDequeException {
  	if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> first = header.getNext();
    DLNode<E> second = first.getNext();
   	second.setPrev(header);
   	header.setNext(second);
   	size--;
   	return first.getElement();   	  
  }
  
  /**
   * Converts the dequeue to a string.
   * @return String version of the dequeue.
   */
  public String toString() {
 		String s = "[";
     	DLNode<E> v = header.getNext();
        while (v != trailer) {
   	       s += v.getElement();
           v = v.getNext();
           if (v != trailer)
              s += ",";
        } 
        s += "]";
        return s;	
  }

}
