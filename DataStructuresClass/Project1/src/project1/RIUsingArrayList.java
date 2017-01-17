package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RIUsingArrayList<T> implements ReversibleIterator<T> {
	
	private ArrayList<T> list = new ArrayList<T>();
	private int previous;
	private int next;
	
	public RIUsingArrayList (Iterator<T> iter){ //O(n)		// arraylist to be used for implementing the iteration
				initializeList(iter);
				next = 0;
				previous = -2;
	}
	
	public void initializeList (Iterator<T> iter){ //O(n)		// puts the values into the arrayList
		while(iter.hasNext()){
			list.add(iter.next());
		}
	}
	
	@Override
	public boolean hasNext() { //O(1)
		// TODO Auto-generated method stub
		return (next >= 0 && next < list.size());		// checks the counters to see that they are within correct bounds for the next method to work
	}

	@Override
	public boolean hasPrevious() { //O(1)
		// TODO Auto-generated method stub
		return previous >= 0 && previous <list.size();   // checks the counters to see that they are within correct bounds for the previous method to work
	}

	@Override
	public T previous() { //O(1)			// returns the previous element 
		if (!hasPrevious())
			throw new NoSuchElementException(); // check it it hasPrevious first to then return previous element;
		
		T ref;
		ref = list.get(previous);			// reference variable to catch element before incrementing 
			previous--;
			next--;
		return ref;
	}
	
	@Override
	public T next() { //O(1)		// returns the next element
		if (!hasNext())			// if it does not haveNext then return  exception
			throw new NoSuchElementException();
		
		T ref;
		ref = list.get(next);		// reference variable to catch element before incrementing
			next++;
			previous++;
		return ref;
	}

	@Override
	public void remove() { //O(1)
		// TODO Auto-generated method stub
		
	}

}
