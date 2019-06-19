package imtiaz.tutorial.problemset1;

import java.util.ArrayList;

/*
 * Find all subsets of the word “abcd”.
 */
public class SubsetProblem {
	public static void main(String[] args) {
		String completeSet = "abcd";
		String subsetsSol = "";
		createSubsets(completeSet, subsetsSol);
	}

	private static void createSubsets(String problemSet,
			String subsetsSol) {
		if (problemSet == null || problemSet.length() == 0) {
			System.out.println(subsetsSol);
			return;
		}
		createSubsets(problemSet.substring(1), subsetsSol + problemSet.substring(0, 1));
		createSubsets(problemSet.substring(1), subsetsSol);
	}
}
