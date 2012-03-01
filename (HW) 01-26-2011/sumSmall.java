/*
File: 			sumSmall.java
Author: 		Vlad Burca
Last Modified: 	01/26/2011
*/

public class sumSmall{

	public sumSmall() {

	}

	public int sumSmaller(int n) {
		return n * (n - 1) / 2;
	}

	public static void main(String args[]) {
		sumSmall test = new sumSmall();
		System.out.println(test.sumSmaller(10));
	}
}


		
