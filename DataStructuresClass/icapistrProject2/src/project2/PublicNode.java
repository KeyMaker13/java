package project2;

public class PublicNode<T> { // O(1)
	
	public PublicNode<T> next;
	public PublicNode<T> previous;
	public T element;
	
	
	public PublicNode(){ // O(1)
		element = null;
		next = null;
		previous = null;
	}
	
	public PublicNode(T ele){ // O(1)
		element = ele;
		next = null;
		previous = null;
		
	}
	
	public PublicNode<T> getNext() { // O(1)
		return next;
	}
	
	public PublicNode<T> getPrevious(){ // O(1)
		return previous;
	}
	
	public T getElement() { // O(1)
		return element;
	}
	
	public void setElement(T elem) { // O(1)
		element = elem;
	}
	
	public String toString() { // O(1)
		return "Element: " + element.toString();
	}
	
	public void setNext (PublicNode<T> dnode) // O(1)
    {
       next = dnode;
    }
	
	public void setPrevious(PublicNode<T> dnode){ // O(1)
		previous = dnode; 
	}
	

}
