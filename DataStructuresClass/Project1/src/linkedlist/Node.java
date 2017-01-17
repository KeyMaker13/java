package linkedlist;

public class Node<T> {

	public Node<T> next;
	
	public T element;

	// ---------------------------------------------------------
	// Creates an empty node.
	// ---------------------------------------------------------
	public Node(){

		next = null;
		element = null;
	}
	
	public Node(T ele) {
		next = null;
		element = ele;
	}

	public Node<T> getNext(){
		return next;
	}
	

	
	public T getElement(){
		return element;
	}
	
	public void setElement(T elem){
		element = elem;
	}
	
	public String toString() {
		return "Element: " + element.toString();
	}

}
