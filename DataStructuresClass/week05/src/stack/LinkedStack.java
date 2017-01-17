package stack;

import java.util.EmptyStackException;

import lib.*;


public class LinkedStack<T> implements StackADT<T> {
	private LinearNode<T> top;
	private int count;

	private static boolean debug = false;

	public static void setDebug(boolean t) {
		debug = t;
	}

	public LinkedStack() {
		count = 0;
		top = null;
		if (debug) {
			System.out.println(toString());
		}
	}

	public void push(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		node.setNext(top);
		top = node;
		count++;
    if (debug) {
      System.out.println("Push " + element + "\n" + toString());
   }
	}

	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		T result = top.getElement();
		top = top.getNext();
		count--;
	   if (debug) {
       System.out.println("Pop " + result + "\n" + toString());
    }
		return result;
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return top.getElement();
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public String toString() {
    if (isEmpty()) {
      return "stack: [ ];";
   } else {
      StringBuffer buf = new StringBuffer("stack:[");
      LinearNode<T> current = top;
      for (int i = count; i > 1; i--) {
         if (i==count) {
            buf.append(current.toString());
         } else {
            buf.append("\n       " + current.toString());
         }
         current = current.getNext();
      }
      if (count > 1) {
         buf.append("\n       " + current.toString() + "]");
      } else {
         buf.append(current.toString() + "]");
      }
      return buf.toString();
   }
	}
}
