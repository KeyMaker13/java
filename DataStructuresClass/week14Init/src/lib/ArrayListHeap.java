package lib;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListHeap<T extends Comparable<T>> extends ArrayList<T> 
   implements HeapADT<T> {
	    
	    public ArrayListHeap() {
	    	super();
	    }
		/** Add the specified object to this heap */
		public void addElement(T obj) {
			add(obj);
			heapifyAdd(size()-1);
		}

		/** Remove element with the lowest value from this heap */
		public T removeMin() {
			if (isEmpty()) 
				throw new NoSuchElementException("removeMin");
			T result = get(0);
			set(0, get(size() - 1));
			remove(size() - 1);
			heapifyRemove(0);
			return result;
		}

		/** Return a reference to smallest element in this heap */
		public T findMin() {
			if (isEmpty()) 
				throw new NoSuchElementException("removeMin");
			return get(0);
		}

		/** Return true if this binary tree is empty and false otherwise. */
		public boolean isEmpty() {
			return super.isEmpty();
		}

		/** Return the number of elements in this binary tree. */
		public int size() {
			return super.size();
		}
		
		public String toString() {
			String result = getClass().getName() + ": [ ";
			for (int k = 0; k < size(); k++)
				result = result + get(k) + " ";
			return result + "]";
		}
		
		private void heapifyAdd(int node) {
			if (node == 0) {
				return;
			}
			int parent = parentOf(node);
			if (get(node).compareTo(get(parent)) >= 0) 
					return;
			T temp = get(parent);
			set(parent, get(node));
			set(node, temp);
			heapifyAdd(parent);
		}
		
		private void heapifyRemove(int node) {
			if (leftChildOf(node) >= size()) {
				return;
			}
			int minChild = minChildOf(node);
			if (get(minChild).compareTo(get(node)) >= 0)
				return;
			T temp = get(minChild);
			set(minChild, get(node));
			set(node, temp);
			heapifyRemove(minChild);				
		}
		
		private int leftChildOf(int node) {
			return 2*node + 1;
		}
		
		private int rightChildOf(int node) {
			return 2*node + 2;
		}
		
		private int minChildOf(int node) {
			int left = leftChildOf(node);
			int right = rightChildOf(node);
			if (right >= size() || get(left).compareTo(get(right)) <= 0)
				return left;
			else
				return right;
		}
		
		private int parentOf(int node) {
			return (node - 1)/2;
		}
}
