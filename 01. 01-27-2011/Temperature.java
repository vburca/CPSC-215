/*

Title: 			Temperature.java
Author: 		Vlad Burca
				Chris Buesser
Last Modified: 	01/27/2011

*/

/**
 * This class converts a temperature from Fahrenheit to Celsius.
 * 
 * @author Vlad Burca Chris Buesser
 * version 1.0, 01/27/2011
 * @see java.io.InputStreamReader
 * @see java.io.BufferedReader
 * @see Integer
 * @see String
 */

import java.io.*;		// Java I/O classes

public class Temperature {

	public static void main(String argv[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputString;
		int temperature;	// The input temperature

		System.out.print("Input a temperature in Fahrenheit: ");
		inputString = input.readLine();
		temperature = Integer.parseInt(inputString);
		System.out.print(temperature);
		System.out.print(" degrees in Fahrenheit is ");
		System.out.print((5.0 * (temperature - 32.0)) / 9.0);
		System.out.println(" degrees in Celsius.");
	} // main()

} // Temperature
