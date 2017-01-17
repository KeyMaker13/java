package stacks;

public interface StackADT<T> {
	// add one element to top of stack
	public void push(T element);

	// remove and return top element from stack
	public T pop();

	// return without removing top element of stack
	public T peek();

	// return true if stack contains no elements
	public boolean isEmpty();

	// return number of elements in stack
	public int size();

	// returns string representation of stack
	public String toString();
}
