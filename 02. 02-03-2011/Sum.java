/*

Title: 			Sum.java
Author: 		Vlad Burca
				Pauline Lake
Last Modified: 	02/03/2011

*/

/**
 * Sum Progression
 */


public class Sum extends Progression {

  /** Sum of the previous values.  */
	long s;

  // Inherits variables first and cur.

  /** Default constructor.  */
	Sum() {
		this(1);
	}
	
  /** Parametric constructor providing the first value.
   *
   * @param base base of the progression.
   */
	Sum(long i) {
		first = i;
		s = i;
	}

  /** Advances the progression to the next value by adding the sum of the previous values.
   *
   * @return next value of the progression
   */
	protected long nextValue() {
		cur = s;
		s = s + cur;
		return cur;
	}

  // Inherits methods firstValue() and printProgression(int).

}
		
