//
//	Name: 		Phung, Steven
//	Project:	#3
//	Due: 		November 22, 2017
//	Course: 	cs-240-01-F17
//
//	Description:
//				Implementation of class ArrayStack that is the stack ADT, class Expression that deals with a given expression,
//				and class ExpressionTest with a main that tests all the methods of Expression and ArrayStack.
//
package Project3_Stack;

public class Expression<T> extends ArrayStack<T>{
	
	//Method that converts the given array of String into a single String, then converts the infix into a postfix expression using a stack.
	//The String postfix is then converted back into an Array, which is tested with the evaluatePostfixExpression to check for errors.
	//If the conversion is completed without any errors, the new array is returned.
	public static String[] convertToPostfix(String[] infixExpression) {
		ArrayStack<String> operatorStack = new ArrayStack<>(infixExpression.length + 1);
		String[] postfix = new String[infixExpression.length + 1];

		String stringExpression = "", postString = "";
		for (String s : infixExpression) {
			stringExpression += s;
		}
		
		for(int i = 0; i < stringExpression.length(); ++i) {
			char nextCharacter = stringExpression.charAt(i);
			
			switch(nextCharacter) {
			case '(' :
				operatorStack.push(String.valueOf(nextCharacter));
				break;
			case ')' :
				while(!"(".equals(operatorStack.peek())) {
					postString += operatorStack.pop();
				}
				operatorStack.pop();
				break;
			case '+' : case '-' : case '*' : case '/' : case '^' :
				while(!operatorStack.isEmpty() && !("(".equals(operatorStack.peek()) 
						&& precedence(String.valueOf(nextCharacter)) <= precedence(operatorStack.peek()))) {
					postString += operatorStack.pop();
				}
				operatorStack.push(String.valueOf(nextCharacter));
				break;
			default :
				postString += nextCharacter;
				break;
			}
		}
		while(!operatorStack.isEmpty()) {
			postString += operatorStack.pop();
		}
		
		postfix = postString.split(" ");

		if(evaluatePostfix(postfix) == -1) {
			postfix = null;
		}
		
		return postfix;
	}
	
	//Method that utilizes the stack in order to evaluate the given postfix expression. Will return an integer value if postfix expression is
	//correct. If incorrect, will catch exception and display error message and return a -1.
	public static int evaluatePostfix(String[] postfixExpression) {
		ArrayStack<Integer> valueStack = new ArrayStack<>(50);
		boolean validExpression = true;
		int answer = -1;
		
		String stringExpression = "";
		for(String s : postfixExpression) {
			stringExpression += s;
		}
		
		for(int i = 0; i < stringExpression.length(); ++i) {
			char nextCharacter = stringExpression.charAt(i);

			if(!containsOperator(stringExpression)) {
				System.out.println("Invalid Expression: I am missing operators.");
				validExpression = false;
				break;
			}
			
			if(isOperator(nextCharacter)) {
				int rhs = 0, lhs = 0;
				
				if(valueStack.peek() == null) {
					System.out.println("Invalid Expression: I am missing operands.");
					validExpression = false;
					break;
				} else
					rhs = valueStack.pop();
				
				if(valueStack.peek() == null) {
					System.out.println("Invalid Expression: I am missing operands.");
					validExpression = false;
					break;
				} else
					lhs = valueStack.pop();

				switch(nextCharacter) {
				case '+' :
					valueStack.push(lhs + rhs);
					break;
				case '-' :
					valueStack.push(lhs - rhs);
					break;
				case '*' :
					valueStack.push(lhs * rhs);
					break;
				case '/' :
					try {
						if(rhs == 0) {
							throw new RuntimeException();
						} else {
							valueStack.push(lhs / rhs);
						}
					} catch(RuntimeException e) {
						System.out.println("Invalid Expression: I cannot divide by zero.");
						validExpression = false;
					}
					break;
				case '^' :
					int result = 1;
					while(rhs != 0) {
						result *= lhs;
						--rhs;
					}
					valueStack.push(result);
					break;
				default :
					break;
				}
			} else
				valueStack.push(Character.getNumericValue(nextCharacter));
		}
		if(validExpression)
			answer = valueStack.pop();
		return answer;
	}
	
	//Method that controls the precedence of operators.
	private static int precedence(String nextCharacter) {
		if(nextCharacter == "+" || nextCharacter == "-")
			return 1;
		if(nextCharacter == "*" || nextCharacter == "/")
			return 2;
		if(nextCharacter == "^")
			return 3;
		return 0;
	}

	//Method that prints out a String array.
	public static void PrintArray(String [] array) {
		if(array != null) {
			for(int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
			}
			System.out.println("");
		}
	}
	
	//Boolean method that returns true if the given char is considered an operator, false otherwise.
	private static boolean isOperator(char operator) {
		if(operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '^')
			return true;
		return false;
	}
	
	//Boolean method that returns true if a given String contains an operator, false otherwise.
	private static boolean containsOperator(String expression) {
		if(expression.contains("+") || expression.contains("-") || expression.contains("*") ||
				expression.contains("/")|| expression.contains("^")) {
			return true;
		}
		return false;
	}
}