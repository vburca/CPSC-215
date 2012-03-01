// HOMEWORK: R-4.11, R-4.14, R-4.17, R-4.19, R-4.20; C-4.12 
/*
 * @author: Vlad Burca
 * @version: 02-22-2011
 */
 
// R-4.11
// ******
/* The sum of all even numbers from 0 to 2n:
   0 + 2 + 4 + ... + 2n = 2 * ( 1 + 2 + ... + n ) = 2 * (n(n+1)/2) = n * (n + 1).
   The sum of all even numbers from 0 to 2n = n * (n + 1).
*/

// R-4.14
// ******
/* Suppose that d(n) is O(f(n)). This implies that there exist two integers,
  c and n0, such that: d(n) <= c * f(n), for all n >= n0. Therefore, multiplying
  both sides by the integer a (a > 0), we get:  a * d(n) <= a * c * f(n), for 
  all n >= n0. Since a, c are integers, a * c will be an integer, let's say k. 
  Thus, with a * c = k integet, we can re-write the inequality as follows:
  a * d(n) <= k * f(n), for all n >= n0, where k is an integer. Therefore, using 
  the definition of the O-Notation, we now know that a * d(n) is O(f(n)), for any
  constant a > 0.
 */

// R-4.17
// ******
/* O(n/2).   (O(n))
*/

// R-4.19
// ******
/* O(n).   
*/

// R-4.20
// ******
/* O(n^3).
*/

// C-4.12
// ******
/* An efficient way of finding both the minimum and maximum of n numbers, using 
  fewer than 3n/2 comparisons, is to create 2 other groups (minimums and maximums) 
  of numbers from the given set of n numbers. To do so, we start from both ends of 
  the given set and compare the numbers two by two; the bigger one will go in the
  maximum group and the smaller one will go in the minimum group. Therefore, now
  we have n/2 comparisons. Furthermore, each of these groups will have app. n/2 
  elements. Now, by comparing the elements in the maximum group (n/2 comparisons), 
  we will get the maximum number of the maximum group and, obviously, this will be
  the maximum number of the whole set of n numbers; similarly, comparing the elements
  from the minimum group (n/2 comparisons), we will get the minimum number of the 
  minimum group and, obviously, this will be the minimum number of the whole set of
  n numbers. Therefore, we have used app. n/2 + n/2 + n/2 = 3n/2 comparisons.
*/
	
	
