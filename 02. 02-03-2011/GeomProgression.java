/**
 * Geometric Progression
 */

class GeomProgression extends Progression {

  // Inherits variables first and cur.

  /** Default constructor setting base 2. */
  GeomProgression() {
    this(2);
  }

  /** Parametric constructor providing the base.
   *
   * @param base base of the progression.
   */
  GeomProgression(long base) {
    first = base;
    cur = first;
  }

  /** Advances the progression by multiplying the base with the current value.
   *
   * @return next value of the progression
   */
  protected long nextValue() {
    cur *= first;
    return cur;
  }

  //  Inherits methods firstValue() and printProgression(int).
}
