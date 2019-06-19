package imtiaz.tutorial.problemset1;

public class ReverseString {
	public static void main(String[] args) {
		String str = "abcd";
		reverseString(str, "");
	}

	private static void reverseString(String str, String sol) {
		if (str == null || str.length() == 0) {
			System.out.println(sol);
			return;
		}
		
		reverseString(str.substring(0, str.length()-1), sol+str.charAt(str.length()-1));
	}
}
