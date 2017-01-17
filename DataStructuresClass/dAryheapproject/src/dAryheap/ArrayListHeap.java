package dAryheap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListHeap<T extends Comparable> implements HeapADT<T> {
	private ArrayList<T> heap;

	public ArrayListHeap() {
		heap = new ArrayList<T>();
	}

	/** Add the specified object to this heap */
	public void addElement(T obj) {
		heap.add(obj);
		heapifyAdd();
	}

	/** Remove element with the lowest value from this heap */
	public T removeMin() {
		if (isEmpty())
			throw new NoSuchElementException("removeMin");
		T minElement = heap.get(0);
		heapifyRemove();
		return minElement;
	}

	/** Return a reference to smallest element in this heap */
	public T findMin() {
		if (isEmpty())
			throw new NoSuchElementException("findMin");
		return heap.get(0);
	}

	/** Return true if this binary tree is empty and false otherwise. */
	public boolean isEmpty() {
		return heap.size() == 0;
	}

	/** Return the number of elements in this binary tree. */
	public int size() {
		return heap.size();
	}
	
	public String toString () {
		String result = getClass().getName() + ": [ ";
		for (int k = 0; k < heap.size(); k++)
			result += heap.get(k) + " ";
		return result + "]";
	}

	/** Reorder heap after add to maintain ordering property */
	private void heapifyAdd() {
		int next = size() - 1;
		while (next != 0
				&& heap.get(next).compareTo(heap.get(parent(next))) < 0) {
			T temp = heap.get(next);
			heap.set(next, heap.get(parent(next)));
			heap.set(parent(next), temp);
			next = parent(next);
		}
	}

	private void heapifyRemove() {
		// Move last element to position 0 and remove last element
		heap.set(0, heap.get(size() - 1));
		heap.remove(size() - 1);
		if (size() == 0 || size() == 1)
			return;
		
        // More than one element left, so much adjust the heap
		int node = 0;
		while (node < size() - 1) {
			int next = smallestChild(node);
			if (next == -1 || heap.get(next).compareTo(heap.get(node)) >= 0)
				return;
			T temp = heap.get(node);
			heap.set(node, heap.get(next));
			heap.set(next, temp);
			node = next;
		}
	}
	
	/** Return index of smallest child of node or -1 if none */
	private int smallestChild(int node) {
		int left = leftChild(node);
		int right = rightChild(node);
		if (left > size() - 1)
			return -1;
		if (right > size() - 1)
			return left;
		else if (heap.get(left).compareTo(heap.get(right)) < 0)
			return left;
	    return right;
	}
	
	/** Return the index of the parent node or -1 if the root */
	private int parent(int node) { // O(1) runtime	
		return (node - 1)/2;  // integer division rounds down
	}

	 /** Return the index of the left child of node or -1 if none */
	private int leftChild(int node) {
		return 2*node + 1;
	}

	/** Return the index of the right child of node or -1 none */
	private int rightChild(int node) {
		return 2*node + 2;
	}
}