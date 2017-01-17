package project2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
	private PublicNode<T> current; // the current position

	// -------------------------------------------------------------
	// Sets up this iterator using the specified items.
	// -------------------------------------------------------------
	public LinkedListIterator( PublicNode<T> front) { // O(1)
		current = front;
	}

	// -------------------------------------------------------------
	// Returns true if this iterator has at least one more element
	// to deliver in the iteration.
	// -------------------------------------------------------------
	public boolean hasNext() { // O(1) 
		return (current != null);
	}

	// -------------------------------------------------------------
	// Returns the next element in the iteration. If there are no
	// more elements in this iteration, a NoSuchElementException is
	// thrown.
	// -------------------------------------------------------------
	public T next() { //O(1)
		if (!hasNext())
			throw new NoSuchElementException();
		T result = current.element;
		current = current.next;
		return result;
	}

	// -------------------------------------------------------------
	// The remove operation is not supported.
	// -------------------------------------------------------------
	public void remove() throws UnsupportedOperationException { //O(1)
		throw new UnsupportedOperationException();
	}
}