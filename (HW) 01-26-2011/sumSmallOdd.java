/*
File: 			sumSmallOdd.java
Author: 		Vlad Burca
Last Modified: 	01/26/2011
*/

public class sumSmallOdd{

	public sumSmallOdd() {

	}

	public int sumSmallerOdd(int n) {
		int s = 0;
		while (n > 0) {
			n = n - 1;
			if (n % 2 != 0)
				s = s + n;
		}
		return s;
	}

	public static void main(String args[]) {
		sumSmallOdd test = new sumSmallOdd();
		System.out.println(test.sumSmallerOdd(6));
	}
}


		
