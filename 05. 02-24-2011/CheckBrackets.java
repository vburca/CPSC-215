/** 
 * @author: Vlad Burca, Tina Lipson
 * @version: 02-24-2011
 */
 
/*
  Author: Vlad Burca, Tina Lipson
  Date: 02-24-2011
  File: CheckBrackets.java
*/   

/**
 * This program reads a text file specified in a command-line argument 
 * into a string named inString.  It also has a code segment to echo 
 * print inString.  To execute, assuming an input file is named filename 
 * and exists in the same directory as CheckBracket.class, type
 *
 *   java CheckBrackets filename
 * 
 */

import java.io.*;

public class CheckBrackets { 

/**
 * Method that creates a result string in case of an unmatched bracket. The resulting string contains all the 
 * info about the unmatched bracket.
 * @param st - Stack<Character>
 * @param c  - char
 * @param k  - int
 * @return result  - String
 */

  private static String check(Stack<Character> st, char c, int k) {
  	String result = "";
  	if (st.isEmpty() == true)
  		result = "Unmatched bracket at character " + k + ": No opening bracket for " + c;
  	else {
  		char d = st.pop();
  		switch (c) {
  			case ')': if (d != '(') {
  						result = "Unmatched bracket at character " + k + ": Found " + c + " expecting ";
  						switch (d) {
  							case '[': result = result + ']'; break;
  							case '{': result = result + '}'; break;
  						}
  					  } break;
  			case ']': if (d != '[') {
  						result = "Unmatched bracket at character " + k + ": Found " + c + " expecting ";
  						switch (d) {
  							case '(': result = result + ')'; break;
  							case '{': result = result + '}'; break;
  						}
  					  } break;
  			case '}': if (d != '{') {
  						result = "Unmatched bracket at character " + k + ": Found " + c + " expecting ";
  						switch (d) {
  							case '(': result = result + ')'; break;
  							case '[': result = result + ']'; break;
  						}
  					  } break;
  			default: return result;
  		}
  	}
  	return result;
  }		
  		
/**
 * main method that reads an input file, and checks if the configuration of brackets is right; if not, 
 * it displays info about unmatching brackets.
 */
  public static void main(String args[]) {
    String inString = null;
    if (args.length < 1) {
      System.out.println("Usage: java CheckBrackets sourcefile");
      return;
    }

    // Read the file named as the command-line argument
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
	
    // Echo print the file and fill the stack
    Stack<Character> s = new ArrayStack<Character>();
    String result = "";
    for (int k = 0; k < inString.length(); k++) { 
    	if (inString.charAt(k) == '(' || inString.charAt(k) == '[' || inString.charAt(k) == '{')
    		s.push(inString.charAt(k));
    	else if ((inString.charAt(k) == ')' || inString.charAt(k) == ']' || inString.charAt(k) == '}') && result.equals(""))
    		result = check(s, inString.charAt(k), k);			     
      System.out.print(inString.charAt(k));
    }
    System.out.println();
    System.out.println();
    if ((!s.isEmpty()) && result.equals("")) {
     	char d = s.pop();
    	result = "Unmatched bracket " + d + "   Expecting ";
    	switch (d) { 
    		case '(': result = result + ')'; break;
    		case '[': result = result + ']'; break;
    		case '{': result = result + '}'; break;
    	}
    } // not working
	System.out.println(result); 
  }

}
