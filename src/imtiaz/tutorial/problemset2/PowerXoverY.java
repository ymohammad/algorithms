package imtiaz.tutorial.problemset2;

public class PowerXoverY {

	public static void main(String[] args) {
		power(2, 60, 1);
	}
	public static void power(int x, int y, long sol) {
		
		if (y == 0) {
			System.out.println(sol);
			return;
		}
		
		power(x, y-1, sol*x);
	}
}
