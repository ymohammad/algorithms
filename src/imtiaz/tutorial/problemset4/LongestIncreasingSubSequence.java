package imtiaz.tutorial.problemset4;

import java.util.ArrayList;

/**
 * Given an array of integers, find length of longest increasing subsequence.
	a[] = {-2, -3, 4, -1, -2, 1, 5, -3};

 * @author ymohammad
 *
 */
public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		//int a[] = {-2, -3, 4};
		printLongestIncreasingSubSequence(a, a.length);
	}

	private static void printLongestIncreasingSubSequence(int[] a, int size) {
		int[] LISS = new int[size];
		
		for(int x: LISS) {
			LISS[x] = 1;
		}
		
		int maxSoFar = 1;
		ArrayList<Integer> globalMaxSeqIndices = null;
		for (int i = 1; i<size; i++) {
			ArrayList<Integer> longestSubSequense = new ArrayList<Integer>();

			for (int j = 0; j<i; j++) {
				if (a[i] > a[j] && LISS[j] + 1 > LISS[i]) {
					LISS[i] = LISS[j] + 1;
					longestSubSequense.add(j);
				}
			}
			
			//Initial Addition as we considered for all indices of a.
			longestSubSequense.add(i);
			
			if (LISS[i] > maxSoFar) {
				maxSoFar = LISS[i];
				globalMaxSeqIndices = longestSubSequense;
			}
		}
		//printArray(LISS);
		System.out.println("Length :" + maxSoFar);
		System.out.println("Longest Sub Sequence :" + getArrayAsString(a, globalMaxSeqIndices));
	}
	

	private static String getArrayAsString(int[] a, ArrayList<Integer> globalMaxSeqIndeces) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int x = 0; x<globalMaxSeqIndeces.size(); x++) {
			sb.append(a[globalMaxSeqIndeces.get(x)]);
			if (x < globalMaxSeqIndeces.size()-1) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	private static void printArray(int[] lISS) {
		for(int x: lISS) {
			System.out.print(x + " ");
		}
	}
}
