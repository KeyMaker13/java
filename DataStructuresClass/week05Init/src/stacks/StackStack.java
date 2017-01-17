package stacks;

import java.util.Stack;


public class StackStack <T> implements StackADT <T>{
	private Stack <T> s;
	
	public StackStack () {
		s = new Stack<T>();
	}
	
	public void push(T element) {
		s.push(element);
	}

	public T pop() {
		return s.pop();
	}

	public T peek() {
		return s.peek();
	}

	public boolean isEmpty() {
		return s.empty();
	}

	public int size() {
		return s.size();
	}

	public String toString() {
		return s.toString();
	}

}
