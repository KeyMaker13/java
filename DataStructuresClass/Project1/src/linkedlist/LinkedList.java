package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class LinkedList<T> implements ListADT<T>  {
	private static Random rand = new Random();
	protected Node<T> contents;
  protected int count;

  protected static boolean debug = false;
  public static void setDebug(boolean t) {
    debug = t;
  }

  public LinkedList(){
	  count = 0;
	  contents = null;
  	if (debug) {
      System.out.println("Create set: " + toString());
    }
  }

	public void add(T element) { // O(1)
		
		Node<T> node = new Node<T>(element); // O(1)
		node.next = contents; // O(1)
		contents = node; // O(1)
		count++; // O(1)
		if (debug) {
    	System.out.println("Add " + element+ "\n" + toString());
    }	
	}

	public boolean contains(T target) { // O(n)
		Node<T> temp = contents; // O(1)
		while(temp!=null) // O(n)
		{
			if(target.equals(temp.element)) // O(1)
			{
				return true; // O(1)
			}
			temp = temp.next; // O(1)
		}
		return false;
	}

	public boolean isEmpty() { // O(1)
		return count==0; // O(1)
	}

	public Iterator<T> iterator() { 
		return new LinkedListIterator<T>(contents);
	}

	public T remove(T element) { // O(n) 
	   if (isEmpty()) {	// O(1)
	      throw new EmptyListException();
	    }
	    if (!contains(element)) { // O(n)
	      throw new NoSuchElementException();
	    }
	     count--;
	    Node<T> curr = contents;
	    if (contents.element.equals(element)){
	    	contents = contents.next;
	    }
	    else{
	    	Node<T> prev = null;
	    	while(!curr.element.equals(element)){ // O(n)
	    		prev = curr;
	    		curr = curr.next;
	    	}
	    	prev.next = curr.next;
	    }
	    if (debug) {
//	      System.out.println("remove  " + curr.element + "\n" + toString());
	    }
	    return curr.element;
	}

	@Override
	public T removeRandom() { // O(n)
    if (debug) {
      System.out.println("removeRandom  ");
    }
    if (isEmpty()) {
      throw new EmptyListException();
    }
    int choice = rand.nextInt(count);
    Node<T> temp = contents;
    for (int i =0; i<choice; i++) { // O(n)
      temp = temp.next;
    }
    return remove(temp.element); // O(n)
	}

	public int size() {
		return count;
	}

	 public String toString() {
	    Node<T> temp = contents;
	    String toReturn = "[";
	    // first count-1 elements
	    for (int i=0; i<count-1; i++) {
	      toReturn = toReturn + temp.element + ", ";
	      temp = temp.next;
	    }
	    // the last element
	    if (count>0) {
	      toReturn = toReturn + temp.element + "";   	
	    }
	    return toReturn + "]";
	  }
	 
	 
	


}
