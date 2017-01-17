package lib;

import java.util.*;

public class SimpleLinkedList<T> implements SimpleListADT<T>{
	private static Random rand = new Random();
	protected SimpleNode<T> contents;
  protected int count;

  protected static boolean debug = false;
  public static void setDebug(boolean t) {
    debug = t;
  }

  public SimpleLinkedList(){
    count = 0;
    contents = null;
    if (debug) {
      System.out.println("Create set: " + toString());
    }
  }

	public void add(T element) {
    SimpleNode<T> node = new SimpleNode<T>(element);
    node.next = contents;
    contents = node;
    count++;
    if (debug) {
    	System.out.println("Add " + element+ "\n" + toString());
    }	
	}

	public boolean contains(T target) {
    SimpleNode<T> temp = contents;
    while (temp != null && !temp.element.equals(target)) {
      temp = temp.next;
    }
    return (temp != null);

	}

	public boolean isEmpty() {
		return count==0;
	}

	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(contents);
	}

	public T remove(T element) {
	   if (isEmpty()) {
	      throw new EmptyListException();
	    }
	    if (!contains(element)) {
	      throw new NoSuchElementException();
	    }
	    count--;
	    SimpleNode<T> curr = contents;
	    if (contents.element.equals(element)) {
	      contents = contents.next;
	    } else {
	      SimpleNode<T> prev = null;
	      while (!curr.element.equals(element)) {
	        prev = curr;
	        curr = curr.next;
	      }
	      prev.next = curr.next;
	    }
	     if (debug) {
	      System.out.println("remove  " + curr.element + "\n" + toString());
	    }
	    return curr.element;
	}

	@Override
	public T removeRandom() {
    if (debug) {
      System.out.println("removeRandom  ");
    }
    if (isEmpty()) {
      throw new EmptyListException();
    }
    int choice = rand.nextInt(count);
    SimpleNode<T> temp = contents;
    for (int i =0; i<choice; i++) {
      temp = temp.next;
    }
    return remove(temp.element);
	}

	public int size() {
		return count;
	}

	 public String toString() {
	    SimpleNode<T> temp = contents;
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
