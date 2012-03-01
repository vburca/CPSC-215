/* 
 * HW (02/08/2011)
 * Chapter 2 - # R-2.14
 * 
 * @author: Vlad Burca
 * @version: 02/08/2011
 * 
 */

public class Vowels {
  
  public static int countVowels(String s) {
    int nr = 0;
    String vowels = "aeiouAEIOU";
    for (int i = 0; i < s.length(); i++)
      if (vowels.indexOf(s.charAt(i)) >= 0)
        nr++;
    return nr;
  }
  
  public static void main(String[] args) {
    String s = args[0];
    System.out.println("Number of vowels in: " + s);
    System.out.println(countVowels(s));
  }
}
    