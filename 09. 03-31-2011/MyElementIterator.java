/**
 * @author: Vlad Burca
 * @version: 03/31/2011
 */

/*
  Author: Vlad Burca
  Filename: MyElementIterator.java
  Date: 03/31/2011
*/

public class MyElementIterator<E> implements Iterator<E> {

  protected IndexList<E> list;  // the underlying list
  protected int cursor;    // the next position

  /** Creates an element iterator over the given list. 
   * @param L - IndexList<E>
   */
  public MyElementIterator(IndexList<E> L) {
    list = L;
    cursor = (list.isEmpty())? -1 : 0;
  }

  /** Tests whether there are elements left in the iterator. 
   * @return boolean
   */
  public boolean hasNext() { return (cursor != -1); }

  /** Returns the next element in the iterator. 
   * @return toReturn - the next element
   */
  public E next() throws IndexOutOfBoundsException {
    if (cursor == -1)
      throw new IndexOutOfBoundsException("No next element");
    E toReturn = list.get(cursor);
    cursor = (cursor == (list.size() - 1))? -1 : (cursor + 1);
    return toReturn;
  }

}
