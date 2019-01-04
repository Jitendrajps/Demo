package com.demo.datastructure.stack;

public class Stack {

	private int top = -1;
	private int MAX_VALUE = 10;
	
	int stack[] = new int[MAX_VALUE];
	
	boolean isEmpty() {
		return (top<0);
	}
	
	boolean push(int data) {
		if(top>=(MAX_VALUE - 1) ) {
			System.out.println("Stack is overflow!");
			return false;
		}else {
			stack[++top] = data;
			System.out.println(data + " push into stack");
			return true;
		}	
		
	}
	
	int pop() {
		if(top < 0) {
			System.out.println("Stack is underflow !");
			return 0;
		}else {
			int x = stack[top--];
			//System.out.println(x + "pop from stack");
			return x;
		}
	}
	
	private int maxVal(Stack stk) {
		int temp = 0;
		
		while(!stk.isEmpty()) {			
			int val = stk.pop();
			if(val > temp) {
				temp = val;
			}			
		}	
		
		return temp;
	}
	
	private int minVal(Stack stk) {
		int temp = 0;
		int count = 0;
		
		while(!stk.isEmpty()) {			
			int val = stk.pop();
			
			if(count==0) {
				temp = val;
				count = count + 1;
			}
			
			if(val < temp) {
				temp = val;
			}			
		}	
		
		return temp;
	}
	
	
	private int search(Stack stk, int valueForSearch) {
		int temp = 0;
		int count = 0;
		
		while(!stk.isEmpty()) {			
			int val = stk.pop();
			
			if(count==0) {
				temp = val;
				count = count + 1;
			}
			
			if(val < temp) {
				temp = val;
			}			
		}	
		
		return temp;
	}
	
	public static void main(String[] args) {
		Stack stk = new Stack();
		
		System.out.println("********************PUSH OPERATION OVER STACK **********************");
		stk.push(10);
		stk.push(20);
		stk.push(50);
		System.out.println("********************POP OPERATION OVER STACK **********************");
		System.out.println(stk.maxVal(stk) + " is max value in stack");
		
		
		stk.push(10);
		stk.push(20);
		stk.push(50);
		System.out.println(stk.minVal(stk) + " is min value in stack");
		
		while(!stk.isEmpty()) {
			System.out.println(stk.pop() + " pop from stack");
		}
		
	}
}
