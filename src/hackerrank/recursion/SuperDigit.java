package hackerrank.recursion;

import java.util.Scanner;

/**
 * Given an integer, we need to find the super digit of the integer.

	We define super digit of an integer  using the following rules:
	
	If  has only  digit, then its super digit is .
	Otherwise, the super digit of  is equal to the super digit of the digit-sum of . Here, digit-sum of a number is defined as the sum of its digits.
	For example, super digit of  will be calculated as:
	
	super_digit(9875) = super_digit(9+8+7+5) 
	                  = super_digit(29) 
	                  = super_digit(2+9)
	                  = super_digit(11)
	                  = super_digit(1+1)
	                  = super_digit(2)
	                  = 2.
 * Src: https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 * 
 * @author ymohammad
 *
 */
public class SuperDigit {
	
    static void digitSum(String n, int k, long sum) {
    	if ((n == null || n.trim().length() == 0) && k == 0) {
    		//Verify if Sum is 1 digit or not.
    		if ((sum + "").length() > 1 ) {
    			digitSum(sum + "", 0, 0);
    			return;
    		}
    		//Result is one digit.. print.
    		System.out.println(sum);
    		return;
    	} else if (n == null || n.trim().length() == 0) {
    		//Multiply the calculated sum with k.
    		sum = sum*k;
    		digitSum(sum + "", 0, 0);
    		return;
    	}
    	
    	digitSum(n.substring(1), k, Integer.parseInt(n.charAt(0)+ "") + sum);
    }
    /*
    static void digitSum(String n, int k, long sum) {
    	System.out.println("N :" + n + ">>> k:" + k + ">>> sum:" + sum);
    	if ((n == null || n.trim().length() == 0) && k == 0) {
    		//Verify if Sum is 1 digit or not.
    		if ((sum + "").length() > 1 ) {
    			digitSum(sum + "", 0, 0);
    			return;
    		}
    		//Result is one digit.. print.
    		System.out.println(sum);
    		return;
    	} else if (n == null || n.trim().length() == 0) {
    		//Multiply the calculated sum with k.
    		sum = sum*k;
    		System.out.println("Multiplied :" + sum);
    		digitSum(sum + "", 0, 0);
    		return;
    	}
    	for(int x=0; x<n.length(); x++) {
    		sum += Integer.parseInt(n.charAt(x)+ "");
    	}
    	System.out.println("Calculated Sum :" + sum + ">> k:" + k);
    	digitSum("", k, sum);
    }*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        digitSum(n, k, 0);
        in.close();
    }
}
