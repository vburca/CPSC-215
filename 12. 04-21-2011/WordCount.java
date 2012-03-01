/**
 * @author: Vlad Burca, Brandon Lewis
 * @version: 04-21-2011
 */

/**
 * File: WordCount.java
 * 
 * This Java application counts the occurrence of each word in a given 
 * text file (specified as a command-line argument).
 *
 * @author Takunari Miyazaki
 * @see java.io.File
 * @see java.io.FileInputStream
 * @see java.io.FileNotFoundException
 * @see java.io.IOException
 * @see java.io.InputStreamReader
 * @see java.util.StringTokenizer
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordCount {
  
  /**
   * Main method that read a file, gets the words from it, stores them into a TreeMap;
   * Prints in alphabetical order the entries (word - frequency);
   * Sorts the list of entries;
   * Prints in frequencie order the entries (word - frequency);
   * 
   * @args args[] - String; array of strings that gets the filename from the user.
   */
  public static void main(String args[]) {
    String inString = null;
    if (args.length < 1) {
      System.out.println("Usage: java WordCount sourcefile");
      return;
    }

    // Reads the file named as the command-line argument
    try {
      File f = new File(args[0]);
      InputStreamReader iStream = 
        new InputStreamReader(new FileInputStream(f));
      int length = (int)f.length();
      char input[] = new char[length];
      iStream.read(input);
      inString = new String(input);
      StringTokenizer st = 
        new StringTokenizer(inString, "`~?!*:;,.()- '\"\n");
      
	  String word;
	  TreeMap<String,Integer> map = new TreeMap<String,Integer>();
	  while (st.hasMoreTokens()) {				// Creating the tree of words-frequencies.
	  	word = st.nextToken().toLowerCase();
	  	if (map.containsKey(word)) {
	  		int new_key = map.get(word) + 1;
	  		map.remove(word);
	  		map.put(word, new_key);
	  	}
	  	else {
	  		map.put(word, 1);
	  	}
	  }
	  ArrayList list = new ArrayList(map.entrySet());	// Creating the ArrayList of words-frequencies.
	  System.out.println("Normal printing: ");			
	  System.out.println(list.toString());				// Printing in alphabetical order.
	  System.out.println();
	  System.out.println();
	  
	  MapEntryComparator<Map.Entry<String,Integer>> comparator = new MapEntryComparator<Map.Entry<String, Integer>>();										// Creating the comparator for the ArrayList of words-frequencies.
	  Collections.sort(list, comparator);			// Sorting, in terms of frequencies.
	  System.out.println("Ordered printing: ");
	  System.out.println(list.toString());			// Printing in frequencies order (most to least).
	  System.out.println();
	  

    } 
    catch (FileNotFoundException e) {
      System.err.println("Error: File " + args[0] + " not found");
      e.printStackTrace();
    } 
    catch (IOException e) {
      System.err.println("Error: I/O exception");
      e.printStackTrace();
    }
  }

}
