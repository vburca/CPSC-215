/**
 * @author Vlad Burca, Pauline Lake
 * @version 03-16-2011
 */

/**
 * This program reads a text file specified in a command-line argument 
 * into a string named inString.  It also has a code segment to echo 
 * print inString.  To execute, assuming an input file is named filename 
 * and exists in the same directory as CheckBracket.class, type
 *
 *   java CheckBrackets filename
 *
 * In order to check an HTML file for HTML tags, type
 * 
 *	 java CheckBrackets filename [html]
 *
 * After any of there checks, you will receive a detailed report of the 
 * brackets / tags checkings.
 * 
 */

import java.io.*;

public class CheckBrackets extends CheckTags{

  protected static final String open = "([{";
  protected static final String closed = ")]}";

  /**
   * Method for testing if the closed brackets match the open ones.
   * @param st - ArrayStack
   * @param ch - char
   * @param k - int
   * @param r - String
   * @return a String that will describe exactly the matching problem
   */
  private static String checkClosed(ArrayStack st, char ch, int k, String r) {
	if (st.isEmpty())													// If there is nothing to match it with.
		r = "Unmatched bracket at character " + k + ": No opening bracket for " + ch + ". ";
	else {
		String order = ")(][}{";
		if (st.top().equals(order.charAt(order.indexOf(ch) + 1)))    	// If it equals the opening bracket.
			st.pop();
		else 
			r = "Unmatched bracket at character " + k + ": Found " + ch + " expecting " + order.charAt(order.indexOf((Character)st.top()) - 1) + ". ";
	}
	return r;
  }

  /**
   * Method that parses a string and collects all the brackets (opened and closed); also, it catches the result of the brackets checking and displays it.
   * @param inString - String
   */
  private static void bracketsChecking(String inString) {
	ArrayStack<Character> st = new ArrayStack<Character>();
	String result = "";
    for (int k = 0; k < inString.length(); k++) {						// Parsing the string.
		if (open.indexOf(inString.charAt(k)) >= 0)						// If the character is an open bracket.	
			st.push(inString.charAt(k));
		else
		if (closed.indexOf(inString.charAt(k)) >= 0 && result.equals("")) // If it is a closed bracket and didn't get an error yet.
				result = checkClosed(st, inString.charAt(k), k, result);		// Catch error report, if any.
		System.out.print(inString.charAt(k));
	}
	System.out.println();
	System.out.println();
	if (!st.isEmpty() && result.equals(""))									// If there are unopened brackets left.
		result = "Unclosed bracket " + open.charAt(open.indexOf((Character)st.top())) + ". ";
	if (result.equals("")) 													// If everything is fine.
		System.out.println("REPORT: The source file contains properly balanced brackets.");
	else {																	// If the parsing detected unmatching tags.
		System.out.println(result);
		System.out.println("REPORT: The source file CONTAINS MISMATCHED brackets.");
	}
  } 
	
  /**
   * Main method for CheckBrackets.java
   * @param args[] - String
   */
  public static void main(String args[]) throws IOException {
    String inString = null;
    if (args.length < 1) {
      System.out.println("Usage: java CheckBrackets sourcefile");
      return;
    }

    // Read the file named as the command-line argument.
    try {
      File f = new File(args[0]);
      InputStreamReader iStream = new InputStreamReader(new FileInputStream(f));
      int length = (int)f.length();
      char input[] = new char[length];
      iStream.read(input);
      inString = new String(input);
    } 
    catch (FileNotFoundException e) {
      System.err.println("Error: File " + args[0] + " not found");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.err.println("Error: I/O exception");
      e.printStackTrace();
    }
	System.out.println();
	// Depending on the user input arguments, check for java brackets or for html tags.
	if (args.length == 2 && args[1].equals("[html]")) {
		htmlChecking(inString);				// Call the HTML tag checking.
	}
	else
		bracketsChecking(inString);			// Call the Java bracket checking.
  }

}
