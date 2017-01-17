package heap;

public interface PriorityQueueADT <T extends Comparable<T>> {
	
	/** insert element in priority queue */
	public void add(T element); 

	/** remove and return smallest element */
	public T removeMin(); 

	/** return smallest element without removing it */
	public T findMin(); 

	/** remove all elements */
	public void makeEmpty(); 

	/** return true if empty; else return false */
	public boolean isEmpty(); 

    /** return the size of the priority queue */
	public int size(); 
	
	/** return a string representation of the priority queue */
	public String toString();   
}
