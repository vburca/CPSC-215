/*

Title: 			Tester.java
Author: 		Vlad Burca
				Pauline Lake
Last Modified: 	02/03/2011

*/

/** Test program for the progression classes */

class Tester {

  public static void main(String[] args) {

    Progression prog;

    // test ArithProgression
    System.out.println("Arithmetic progression with default increment:");
    prog = new ArithProgression();
    prog.printProgression(10);
    System.out.println("Arithmetic progression with increment 5:");
    prog = new ArithProgression(5);
    prog.printProgression(10);

    // test GeomProgression
    System.out.println("Geometric progression with default base:");
    prog = new GeomProgression();
    prog.printProgression(10);
    System.out.println("Geometric progression with base 3:");
    prog = new GeomProgression(3);
    prog.printProgression(10);

    // test FibonacciProgression
    System.out.println("Fibonacci progression with default start values:");
    prog = new FibonacciProgression();
    prog.printProgression(10);
    System.out.println("Fibonacci progression with start values 4 and 6:");
    prog = new FibonacciProgression(4,6);
    prog.printProgression(10);
	System.out.println("Fibonacci progression with start values 11 and 16:");
    prog = new FibonacciProgression(11, 16);
    prog.printProgression(11);

// (HW) 02-05-2011
	System.out.println("Fibonacci progression with start values 2 and 2:");
    prog = new FibonacciProgression(2, 2);
    prog.printProgression(8);

/*

	// test Difference
	System.out.println("Difference progression with default start values:");
	prog = new Difference();
	prog.printProgression(20);
	System.out.println("Difference progression with start values 10 and 23:");
	prog = new Difference(10, 23);
	prog.printProgression(20);
	System.out.println("Difference progression with start values 0 and 1:");
	prog = new Difference(0, 1);
	prog.printProgression(20);

	// test Sum
	System.out.println("Sum progression with default start values:");
	prog = new Sum();
	prog.printProgression(10);
	System.out.println("Sum progression with start value 7:");
	prog = new Sum(7);
	prog.printProgression(10);
*/
	// test MyProgression
	System.out.println("MyProgression progression with default (0 and 1) start values:");
	prog = new MyProgression();
	prog.printProgression(20);
	System.out.println("MyProgression progression with default (0 and 1) start values:");
	prog = new MyProgression(3);
	prog.printProgression(20);

//*/

	// TEST
/*
	System.out.println("Arithmetic progression with default (128) increment:");
    prog = new ArithProgression();
    prog.printProgression(2147483647);
	System.out.println("SUCCESS!");
*/
/*
	Long cur = (long)0;
	Long n = Long.MAX_VALUE / 2^7;
	for (long i = 0; i <= n; i++) {
		cur = cur + 128;
		System.out.print(cur + " ");
	}
*/	
/*
    long l = Integer.MAX_VALUE;
	System.out.println();
	System.out.print(" l = ");
	System.out.println(l);
*/	


  }
}
