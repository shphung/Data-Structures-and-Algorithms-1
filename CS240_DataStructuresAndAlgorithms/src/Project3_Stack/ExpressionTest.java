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

public class ExpressionTest {

	public static void main(String[] args) {
		//Prints required I/O
		printRequiredIO();
		
		//Runs Expression class with correct infix expressions.
		testCorrectNumbers();
		
		//Test runs given an incorrect infix expression that is dividing by zero.
		testDivideByZero();
		
		//Test runs given an incorrect infix expression missing operands.
		testMissingOperands();
		
		//Test runs given an incorrect infix expression missing operators.
		testMissingOperators();
	}
	
	private static void printRequiredIO() {
		System.out.println("S. Phung's Infix to Postfix Converter");
		System.out.println("-------------------------------------");
	}
	
	private static void testCorrectNumbers() {
		String[] infix1 = "(80 + ( 63 - 54 ) )".split(" ");
		String[] infix2 = "( 92 + 58 ) / ( 74 - 64 )".split(" ");
		String[] infix3 = "95 / ( 84 - 73 ) * 62".split(" ");
		String[] infix4 = "99 - ( 80 / ( 78 - 61 ) * 57 + 42 ) ^ 36".split(" ");
		String[] infix5 = "( 90 - 81 * 72 ) / ( 63 * 54 ^ 45 * 36 + 27 )".split(" ");
		
		System.out.println("Testing Expressions with Numbers");
		System.out.println("--------------------------------");
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix1);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix1));
		System.out.println();		
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix2);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix2));
		System.out.println();		
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix3);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix3));
		System.out.println();		
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix4);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix4));
		System.out.println();		
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix5);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix5));
		System.out.println();
	}
	
	private static void testDivideByZero() {
		String[] infix1 = "20 / 0".split(" ");
		String[] infix2 = "5 / 5 / 0".split(" ");
		String[] infix3 = "32 / 35 / 0".split(" ");
		
		System.out.println("Testing Expressions with Division Errors");
		System.out.println("----------------------------------------");
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix1);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix1));
		System.out.println();		
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix2);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix2));
		System.out.println();	
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix3);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix3));
		System.out.println();
	}
	
	private static void testMissingOperands() {
		String[] infix1 = "( + / )".split(" ");
		String[] infix2 = "+ ^ 7 + 6".split(" ");
		String[] infix3 = "5 + + 5".split(" ");
		
		System.out.println("Testing Expressions with Missing Operands");
		System.out.println("-----------------------------------------");
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix1);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix1));
		System.out.println();		
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix2);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix2));
		System.out.println();
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix3);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix3));
		System.out.println();
	}
	
	private static void testMissingOperators() {
		String[] infix1 = "5 2".split(" ");
		String[] infix2 = "50 2 30".split(" ");
		
		System.out.println("Testing Expressions with Missing Operators");
		System.out.println("------------------------------------------");
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix1);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix1));
		System.out.println();		
		
		System.out.print("Infix Expression: ");
		Expression.PrintArray(infix2);
		System.out.print("is Postfix Expression: ");
		Expression.PrintArray(Expression.convertToPostfix(infix2));
		System.out.println();
	}
}