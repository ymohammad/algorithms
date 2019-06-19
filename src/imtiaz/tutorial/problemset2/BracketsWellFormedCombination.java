package imtiaz.tutorial.problemset2;

/**
 * Print all well-formed combinations of N {}
	->N = 1 -> {}
	->N = 2 -> {}{}, {{}}
	->N = 3 -> {}{}{}, {}{{}}, {{}}{}, {{}{}}, {{{}}}
 * @author ymohammad
 *
 */
public class BracketsWellFormedCombination {
	
	public static void main(String[] args) {
		printWellFormedBrackets(3, 3, "");
	}
	public static void printWellFormedBrackets(int no, int nc, String sol) {
		if (no == 0 && nc == 0) {
			System.out.println(sol);
			return;
		}
		
		if (no != 0) {
			printWellFormedBrackets(no-1, nc, sol + "{");
		}
		
		if (nc > no) {
			printWellFormedBrackets(no, nc-1, sol + "}");
		}
		
		
	}
}
