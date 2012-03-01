/*
File: 			Even.java
Author: 		Vlad Burca
Last Modified: 	01/26/2011
*/

public class Even{

	public Even() {

	}

	public boolean isEven(int i) {
		if ((i & 1) == 1)
			return false;
		else
			return true;
	}

	public static void main(String args[]) {
		Even test = new Even();
		System.out.println(test.isEven(124));
	}
}


		
