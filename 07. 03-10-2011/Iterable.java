/**
 * File: Iterable.java
 *
 * Interface for iterable ADTs.
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 */

public interface Iterable<E> {

  /** Returns an iterator of all the elements. **/
  public Iterator<E> iterator();

}
