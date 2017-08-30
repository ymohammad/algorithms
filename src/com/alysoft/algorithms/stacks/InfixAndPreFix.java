package com.alysoft.algorithms.stacks;

import java.util.Stack;

public class InfixAndPreFix {
	public static void main(String[] args) {
		testInfixToPreFix("a+b*c", "abc*+");
		testInfixToPreFix("a*b+c", "ab*c+");
		testInfixToPreFix("(A+B)", "AB+");
		testInfixToPreFix("(a+b)*c", "ab+c*");
		testInfixToPreFix("(A+B)*(C+D)", "AB+CD+*");
		testInfixToPreFix("A*B+(C-D)", "AB*CD-+");
		testInfixToPreFix("(A+B)*(C-D)", "AB+CD-*");
		testInfixToPreFix("A*B+C*D", "AB*CD*+");
		testInfixToPreFix("A-B*C-D+E/F", "ABC*-D-EF/+");
		testInfixToPreFix("A+(B*C-(D/E-F)*G)*H", "ABC*DE/F-G*-H*+");
		testInfixToPreFix("a+b*(c^d-e)^(f+g*h)-i", "abcd^e-fgh*+^*+i-");
	}
	public static void testInfixToPreFix(String infixExpression, String expectedPostFixExp) {
		String actualPostFiexExp = convertToPreFix (infixExpression);
		System.out.println("Test for " + infixExpression + ": " + (actualPostFiexExp.equals(expectedPostFixExp)));
		//System.out.println("Infix statement " + infixExpression + ", Expected : " + expectedPostFixExp + ", Actual: " + actualPostFiexExp);
		
	}
	public static String convertToPreFix(String infixExpression) {
		String result = null;
		if (infixExpression != null) {
			StringBuffer exprBuffer = new StringBuffer();
			Stack<Character> operatoStacks = new Stack<Character>();
			
			for (int chIndex = 0; chIndex < infixExpression.length(); chIndex++) {
				char expChar = infixExpression.charAt(chIndex);
				
				if (Character.isLetterOrDigit(expChar)) {
					exprBuffer.append(expChar);
				} else {
					switch (expChar) {
					case '+':
					case '-':
					case '/':
					case '*':
					case '^':
					case ')':
					case '(':
						if (operatoStacks.size() == 0 || expChar == '(') {
							operatoStacks.push(expChar);
						} else {
							if (expChar == ')') {
								while (!operatoStacks.isEmpty() && operatoStacks.peek() != '(') {
										exprBuffer.append(operatoStacks.pop());
								}
								operatoStacks.pop();
							} else {
								int currCharPreValue = getOperatorPrecedence(expChar);
								while (!operatoStacks.isEmpty() && getOperatorPrecedence(operatoStacks.peek()) >= currCharPreValue) {
									exprBuffer.append(operatoStacks.pop());
								}
								operatoStacks.push(expChar);
							}
						}
						
						break;
						default:
							throw new RuntimeException("Invalid Operator " + expChar);
					}
				}
				//System.out.println("At chart " + expChar + " > operatoStacks:" + operatoStacks + " > exprBuffer:" + exprBuffer);
			}
			while (!operatoStacks.isEmpty()) {
				exprBuffer.append(operatoStacks.pop());
			}
			result = exprBuffer.toString();
		}
		
		return result;
	}

	private static int getOperatorPrecedence(char stackOp) {
		int precedenceValue = -1;
		switch (stackOp) {
		case '+':
		case '-':
			precedenceValue = 1;
			break;
		case '*':
		case '/':
			precedenceValue = 2;
			break;
		case '^':
			precedenceValue = 3;
			break;
		}
		return precedenceValue;
	}
}
