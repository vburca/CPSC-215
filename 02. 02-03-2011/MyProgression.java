/*

Title: 			MyProgression.java
Author: 		Vlad Burca
				Pauline Lake
Last Modified: 	02/03/2011

*/

/**
 * @author Vlad Burca and Pauline Lake
 * @version February 3, 2011
 */

/**
 * MyProgression Progression
 */

public class MyProgression extends Progression {

  /** Previous value.  */
	long prev;

  // Inherits variables first and cur.

  /** Default constructor.  */
	MyProgression() {
		this(4);
	}
	
  /** Parametric constructor providing the first value.
   *
   * @param base base of the progression.
   */
	MyProgression(long v1) {
		first = v1;
	}

  /** Advances the progression to the next value using the Collatz Conjecture.
   *
   * @return next value of the progression
   */
	protected long nextValue() {
		if (cur % 2 == 0)
			cur = cur / 2;
		else
			cur = 3 * cur + 1;
		return cur;
	}

  // Inherits methods firstValue() and printProgression(int).

}
