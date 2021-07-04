package imtiaz.tutorial.problemset6;

public class LeastNumberCoinsRequired {
	
	public static int countCoins(int s[], int noOfCoins, int target, String str) {
		if (target == 0) {
			return 1;
		}
		
		if (target < 0) {
			return 0;
		}
		return target;
		
		
	}
}
