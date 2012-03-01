/*

Title: 			GCD.java
Author: 		Vlad Burca
				Chris Buesser
Last Modified: 	01/27/2011

*/



/**
 * This class computes the Greatest Common Divisor (GCD) in three ways: 
 *                              - using a bruteforce method;
 * 								- using the Euclidean Algorithm;
 *                              - using a recursive version of the Euclidean Algorithm.
 * 
 * @author Vlad Burca, Chris Buesser
 * version 1.0, 01/27/2011
 * @see java.io.InputStreamReader
 * @see java.io.BufferedReader
 * @see Integer
 * @see String
 */


import java.io.*;                       // Java I/O classes

public class GCD {

  public GCD() {}                       // Default constructor

  /**
   * bruteForceGcd() computes and returns gcd(m, n) by simply enumerating 
   * all common divisors of n and m and return the largest of all such 
   * divisors.
   */
  public int bruteForceGcd(int m, int n) {
	for (int i = m; i >= 2; i--)
			if ((m % i) == 0 && (n % i) == 0)
				return i;
    return 1;
  }

  /**
   * euclideanGcd() computes and returns gcd(m, n), where m < n, using 
   * the Euclidean algorithm.
   */
  public int euclideanGcd(int m, int n) {
	int x = m;
	int y = n;
	int r;
	while (x != 0) {
		r = y % x;
		y = x;
		x = r;
	}
	return y;
  }

  /**
   * recursive_euclideanGcd() computes and returns gcd(m, n), where m < n, using 
   * a recursive version of the Euclidean algorithm.
   */
  public int recursive_euclideanGcd(int m, int n) {
    if (m == 0)
        return n;
    else
        return recursive_euclideanGcd(n % m, m);
  }
    

  public static void main(String argv[]) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String inputString;
    int m, n;                           // Integers m and n such that m < n

    System.out.println("This program assumes m < n.");
    System.out.print("Enter an integer value for m: ");
    inputString = input.readLine();
    m = Integer.parseInt(inputString);
    System.out.print("Enter an integer value for n: ");
    inputString = input.readLine();
    n = Integer.parseInt(inputString);

    GCD gcd = new GCD();
    int bf = gcd.bruteForceGcd(m, n);
    int euclidean = gcd.euclideanGcd(m, n);
    int rec_euclidean = gcd.recursive_euclideanGcd(m, n);
    System.out.println("By the brute-force method, gcd(" + m + ", " + n + ") = " + bf + ".");
    System.out.println("By the Euclidean algorithm, gcd(" + m + ", " + n + ") = " + euclidean + ".");
    System.out.println("By the recursive Euclidean algorithm, gcd(" + m + ", " + n + ") = " + rec_euclidean + ".");
  } // main()

} // GCD
