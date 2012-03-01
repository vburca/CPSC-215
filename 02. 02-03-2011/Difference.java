/*

Title: 			Difference.java
Author: 		Vlad Burca
				Pauline Lake
Last Modified: 	02/03/2011

*/

/**
 * Difference Progression
 */


public class Difference extends Progression {

  /** Previous value.  */
	long prev;

  // Inherits variables first and cur.

  /** Default constructor.  */
	Difference() {
		this(1, 100);
	}

  /** Parametric constructor providing the first and second values.
   *
   * @param v1 first value.
   * @param v2 second value.
   */
	Difference(long v1, long v2) {
		first = v1;
		prev = v2 + v1;
	}

 /** Advances the progression to the next value by computing the absolute value of the difference of the previous 2 values.
   *
   * @return next value of the progression
   */
	protected long nextValue() {
		long temp = prev;
		prev = cur;
		if (prev > temp)
			cur = prev - temp;
		else
			cur = temp - prev;
		return cur;
	}

  // Inherits methods firstValue() and printProgression(int).

}
		

	

