package imtiaz.tutorial.problemset1;

public class Anagram {

	static int noOfIterations = 0;
	/**
	 * Find all anagrams of the word “abcd”.
	 * @param args
	 */
	public static void main(String[] args) {
		String word = "abc";
		findAnagram(word, "");
		System.out.println("Anagram.main() No. of iterations:" + noOfIterations);
	}

	private static void findAnagram(String problem, String solution) {
		if (problem == null || problem.trim().length() == 0) {
			System.out.println(solution);
			return;
		}
		for(int eachInd = 0; eachInd < problem.length(); eachInd++) {
			noOfIterations++;
			StringBuilder problemMutable = new StringBuilder(problem);
			problemMutable.deleteCharAt(eachInd);
			findAnagram(problemMutable.toString(), solution + problem.charAt(eachInd));
		}
	}
}
