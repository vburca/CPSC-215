/**
 * @author: Vlad Burca
 * @version: 03/31/2011
 */

/*
  Author: Vlad Burca
  Filename: ArrayIndexList.java
  Date: 03/31/2011
*/

/** 
 * File: ArrayIndexList.java
 *
 * Realization of an indexed list by means of an array, which is doubled 
 * when the size of the indexed list exceeds the capacity of the array.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see IndexOutOfBoundsException
 */

public class ArrayIndexList<E> implements IndexList<E> {

  protected E[] A;              // array storing the elements of the list
  protected int capacity = 16;  // initial length of array A
  protected int size = 0;       // number of elements stored in the list

  /** Creates the indexed list with initial capacity 16. 
   */
  public ArrayIndexList() { 
    A = (E[]) new Object[capacity]; // the compiler may warn, but this is ok
  }

  /** Returns the size of the list. 
   */
  public int size() {
    return size;
  }

  /** Checks whether the list is empty. 
   */
  public boolean isEmpty() {
    return (size() == 0);
  }

  /** Checks whether the index r is in the range between 0 and n - 1. 
   * @param r - int 
   * @param n - int
   */
  public void checkIndex(int r, int n) throws IndexOutOfBoundsException {
    if ((r < 0) || (r >= n))
      throw new IndexOutOfBoundsException("Given index is out of bounds.");
  }

  /** Inserts an element at the given index. 
   * @param r - int
   * @param e - E
   */
  public void add(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size() + 1);
    if (size == capacity) {        // an overflow
      capacity *= 2;
      E[] B =(E[]) new Object[capacity];
      for (int i=0; i<size; i++) 
	B[i] = A[i];
      A = B;
    }
    for (int i=size-1; i>=r; i--)  // shift elements up
      A[i+1] = A[i];
    A[r] = e;
    size++;
  }

  /** Returns the element at index r, without removing it. 
   * @param r - int
   * @return A[r] - the element at that position
   */
  public E get(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    return A[r];
  }

  /** Removes the element stored at the given index. 
   * @param r - int
   * @return temp - the removed element
   */
  public E remove(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r];
    for (int i=r; i<size-1; i++)   // shift elements down
      A[i] = A[i+1];
    size--;
    return temp;
  }

  /** Replaces the element f at index r with e, returning f. */
  public E set(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r];
    A[r] = e;
    return temp;
  }

  /** Rearranges all the elements of the list in the reverse order. 
   */
  public void reverse() {
	E[] B = (E[]) new Object[capacity];
	for (int i = size - 1; i >= 0; i--)
		B[(size - 1) - i] = A[i];
	A = B;
  }

  /** Returns an iterator of all the elements. 
   * @return an interator of all the elements.
   */
  public Iterator<E> iterator() {
	return new MyElementIterator<E>(this);
  }

}
