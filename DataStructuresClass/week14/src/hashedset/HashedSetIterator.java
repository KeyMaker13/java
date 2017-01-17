package hashedset;

import java.util.*;

import lib.SimpleLinkedList;

public class HashedSetIterator<T> implements Iterator<T> {
	// The hash table
	private SimpleLinkedList<T>[] table;

	// Which index in table holds the next element
	private int bucket;

	// this field is the node that stores the next element.
	private Iterator<T> iter;

	// This does not take collisions into account
	public HashedSetIterator(SimpleLinkedList<T>[] table) {
		this.table = table;
		bucket = 0;
		while (bucket < table.length && table[bucket].size()==0)
			bucket++;
		if (bucket<table.length)
			iter = table[bucket].iterator();
		else iter = null;
	}

	// This does not take collisions into account
	public boolean hasNext() {
		return iter!=null && iter.hasNext();
	}

	// This does not take collisions into account
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		T result = iter.next();
		if (!iter.hasNext()) {
			bucket++;
			while (bucket < table.length && table[bucket].size()==0)
				bucket++;
			if (bucket<table.length)
				iter = table[bucket].iterator();
			else iter = null;
		}
		return result;
	}

	// remove is not supported
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
