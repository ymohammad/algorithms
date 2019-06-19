package imtiaz.tutorial.problemset1;

import java.util.Vector;

public class FormingTwoGroups {

	/**
	 * Given a set of integers, find if it is possible to divide it into two groups such that sum of one 
	 * group is a multiple of 5 and sum of the other is odd.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] setOfInts = {1, -10, 9, 4, 3, 2, 50, 12, 13, -5};
		Vector<Integer> solutionsGroup1 = new Vector<Integer>();
		Vector<Integer> solutionsGroup2 = new Vector<Integer>();
		findTwoGroups(setOfInts, solutionsGroup1, 0, solutionsGroup2, 0, 0);
	}

	private static void findTwoGroups(int[] setOfInts, Vector<Integer> solutionsGroup1, 
			int group1Sum, Vector<Integer> solutionsGroup2, int group2Sum, int currentIndex) {
		if (currentIndex >= setOfInts.length) {
			if ((group1Sum%5 == 0 && group2Sum%2 == 1)) {
				System.out.println("Multiple 5 ::" + solutionsGroup1 + " > Sum :" + group1Sum);
				System.out.println("Odd Group ::" + solutionsGroup2 + " > Sum :" + group2Sum);
			}else if(group1Sum%2==1 && group2Sum%5==0) {
				System.out.println("Multiple 5 ::" + solutionsGroup2 + " > Sum :" + group2Sum);
				System.out.println("Odd Group ::" + solutionsGroup1 + " > Sum :" + group1Sum);
			}

			return;
		}
		Vector<Integer> solutionsGroup1Copy = getCopy(solutionsGroup1);
		Vector<Integer> solutionsGroup2Copy = getCopy(solutionsGroup2);
		
		solutionsGroup1.add(setOfInts[currentIndex]);
		findTwoGroups(setOfInts, solutionsGroup1, group1Sum+setOfInts[currentIndex], solutionsGroup2, group2Sum, currentIndex+1);
		solutionsGroup2Copy.add(setOfInts[currentIndex]);
		findTwoGroups(setOfInts, solutionsGroup1Copy, group1Sum, solutionsGroup2Copy, group2Sum+setOfInts[currentIndex], currentIndex+1);
	}
	
	private static Vector<Integer> getCopy(Vector<Integer> possibleSubsets) {
		Vector<Integer> clone = (Vector<Integer>) possibleSubsets.clone();
		return clone;
	}
}
