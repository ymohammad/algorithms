package imtiaz.tutorial.problemset2;

/**
 * Print all permutation of nABC
 * 
 * aabbcc = 6!/2!*2!*2!
 * 
 * @author ymohammad
 *
 */
public class PermutationNABC {
	static int count = 0;
	public static void main(String[] args) {
		int noOfABC = 2;
		printNAbc(noOfABC, noOfABC, noOfABC, "");
		System.out.println("Total Permutations :" + count);
	}
	
	public static void printNAbc(int na, int nb, int nc, String sol) {
		if(na == 0 && nb == 0 && nc == 0) {
			System.out.println(sol);
			count++;
			return;
		}
		if (na != 0) {
			printNAbc(na-1, nb, nc, sol + "a");
		}
		
		if (nb != 0) {
			printNAbc(na, nb-1, nc, sol + "b");
		}
		
		if (nc != 0) {
			printNAbc(na, nb, nc-1, sol + "c");
		}
		
	}
}
