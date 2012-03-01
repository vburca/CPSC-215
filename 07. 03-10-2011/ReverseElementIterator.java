/**
 * @author: Vlad Burca, Rahul Chatterjee
 * @version: 03-10-2011
 */

/**
 * File: ReverseElementIterator.java
 *
 * This class implements a reversed iterator for the ADT node list.
 *
 */

public class ReverseElementIterator<E> implements Iterator<E> {

  protected PositionList<E> list;  // the underlying list
  protected Position<E> cursor;    // the next position

  /** Creates a reversed element iterator over the given list. 
   * @param L - PositionList<E>
   */
  public ReverseElementIterator(PositionList<E> L) {
    list = L;
    cursor = (list.isEmpty())? null : list.last();
  }

  /** Tests whether there are elements left in the iterator. 
   * @return boolean
   */
  public boolean hasNext() { return (cursor != null); }

  /** Returns the next element in the iterator. 
   * @return toReturn - E
   * @see NoSuchElementException
   */
  public E next() throws NoSuchElementException {
    if (cursor == null)
      throw new NoSuchElementException("No next element");
    E toReturn = cursor.element();
    cursor = (cursor == list.first())? null : list.prev(cursor);
    return toReturn;
  }

}
