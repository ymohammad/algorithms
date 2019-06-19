package imtiaz.tutorial.problemset5;

/**
 * Find length of longest common subsequence given two strings.
 * ABCD and ACEB
 * 
 * @author ymohammad
 *
 */
public class TwoStringCommonSubSequence {
	static StringBuffer subSequence = null;
	public static void main(String[] args) {
		String s1 = "ACD";
		String s2 = "ADB";
		
		subSequence = new StringBuffer();
		//System.out.println("Longest Sub Sequence :" + naiveSolution(s1, s2, 1) + " And subsequence is " + subSequence);
		betterSolution(s1, s2);
	}
	
	public static void betterSolution(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] solMatrix = new int[m+1][n+1];
		int x=0;
		while (x < solMatrix.length) {
			solMatrix[x][0] = 0;
			x++;
		}
		x=0;
		while (x < solMatrix.length) {
			solMatrix[0][x] = 0;
			x++;
		}
		
		for(int i = 0; i<m; i++) {
			for(int j = 0; j< n; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					solMatrix[i+1][j+1] = 1 + solMatrix[i][j];
				} else {
					solMatrix[i+1][j+1] = maxOf(solMatrix[i][j+1], solMatrix[i+1][j]);
				}
			}
		}
		System.out.println("Max Sub sequence length :" + solMatrix[m][n]);
	}
	public static int naiveSolution(String s1, String s2, int loop) {
		System.out.println(loop + " > Start ..S1: " + s1 + " >> S2:" + s2);
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
			return 0;
		}
		
		if (s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)) {
			System.out.println(loop + " > Condition is satisfied... S1: " + s1 + " >> S2:" + s2);
			subSequence.append(s1.charAt(s1.length()-1));
			return (1 + naiveSolution(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1), loop+1));
		} else {
			return maxOf(naiveSolution(s1.substring(0, s1.length()-1), s2, loop+1), 
					naiveSolution(s1, s2.substring(0, s2.length()-1), loop+1));
		}
	}
	
	public static int maxOf(int a, int b) {
		return a > b ? a : b;
	}
}
