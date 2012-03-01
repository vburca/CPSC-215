/**
 * @author Vlad Burca, Pauline Lake
 * @version 03-16-2011
 */

/**
 * This class is used to check a file (specified by the user, by calling the CheckBrackets file) for
 * the correctness of HTML tags.
 * CheckBrackets.java extends this file.
 */

import java.util.Scanner;

public class CheckTags {
	
  protected static final String optional = "LI, P, TR, TD, li, p, tr, td";	// Set of tags for which the closing tag is optional.	
  protected static final String single = "BR, HR, br, hr";					// Set of tags that do not require a closing tag.
  
  /**
   * Method that strips a given tag, by removing the opening and closing < > symbols.
   * @param t - String
   * @return a string that is situated between the symbols < > in the given string (t)
   */
  private static String stripEnds(String t) {
	if (t.length() <= 2) return null;
	return t.substring(1, t.length() - 1);
  }
  
  /**
   * Method that checks if a given tag is an opening one or not.
   * @param tag - String
   * @return boolean
   */
  private static boolean isOpeningTag(String tag) {
	return (tag.length() == 0 || tag.charAt(0) != '/');
  }
  
  /**
   * Method that checks if two given tags are matching (open, close).
   * @param tag1 - String
   * @param tag2 - String
   * @return boolean
   */
  private static boolean areMatchingTags(String tag1, String tag2) {
	return tag1.equals(tag2.substring(1));
  }
  
  /**
   * Method that checks if the html tags from an array (generated from an HTML file) are correctly matched.
   * @param tag - String[]
   * @param inString - String
   * @return a String that will describe exactly the matching problem
   */
  public static String isHTMLMatched(String[] tag, String inString) {
	ArrayStack<String> st = new ArrayStack<String>();
	for (int k = 0; k < inString.length(); k++) 
		System.out.print(inString.charAt(k));
	System.out.println();
	for (int i = 0; (i < tag.length) && (tag[i] != null); i++) {		// Parse all the tags.
		if (tag[i].charAt(0) != '!')									// If the tag is not a comment check for open / close type.
			if (isOpeningTag(tag[i]))
				st.push(tag[i]);
			else {
				if (st.isEmpty())										// If there is not opening tag, report error.
					return "Unmatched tag at character " + inString.indexOf("<" + tag[i] + ">") + ": No opening tag for " + "<" + tag[i] + ">";
				String expected = st.pop();
				while (single.indexOf(expected) >= 0 || (optional.indexOf(expected) >= 0 && !areMatchingTags(expected, tag[i]))) {		// Ignore all the tags that do not require tags or the optional ones if the closing tag doesn't match.
					if (areMatchingTags(expected, tag[i]) && single.indexOf(expected) >= 0)		// If there is a matching closing tag for a tag that doesn't require a closing tag, report error.
						return "Matching error at character " + inString.indexOf("<" + tag[i] + ">") + ": Found " + "<" + tag[i] + ">" + ", but " + "<" + expected + ">" + " is a single-type tag (it shouldn't have a closing tag)";
					expected = st.pop();
				}
				if (!areMatchingTags(expected, tag[i]) && optional.indexOf(expected) == -1 && single.indexOf(expected) == -1)     // If the closed tag doesn't match the opening tag, report error.
					return "Unmatched tag at character " + inString.indexOf("<" + tag[i] + ">") + ": Found " + "<" + tag[i] + ">" + " expecting " + "</" + expected + ">";
			}
	}
	if (st.isEmpty())
		return "";												// If everything is fine.
	else 
		return "Unclosed tag " + "<" + st.pop() + ">";			// If there is left a not closed tag. 		
  }
  
  
  public final static int CAPACITY = 1000;					// Global variable used for the size of the array of HTML tags.
  
  /**
   * Method that parses a given string and creates an array of HTML tags.
   * @param s - Scanner
   * @return an array of String values, corresponding to the HTML tags from the given file
   */
  public static String[] parseHTML(Scanner s) {
	String[] tag = new String[CAPACITY];
	int count = 0;
	String token;
	while (s.hasNextLine()) {
		while ((token = s.findInLine("<[^>]*>")) != null) 		// Search the string for the HTML tag pattern.
			tag[count++] = stripEnds(token);					// Put the stripped tag into the tags array.
		if (s.hasNextLine())
			s.nextLine();
	}
	return tag;
  }	
		
  /**
   * Method that starts the parsing of the HTML file and that catches the result of the tag checking, displaying it. (it is called from CheckBrackets.java)
   * @param inString - String
   */
  public static void htmlChecking(String inString) {
	String result = "";
	result = isHTMLMatched(parseHTML(new Scanner(inString)), inString);			// Catch error report, if any.
	if (result.equals("")) 					// If no error result, everything is fine.
		System.out.println("REPORT: The source file contains properly balanced brackets.");
	else {									// If not, report the catched error.
		System.out.println(result);
		System.out.println("REPORT: The source file CONTAINS MISMATCHED brackets.");
	}
  }
 
}
