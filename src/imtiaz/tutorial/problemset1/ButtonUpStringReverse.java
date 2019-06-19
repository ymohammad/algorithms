package imtiaz.tutorial.problemset1;

public class ButtonUpStringReverse {
	
	public static void main(String[] args) {
		String problem = "abcd";
		String output = reverseString(problem);
		System.out.println(output);
	}

	private static String reverseString(String problem) {
		if (problem == null || problem.length() == 0)
			return "";
		
		String tempSol = reverseString(problem.substring(1));
		return tempSol + problem.charAt(0);
	}
}
