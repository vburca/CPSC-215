/**
 * @author: Vlad Burca
 * @version: 03/31/2011
 */

/*
  Author: Vlad Burca
  Filename: ComparableArrayIndexList.java
  Date: 03/31/2011
*/

/** 
 * File: ComparableArrayIndexList.java
 *
 * Realization of an indexed list for comparable objects such as integers 
 * and strings.
 *
 * @see ArrayIndexList
 * @see IndexOutOfBoundsException
 */

public class ComparableArrayIndexList<E> extends ArrayIndexList<E> {

  /** Sorts the elements of the list in the increasing order. 
   */
  public void sort() {
  	int sorted = 0;
  	E aux;
  	while (sorted == 0) {
  		sorted = 1;
  		for (int i = 0; i < size - 1; i++)
  			if (((Comparable)A[i]).compareTo((Comparable) A[i + 1]) > 0) {
  				sorted = 0;
  				aux = A[i + 1];
  				A[i + 1] = A[i];
  				A[i] = aux;
  			}
  	}

  }

}
