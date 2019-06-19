package imtiaz.tutorial.problemset1;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Given a set of integers S, find any subset which adds to given target T.
	-> Example:
	-> S = {1, -10, 9, 4, 3, 2, 50, 12, 13, -5}
	-> T = 20
 * @author ymohammad
 *
 */
public class SubsetSumTarget {
	static int target = 20;
	ArrayList<Integer> targetSubSets = new ArrayList<Integer>();
	public static void main(String[] args) {
		int[] problemSet = {1, -10, 9, 4, 3, 2, 50, 12, 13, -5};
		Vector<Integer> possibleSubsets = new Vector<Integer>();
		findTargetSubset(problemSet, possibleSubsets, 0, 0);
	}
	private static void findTargetSubset(int[] problemSet,
			Vector<Integer> possibleSubsets, int subsetSum, int currentInd) {
		if (currentInd >= problemSet.length) {
			if (subsetSum == target) {
				System.out.println(possibleSubsets);
			}
			return;
		}
		
		int newSum = subsetSum + problemSet[currentInd];
		Vector<Integer> copyOfPossibleSubsets = getCopy(possibleSubsets);
		possibleSubsets.add(problemSet[currentInd]);
		currentInd++;
		findTargetSubset(problemSet, possibleSubsets, newSum, currentInd);
		findTargetSubset(problemSet, copyOfPossibleSubsets, subsetSum, currentInd);
	}
	private static Vector<Integer> getCopy(Vector<Integer> possibleSubsets) {
		Vector<Integer> clone = (Vector<Integer>) possibleSubsets.clone();
		return clone;
	}
}
