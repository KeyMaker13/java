package hashing;

import java.util.*;

public class HashTableIterator<T> implements Iterator<T> {
	// The hash table
	private DoubleNode<T>[] table;

	// Which index in table holds the next element
	private int nextBucket;

	// this field is the node that stores the next element.
	private DoubleNode<T> nextnode;

	// This does not take collisions into account
	public HashTableIterator(DoubleNode<T>[] table) {
		this.table = table;
		nextBucket = -1;
		findNextNode();
	}

	// This does not take collisions into account
	public boolean hasNext() {
		return (nextnode != null);
	}

	// This does not take collisions into account
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		T result = nextnode.element;
		findNextNode();
		return result;
	}

	// set nextBucket and nextnode to next value to return
	private void findNextNode() {
		if (nextnode != null && 
				nextnode.next != null)
			// the next node is in the same
			// linked list
			nextnode = nextnode.next;
		else {
			// the next node is in a different
			// linked list
			nextBucket++;
			while (nextBucket < table.length && 
					table[nextBucket] == null) {
				nextBucket++;
			}
			if (nextBucket < table.length)
				nextnode = table[nextBucket];
			else
				nextnode = null;
		}
	}

	// remove is not supported
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
