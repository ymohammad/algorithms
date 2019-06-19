package imtiaz.tutorial.problemset5;

public class LongestCommonSubString {
	
	public static String gLongestSubString = "";
	
	public static void main(String[] args) {
		String s1 = "abed";
		String s2 = "xbef";
		
		//findLongestString(s1, s2, "");
		//System.out.println("Longest Common Sub String is " + gLongestSubString + ", Length is " + gLongestSubString.length());
		matrixFindLongestCommonString(s1, s2);
	}
	
	public static void matrixFindLongestCommonString(String s1, String s2) {
		int longestStr = 0;
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
					longestStr = maxOf(longestStr, solMatrix[i+1][j+1]);
				} else {
					solMatrix[i+1][j+1] = 0;
				}
			}
		}
		System.out.println("Max Sub string length :" + longestStr);
	}
	public static void findLongestString(String s1, String s2, String solution) {
		if (gLongestSubString.length() < solution.length()) {
			gLongestSubString = solution;
		}
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
			return;
		}
		
		if (s1.charAt(0) == s2.charAt(0)) {
			findLongestString(s1.substring(1), s2.substring(1), solution + s1.charAt(0));
		} else {
			findLongestString(s1.substring(1), s2, "");
			findLongestString(s1, s2.substring(1), "");
		}
	}
	
	
	public static int maxOf(int a, int b) {
		return a > b ? a : b;
	}
}
