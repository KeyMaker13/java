package hashing;

import java.util.*;

public class CollectionHashTable<T> implements CollectionADT<T> {
	protected DoubleNode<T>[] table;
	protected int size;

	public CollectionHashTable() {
		// Initially, elements will stored in a PublicNode at the index.
		// For collisions, the PublicNode will head a linked list.
		table = new DoubleNode[11];
		size = 0;
	}

	public CollectionHashTable(int tableSize) {
		table = new DoubleNode[tableSize];
		size = 0;
	}

	// Adds the element, returns true if successful
	public boolean add(T element) {
		// This doesn't handle collisions.
		int code = 
			Math.abs(element.hashCode()) % table.length;
		if (table[code] == null)
			table[code] = new DoubleNode<T>(element);
		else {
			DoubleNode<T> newnode =
				new DoubleNode<T>(element);
			DoubleNode<T> oldnode = table[code];
			newnode.next = oldnode;
			oldnode.previous = newnode;
			table[code] = newnode;
		}
		size++;
		return true;
	}

	// size of table is doubled plus 1
	protected void resize() {
		// Create a bigger hash table.
		// Iterate over old hash table
		// adding elements to new hash table.
		// table = newHashTable.table;
	}

	// Removes the element, returns true if successful
	public boolean remove(T element) {
		// This doesn't handle collisions.
		int code = Math.abs(element.hashCode()) % table.length;
		// standard LL loop
		DoubleNode<T> current = table[code];
		while (current != null) {
			if (element.equals(current.element)) {
				if (current.next != null) {
					current.next.previous =
						current.previous;
				}
				if (current.previous != null) {
					current.previous.next =
						current.next;
				} else {
					table[code] = current.next;
				}
				current.previous = null;
				current.next = null;
				current.element = null;
				size--;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Returns true if the element is in the collection
	public boolean contains(T element) {
		// This doesn't handle collisions.
		int code = Math.abs(element.hashCode()) % table.length;
		// standard LL loop
		DoubleNode<T> current = table[code];
		while (current != null) {
			if (element.equals(current.element))
				return true;
			current = current.next;
		}
		return false;
	}

	// Returns the number of elements in the collection
	public int size() {
		return size;
	}

	// Returns an iterator over all the elements
	public Iterator<T> iterator() {
		return new HashTableIterator(table);
	}

	// Returns a string representation of the collection
	public String toString() {
		String result = "CHT [";
		String blankLater = "";
		for (int i = 0; i < table.length; i++) {
			result += blankLater + table[i];
			blankLater = " ";
		}
		return result + "]";
	}
}
