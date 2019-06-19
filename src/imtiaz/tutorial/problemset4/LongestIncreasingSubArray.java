package imtiaz.tutorial.problemset4;

/**
 * Given an array of integers, find length of longest increasing subarray.
	a[] = {-2, -3, 4, -1, -2, 1, 5, -3};

 * @author ymohammad
 *
 */
public class LongestIncreasingSubArray {

	public static void main(String[] args) {
		
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		printLongestIncreasingSubArray(a);
	}

	private static void printLongestIncreasingSubArray(int[] a) {
		int optimalSolEndsHere = 1;
		int globalLength = 1;
		
		for(int x = 1; x<a.length; x++) {
			optimalSolEndsHere = (optimalSolEndsHere + 1, x);
		}
	}
	
	public static int maxOf(int a, int b) {
		int x = a < b ? b : a;
		return x;
	}
}
