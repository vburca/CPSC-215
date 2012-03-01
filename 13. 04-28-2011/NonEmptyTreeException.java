/**
 * File: NonEmptyTreeException.java
 *
 * Runtime exception thrown when one tries to perform access operation on a 
 * non-empty tree.
 */

public class NonEmptyTreeException extends RuntimeException {  
  public NonEmptyTreeException(String err) {
    super(err);
  }
}
