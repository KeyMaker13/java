package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RIUsingArray<T> implements ReversibleIterator<T> {
	
	
	private T[] list;
	private int next;
	private int previous;
	
	public RIUsingArray (Iterator<T> iter){ //O(n)
		initializeList(iter);
		next = 0;
		previous =-2;
	
	}
	
	public void initializeList(Iterator<T> iter){ //O(n)		// initializes the global list of array 
		ArrayList<T> temp = new ArrayList<T>();
		Iterator<T> determineSize = iter;
		int size = 0;
		
		while(determineSize.hasNext()){				// this loop determines the size of the array we need to create
			size++;
			temp.add((T)determineSize.next());
		}
		
		list =  (T[]) new Object[size];				// creates a new array of type T .....type casted by array Object
		int index = 0;
		
		Iterator<T> addV = temp.iterator();
		
		while(addV.hasNext()){					// puts the values into the array of type T
			list[index] = (T) addV.next();
			index++;
		}
	}

	@Override
	public boolean hasNext() { //O(1)
		// TODO Auto-generated method stub
		return (next >= 0 && next < list.length);	// checks counters to make sure they are in range for the next method to work
	}
	
	@Override
	public boolean hasPrevious() { //O(1)
		// TODO Auto-generated method stub
		return (previous >= 0 && previous < list.length); //checks counters to make sure they are in range for the next method to work
	}

	@Override
	public T previous() { //O(1)			// returns the previous element in the iteration
		if (!hasPrevious())
			throw new NoSuchElementException(); // check it it hasPrevious first to then return previous element;
		
		
		T ref = (T) list[previous];			// reference variable to catch elements before incrementing
		next--;
		previous--;
		return (T) ref ;
	}
	
	@Override
	public T next() { //O(1)		// returns the next element in the iteration
		if (!hasNext())			// if it does not haveNext then return  exception
			throw new NoSuchElementException();
		T ref = (T) list[next];		// reference variable to catch elements before incrementing 
		next++;
		previous++;
		return (T) ref;
	}

	@Override
	public void remove() { //O(1)
		// TODO Auto-generated method stub
		
	}
}
