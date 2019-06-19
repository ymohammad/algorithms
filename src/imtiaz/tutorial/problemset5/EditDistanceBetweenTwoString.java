package imtiaz.tutorial.problemset5;

public class EditDistanceBetweenTwoString {

	public static void main(String[] args) {
		String s1 = "sunday";
		String s2 = "saturday";
		
		//int noOfOperations = editString(s1, s2, s1.length(), s2.length());
		int noOfOperations = editDistanceUsingDP(s1, s2, s1.length(), s2.length());
		System.out.println("No. of Operations :" + noOfOperations);
	}
	public static int editDistanceUsingDP(String s1, String s2, int m, int n) {
		int dp[][] = new int[m+1][n+1];
		
		for(int i = 0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0){
					dp[i][j] = j;
				}
				else if(j==0) {
					dp[i][j] = i;
				} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + minOf(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	public static int editString(String s1, String s2, int m, int n) {
		if (m == 0) {
			return n;
		}
		
		if ( n == 0)
			return m;
		
		
		if (s1.charAt(m-1) == s2.charAt(n-1)) {
			return editString(s1, s2, m-1, n-1);
		} else {
			// If last characters are not same, consider all three
		    // operations on last character of first string, recursively
		    // compute minimum cost for all three operations and take
		    // minimum of three values.
			return 1 + minOf(
					editString(s1, s2, m, n-1), // add
					editString(s1, s2, m-1, n-1), // replace
					editString(s1, s2, m-1, n)  // delete
					);
		}
	}

	private static int minOf(int a, int b, int c) {
		if (a < b && a < c) {
			return a;
		} else if (b < a && b < c) {
			return b;
		} else {
			return c;
		}
	}
}
