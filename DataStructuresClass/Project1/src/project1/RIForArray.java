package project1;



import java.util.NoSuchElementException;

public class RIForArray<T> implements ReversibleIterator<T> {
	
	private T[] list; // array of type T to store objects;
	private int previous; // to keep track of where the object in the array is
	private int next;	
	
	public RIForArray (T[] list){ //O(1)
		this.list = list;	// Will take in an array of objects and copy it to the global variable
		next = 0;			// setting next to zero since next is the first option for the iterator
		previous = - 2;		// setting previous to -2 because you can't iterate to previous when next is 1
	}
	
	@Override
	public boolean hasNext() { // O(1)
		return (next >= 0 && next < list.length); // returning true is next is between zero and size of list
	}

	@Override
	public boolean hasPrevious() { //O(1)
		return previous >= 0 && previous <list.length ; // returning true if previous is >= 0 because you can't iterate previous when next is 1
	}

	@Override
	public T previous() { // O(1)
		if (!hasPrevious())
			throw new NoSuchElementException(); // check it it hasPrevious first to then return previous element;
		
		previous--; // increment down
		next--;		// increment down
		
		return (T) list[previous + 1] ;  // return previous + 1 to avoid outOfBounds exception;
	}
	
	@Override
	public T next() { // O(1)
		if (!hasNext())			// if it does not haveNext then return  exception
			throw new NoSuchElementException();
		
		previous++;	// increment up
		next++;		// increment up
		
		return (T) list[next - 1]; // return next -1 to avoid outOfBounds exception
	}

	@Override
	public void remove() {	
	}

}
