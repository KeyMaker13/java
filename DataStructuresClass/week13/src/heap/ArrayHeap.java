package heap;

import java.util.NoSuchElementException;

public class ArrayHeap<T extends Comparable<T>> implements HeapADT<T> {
	private T[] heap;
	private int count;

	public ArrayHeap() {
		heap = (T[]) (new Comparable[20]);
		count = 0;
	}

	/** Add the specified object to this heap */
	public void addElement(T obj) {
		if (count == heap.length)
			resize();
		heap[count] = obj;
		count++;
		int child = count - 1;
		int parent = parentOf(child); // (child-1)/2
		while (parent >= 0 && heap[child].compareTo(heap[parent]) < 0) {
			T temp = heap[child];
			heap[child] = heap[parent];
			heap[parent] = temp;
			child = parent;
			parent = parentOf(child);
		}
	}

	/** Remove element with the lowest value from this heap */
	public T removeMin() {
		if (isEmpty())
			throw new NoSuchElementException("removeMin");
		T result = heap[0];
		count--;
		heap[0] = heap[count];
		int parent = 0;
		while (leftChildOf(parent) < count) {
			int minChild = minChildOf(parent);
			if (heap[minChild].compareTo(heap[parent]) < 0) {
				T temp = heap[minChild];
				heap[minChild] = heap[parent];
				heap[parent] = temp;
			}
			parent = minChild;
		}
		return result;
	}

	/** Return a reference to smallest element in this heap */
	public T findMin() {
		if (isEmpty())
			throw new NoSuchElementException("removeMin");
		return heap[0];
	}

	/** Return true if this binary tree is empty and false otherwise. */
	public boolean isEmpty() {
		return count == 0;
	}

	/** Return the number of elements in this binary tree. */
	public int size() {
		return count;
	}

	public String toString() {
		String result = getClass().getName() + ": [ ";
		for (int k = 0; k < count; k++)
			result = result + heap[k] + " ";
		return result + "]";
	}

	private void resize() {
		T[] temp = (T[]) (new Object[2 * heap.length]);
		for (int k = 0; k < heap.length; k++)
			temp[k] = heap[k];
		heap = temp;
	}

	private int leftChildOf(int node) {
		return 2 * node + 1;
	}

	private int rightChildOf(int node) {
		return 2 * node + 2;
	}

	private int minChildOf(int node) {
		int left = leftChildOf(node);
		int right = rightChildOf(node); // left is always less than right
		if (right >= count || heap[left].compareTo(heap[right]) <= 0)
			return left;
		else
			return right;
	}

	private int parentOf(int node) {
		return (node - 1) / 2;
	}
}
