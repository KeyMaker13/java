package hashing;

public class DoubleNode<T> {
	public T element;
	public DoubleNode<T> previous, next;

	public DoubleNode(T elt) {
		element = elt;
		previous = next = null;
	}
	
	// the String includes the elements in the list 
	// started by this node
	public String toString() {
/*		if (next == null) return "" + element;
		String result = "(" + element;
		DoubleNode<T> current = next;
		while (current != null) {
			result += " " + current.element;
			current = current.next;
		}
		return result + ")";*/
		return "[" + element + "]";
	}

}
