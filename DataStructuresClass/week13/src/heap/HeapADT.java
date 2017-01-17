package heap;

public interface HeapADT<T extends Comparable<T>>{
	
   /** Add the specified object to this heap */   
   public void addElement (T obj);
   
   /** Remove element with the lowest value from this heap */
   public T removeMin();
   
   /** Return a reference to smallest element in this heap */
   public T findMin();
   
   /** Return the number of elements in the heap */
   public int size();
   
   /** Return true if the heap is empty */
   public boolean isEmpty();
}

