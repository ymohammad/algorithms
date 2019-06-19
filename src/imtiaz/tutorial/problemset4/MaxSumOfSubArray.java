package imtiaz.tutorial.problemset4;

/**
 * Given an array of integers, find max sum of its subarrays.
 * a[] = {-2, -3, 4, -1, -2, 1, 5, -3}
 * 
 * 
 * Here we have introduced the philosophy of Ends here. Sub Array is nothing but the contigeous values.
 * For example, if a[] is the array given above then its subarrays are.
 * {-2}, {-2, -3}, {-2, -3, 4}......
 * 
 * We can't call {-2, -1 5} is the sub array because the elements are not contigeous.
 * 
 * @author ymohammad
 */
public class MaxSumOfSubArray {
	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		printMaxSubArraySum(a);
		printMaxSumSubArrayNSubArray(a);
	}
	
	private static void printMaxSumSubArrayNSubArray(int[] a) {
		int optimalSolAtHere = a[0];
		int globalMax = a[0];
		int gStartIndex = 0;
		int gEndIndex = 0;
		int sIndexOptimal = 0;
		int eIndexOptimal = 0;
		
		for(int i = 1; i<a.length; i++) {
			
			if ((optimalSolAtHere + a[i]) < a[i]) {
				sIndexOptimal = i;
				eIndexOptimal = i;
				optimalSolAtHere = a[i];
			} else {
				optimalSolAtHere = optimalSolAtHere + a[i];
				eIndexOptimal = i;
			}
			
			if (globalMax < optimalSolAtHere) {
				globalMax = optimalSolAtHere;
				gStartIndex = sIndexOptimal;
				gEndIndex = eIndexOptimal;
			} 
		}
		System.out.println("Maximum Sum = " + globalMax);
		System.out.println("Maximum Sum sub array : " + getArray(a, gStartIndex, gEndIndex));
	}

	public static void printMaxSubArraySum(int a[]) {
		int optimalSolAtHere = a[0];
		int globalMax = a[0];
		
		//As zero index is already considered..
		for(int i = 1; i<a.length; i++) {
			//Find the max between the optimal solution till the index between i-1 and i itself. As i is also a subarray. 
			//By this we know the optimal solution at i. So,this optimal solution will be used by i+1th element.
			optimalSolAtHere = maxOf(optimalSolAtHere + a[i], a[i]);
			globalMax = maxOf(optimalSolAtHere, globalMax);
		}
		System.out.println(globalMax);
	}
	public static int maxOf(int a, int b) {
		int x = a < b ? b : a;
		return x;
	}
	private static String getArray(int[] a, int gStartIndex, int gEndIndex) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int x = gStartIndex; x<=gEndIndex; x++) {
			sb.append(a[x]);
			
			if (x != gEndIndex) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
