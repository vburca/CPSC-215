/**
 * @author: Vlad Burca, Brandon Lewis
 * @version: 04-21-2011
 */

/**
 * File: MapEntryComparator.java
 * 
 * This class defines a comparator for Map.Entry<String, Integer> objects.
 *
 * @author Takunari Miyazaki
 * @see java.util.Comparator
 * @see java.util.Map.Entry
 */

import java.util.*;

public class MapEntryComparator<E> implements Comparator<E> {

  /**
   * Returns a negative integer, zero, or a positive integer as the first 
   * argument is less than, equal to, or greater than the second.
   * @param a - E; where E is a Map.Entry.
   * @param b - E; where E is a Map.Entry.
   * @return 1 if a < b; 0 if a == b; -1 if a > b.
   */
  public int compare(E a, E b) {
	if (((Map.Entry<String,Integer>)a).getValue() < ((Map.Entry<String,Integer>)b).getValue())
		return 1;
	else
		if (((Map.Entry<String,Integer>)a).getValue() == ((Map.Entry<String,Integer>)b).getValue())
			return 0;
		else
			return -1;
  }

}
