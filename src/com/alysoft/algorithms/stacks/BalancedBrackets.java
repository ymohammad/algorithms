package com.alysoft.algorithms.stacks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

import com.alysoft.algorithms.stacks.Solution.StackImpl;

/*
 * {[()]}  -- YES
   {[(])}  -- No
   {{[[(())]]}} -- Yes
 */
public class BalancedBrackets {
	private static String[] expectedOutputArr = null;
	private static int progOuputArrIndex = -1;
	/*
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        

        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/Sufi_Docs/git_projects/algorithms/src/com/alysoft/algorithms/stacks/balanced_input.txt"))));
    	
    	String eachLine = br.readLine();
    	int numberOfTS = Integer.parseInt(eachLine);
    	expectedOutputArr = new String[numberOfTS];
    	testOutput();
        while((eachLine = br.readLine()) != null) {
        	String result = isBalanced(eachLine) ;
        	progOuputArrIndex++;
        	validateOuput(result, eachLine);
        }
	}
	private static void testOutput() throws IOException {
    	int arrIndex = 0;
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/Sufi_Docs/git_projects/algorithms/src/com/alysoft/algorithms/stacks/balanced_expected_outs.txt"))));
    	String eachLine = null;
        while((eachLine = br.readLine()) != null) {
        	expectedOutputArr[arrIndex] = eachLine;
        	arrIndex++;
        }
        br.close();
	}
	
	private static boolean validateOuput(String string, String testingString) {
    	if (!string.equals(expectedOutputArr[progOuputArrIndex])) {
    		System.out.println("[Failed] at " + progOuputArrIndex + ", expected value :" + expectedOutputArr[progOuputArrIndex] + ", actual value :" + string);
    		System.out.println("Testing String:" + testingString);
    		return false;
    	} 
    	return true;
	}
	
	private static String isBalanced(String s) {
		char[] eachBracketArr = s.toCharArray(); //s.trim().split("");
		
		if (eachBracketArr.length%2 != 0) {
			return "NO";
		}
		String topBrack = null;
		Stack<String> bracketStack = new Stack<String>();
		int arrLeng = eachBracketArr.length;
		for (int x = 0; x<arrLeng; x++) {
			char eachChar = eachBracketArr[x];
			switch(eachChar) {
			case '{':
			case '(':
			case '[':
				bracketStack.push(String.valueOf(eachChar));
				break;
			case '}':
				if (bracketStack.isEmpty()) {
					return "NO";
				}
				topBrack = bracketStack.peek();
				if (topBrack != null && !topBrack.equals("{")) {
					return "NO";
				}
				bracketStack.pop();
				break;
			case ']':
				if (bracketStack.isEmpty()) {
					return "NO";
				}
				topBrack = bracketStack.peek();
				if (topBrack != null && !topBrack.equals("[")) {
					return "NO";
				}
				bracketStack.pop();
				break;
			case ')':
				if (bracketStack.isEmpty()) {
					return "NO";
				}
				topBrack = bracketStack.peek();
				
				if (topBrack != null && !topBrack.equals("(")) {
					return "NO";
				}
				bracketStack.pop();
				break;
			}
		}
		return bracketStack.empty() ? "YES": "NO";
	}
}
