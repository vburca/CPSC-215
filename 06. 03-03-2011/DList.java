/** Doubly linked list with nodes of type DNode storing strings. */
public class DList<E> {
  protected int size;			// number of elements
  protected DLNode<E> header, trailer;	// sentinels

  /** Constructor that creates an empty list */
  public DList() { 
    size = 0;
    header = new DLNode(null, null, null);	// create header
    trailer = new DLNode(null, header, null);	// create trailer
    header.setNext(trailer);  // make header and trailer point to each other
  }

  /** Returns the number of elements in the list */
  public int size() { return size; }
  /** Returns whether the list is empty */

  public boolean isEmpty() { return (size == 0); }
  /** Returns the first node of the list */

  public DLNode<E> getFirst() throws IllegalStateException {
    if (isEmpty()) throw new IllegalStateException("List is empty");
    return header.getNext();
  }

  /** Returns the last node of the list */
  public DLNode<E> getLast() throws IllegalStateException {
    if (isEmpty()) throw new IllegalStateException("List is empty");
    return trailer.getPrev();
  }

  /** Returns the node before the given node v. An error occurs if v
    * is the header */
  public DLNode<E> getPrev(DLNode v) throws IllegalArgumentException {
    if (v == header) throw new IllegalArgumentException
      ("Cannot move back past the header of the list");
    return v.getPrev();
  }

  /** Returns the node after the given node v. An error occurs if v
    * is the trailer */
  public DLNode<E> getNext(DLNode v) throws IllegalArgumentException {
    if (v == trailer) throw new IllegalArgumentException
      ("Cannot move forward past the trailer of the list");
   return v.getNext();
  }

 /** Inserts the given node z before the given node v. An error
    * occurs if v is the header */
  public void addBefore(DLNode<E> v, DLNode<E> z) throws IllegalArgumentException {
    DLNode u = getPrev(v);     // may throw an IllegalArgumentException
    z.setPrev(u);
    z.setNext(v);
    v.setPrev(z);
    u.setNext(z);
    size++;
  }

  /** Inserts the given node z after the given node v. An error occurs
    * if v is the trailer */
  public void addAfter(DLNode<E> v, DLNode<E> z) {
    DLNode w = getNext(v);    // may throw an IllegalArgumentException
    z.setPrev(v);
    z.setNext(w);
    w.setPrev(z);
    v.setNext(z);
    size++;
  }

  /** Inserts the given node at the head of the list */
  public void addFirst(DLNode<E> v) {
    addAfter(header, v);
  }

  /** Inserts the given node at the tail of the list */
  public void addLast(DLNode<E> v) {
    addBefore(trailer, v);
  }

  /** Removes the given node v from the list. An error occurs if v is
    * the header or trailer */
  public void remove(DLNode<E> v) {
    DLNode<E> u = getPrev(v);  // may throw an IllegalArgumentException
    DLNode<E> w = getNext(v);  // may throw an IllegalArgumentException
    // unlink the node from the list 
    w.setPrev(u);
    u.setNext(w);
    v.setPrev(null);
    v.setNext(null);
    size--;
  }

 /** Returns whether a given node has a previous node */
  public boolean hasPrev(DLNode<E> v) { return v != header; }
  /** Returns whether a given node has a next node */

  public boolean hasNext(DLNode<E> v) { return v != trailer; }
  /** Returns a string representation of the list */

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