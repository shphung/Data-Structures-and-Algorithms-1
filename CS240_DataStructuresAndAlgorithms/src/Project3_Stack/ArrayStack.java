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

public class ArrayStack<T> {

	//Has an array stack and an integer that keeps track of the element on top.
	private T[] stack;
	private int top;
	
	//Constructor that initializes the ArrayStack by creating an array of a given size and setting the top to -1.
	@SuppressWarnings("unchecked")
	public ArrayStack(int maxSize) {
		stack = (T[]) new Object[maxSize];
		top = -1;
	}
	
	//Constructor that initializes the ArrayStack to a default size of 50 as well as setting top to -1.
	public ArrayStack() {
		this(50);
	}
	
	//Method returns true if stack is empty and false if is not empty.
	public boolean isEmpty() {
		return top == -1;
	}
	
	//Method will effectively add a value to the top of the stack, throws exception if it goes out of the array's bounds.
	public void push(T item) {
		try {
			if((top + 1) == stack.length) {
				throw new RuntimeException();
			} else 
				stack[++top] = item;
		} catch(RuntimeException e) {
			System.out.println("I cannot push onto a full stack.");
		}
	}
	
	//Method will remove a value from the top of the stack and return it, throws exception if there is nothing to pop.
	public T pop() {
		if(top == -1) {
			return null;
		}
		return stack[top--];
	}
	
	//Method will return the value on top of the stack without removing it.
	public T peek() {
		if(top == -1) {
			return null;
		}
		return stack[top];
	}
	
	//Method clears entire stack and frees unused data back to memory.
	public void clear() {
		for(int i = 0; i <= top; i++) {
			stack[i] = null;
		}
		top = -1;
	}
}