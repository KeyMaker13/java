package linkedlist;


public class DoubleNode<T> {

	public DoubleNode<T> next;
	public DoubleNode<T> previous;
	public T element;

	// ---------------------------------------------------------
	// Creates an empty node.
	// ---------------------------------------------------------
	public DoubleNode() {
		previous = null;
		next = null;
		element = null;
	}

	public DoubleNode(T ele) {
		previous = null;
		next = null;
		element = ele;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T elem) {
		element = elem;
	}

	public String toString() {
		return "Element: " + element.toString();
	}
	
	public void setNext (DoubleNode<T> dnode)
    {
       next = dnode;
    }
	
	 public void setPrevious (DoubleNode<T> dnode)
	    {
	       previous = dnode;
	    }

}
