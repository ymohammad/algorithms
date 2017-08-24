package com.alysoft.algorithms.stacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static String[] progOutput = null;
	private static int progOuputArrIndex = -1;
	private static String[] expectedOutputArr = null;
    public static void main(String[] args) throws IOException {
    	
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/Sufi_Docs/git_projects/algorithms/src/com/alysoft/algorithms/stacks/input_stack_impl.txt"))));
    	
    	String eachLine = br.readLine();
        StackImpl stack = new Solution().new StackImpl(Integer.parseInt(eachLine));
        progOutput = new String[Integer.parseInt(eachLine)];
        expectedOutputArr = new String[Integer.parseInt(eachLine)];
        testOutput();
        while((eachLine = br.readLine()) != null) {
        	if(!performAction(stack, eachLine)) {
        		System.out.println("The Input str line :" + eachLine + " >> Stack Top:" + stack.top + ">> Stack toString :" + stack.toString());
        	}
        }
    }
    
    private static void testOutput() throws IOException {
    	int arrIndex = 0;
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/Sufi_Docs/git_projects/algorithms/src/com/alysoft/algorithms/stacks/expOutput.txt"))));
    	String eachLine = null;
        while((eachLine = br.readLine()) != null) {
        	/*
        	if (!progOutput[arrIndex].equals(eachLine)) {
        		System.out.println("[Failed] at " + arrIndex + ", expected value :" + eachLine + ", actual value :" + progOutput[arrIndex]);
        		break;
        	} else {
        		System.out.println("[Success] " + arrIndex + ", expected value :" + eachLine + ", actual value :" + progOutput[arrIndex]);
        	}*/
        	expectedOutputArr[arrIndex] = eachLine;
        	arrIndex++;
        }
        br.close();
	}

	public static boolean performAction(StackImpl stack, String eachLine) {
		boolean returnResult = true;
    	String[] eachStrArr = eachLine.split(" ");
        int command = Integer.parseInt(eachStrArr[0]);
        switch(command) {
	        case 1:
	        	stack.push(Integer.parseInt(eachStrArr[1]));
	        	break;
	        case 2:
	        	stack.pop();
	        	break;
	        case 3: 
	        	System.out.println(stack.getTopElement());
	        	progOutput[++progOuputArrIndex] = stack.getTopElement()+"";
	        	returnResult = validateOuput(stack.getTopElement()+"");
	        	break;
        }
        return returnResult;
    }
    private static boolean validateOuput(String string) {
    	if (!progOutput[progOuputArrIndex].equals(expectedOutputArr[progOuputArrIndex])) {
    		System.out.println("[Failed] at " + progOuputArrIndex + ", expected value :" + expectedOutputArr[progOuputArrIndex] + ", actual value :" + progOutput[progOuputArrIndex]);
    		return false;
    	} 
    	return true;
	}
	class StackImpl {
    	
    	private int stackSize = 0;
    	private int[] stackItemsArray = null;
    	private int top = -1;
    	private int maxElementInStack = -1;
    	
    	public StackImpl(int stackSize) {
    		this.stackSize = stackSize;
    		this.stackItemsArray = new int[this.stackSize];
    	}
    	
    	public void push(int item) {
    		if (top == this.stackSize-1) {
    			throw new RuntimeException("Stack Overflow Error.");
    		}
    		this.top++;
    		this.stackItemsArray[top] = item;
    		
    		if (this.maxElementInStack < item) {
    			this.maxElementInStack = item;
    		}
    	}
    	
    	public int pop() {
    		if (top == -1) {
    			throw new RuntimeException("Stack is empty.");
    		}
    		int returnValue = this.stackItemsArray[this.top--];
    		if (returnValue == this.maxElementInStack ) {
    			if (this.top > -1) {
	    			this.maxElementInStack = this.stackItemsArray[this.top];
	    			for (int eachElInd = 0; eachElInd < this.top; eachElInd++) {
	    				if (this.maxElementInStack < this.stackItemsArray[eachElInd]) {
	    					this.maxElementInStack = this.stackItemsArray[eachElInd];
	    				}
	    			}
    			} else {
    				this.maxElementInStack = -1;
    			}
    		}
    		return returnValue;
    	}
    	public int getTopElement() {
    		return this.maxElementInStack;
    	}
    	public int size() {
    		return top+1;
    	}
    	public boolean isEmpty() {
    		return top == -1;
    	}
    	@Override
    	public String toString() {
    		StringBuffer buff = new StringBuffer();
    		for (int eachElInd = 0; eachElInd < this.top-1; eachElInd++) {
    			buff.append(this.stackItemsArray[eachElInd]);
			}
    		return buff.toString();
    	}
    }
}
