public class RecursiveProd {

	private long p = 1;
	private int ap, bp;
	
	public RecursiveProd(int a, int b) {
		if (a > b)
			p = rProduct(a, b);
		else
			p = rProduct(b, a);
		System.out.println(" The RecursiveProduct of " + a + " and " + b + " is: " + p);
	}
	
	private int rProduct(int x, int y) {
		if (y == 1)
			return x;
		else
			return x + rProduct(x, y - 1);
	}
	
	public int rSum(int n) {
	if (n == 1)
		return n;
	else 
		return n + rSum(n - 1);
	}
	
	public long rPower(int x, int n) {
	if (n == 1) 
		return x;
	else
		return x * rPower(x, n - 1);
	}
	
	public double rArraySum(double[] A) {
	return rArraySum(A, A.length - 1);
	}
	
	public double rArraySum(double[] A, int n) {
	if (n == 0)
		return A[n];
	else
		return A[n] + rArraySum(A, n - 1);
	}
	
	public static void main (String args[]) {
		RecursiveProd product = new RecursiveProd(2, 100);
		System.out.println(product.rSum(5));
		System.out.println(product.rPower(5,3));
		double[] array = {100, 200, 300, 50, 25, 10, 5, 4, 3, 2, 1};
		System.out.println(product.rArraySum(array));
	}
}
