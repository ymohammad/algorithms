package com.alysoft.algorithms.stacks;

import java.util.Stack;

public class PostFixEvaluation {
	public static final int UNIARY = 1;
	public static final int BINARY = 2;
	public static void main(String[] args) {
		System.out.println("Output of 321*+ :" + evaluatePostFix("321*+"));
		System.out.println("Output of 231*+9- :" + evaluatePostFix("231*+9-"));
	}
	
	public static int evaluatePostFix(String postFixExpression) {
		Stack<Integer> operandStack = new Stack<Integer>();
		if (postFixExpression != null && postFixExpression.trim().length() > 0) {
			
			
			for (int chInd = 0; chInd<postFixExpression.length(); chInd++) {
				char eachCh = postFixExpression.charAt(chInd);
				
				if (Character.isDigit(eachCh)) {
					operandStack.push(Character.getNumericValue(eachCh));
				} else {
					if (getOperatorType(eachCh) == BINARY) {
						if (operandStack.isEmpty() || operandStack.size() < 2) {
							throw new RuntimeException("Invalid Postfix Expression.");
						} else {
							int operandB = operandStack.pop();
							int operandA = operandStack.pop();
							int evaluatedValue = getEvaluatedValue(eachCh, operandA, operandB);
							operandStack.push(evaluatedValue);
						}
					} else {
						
					}
				}
			}
		}
		
		return operandStack.pop();
	}

	private static int getEvaluatedValue(char operator, int operandA, int operandB) {
		int result = 0;
		switch (operator) {
		case '+':
			result = (operandA+operandB);
			break;
		case '-':
			result = (operandA-operandB);
			break;
		case '*':
			result = (operandA*operandB);
			break;
		case '/':
			result = (operandA/operandB);
			break;
		case '^':
			System.out.println("In the block of ^ operandA :" + operandA + ">> operandB:" + operandB);
			result = (operandA^operandB);
			System.out.println("Got the value " + result);
			break;
		}
		return result;
	}

	private static int getOperatorType(char operator) {
		int result = -1;
		switch (operator) {
		case '+':
		case '-':
		case '/':
		case '*':
		case '^':
			result = BINARY;
			break;
		}
		return result;
	}
}
