package project1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RIForArrayList<T> implements ReversibleIterator<T> {
	
	private ArrayList list;		// global arrayList 
	private int previous;		// previous and next to keep track of where the object is
	private int next;

	public RIForArrayList(ArrayList<T> list){ //O(1)
		this.list = list;		// grabs list from the parameter and passes it down to the global variable
		next = 0;				// next set to zero since 0 is where the iteration must start
		previous = - 2;			// previous must be -2 since you can't iterate back when next is 1 
	}

	@Override
	public boolean hasNext(){  // O(1)
		return next >= 0 && next < list.size(); } // returning true is next is between zero and size of list
	   
	public boolean hasPrevious(){
		return previous >= 0 && previous < list.size();  // returning true if previous is >= 0 because you can't iterate previous when next is 1
		}

	@Override
	public T previous() {	//O(1)
	if (! hasPrevious()){ 
			throw new NoSuchElementException(); // check it it hasPrevious first to then return previous element;
		}
		previous--;  // increment counters down
		next--;		
	
		return (T) list.get(previous + 1); // return previous+1 to avoid outOfBounds exception
	}

	@Override
	public T next() {	//O(1)
		 if (! hasNext()) throw new NoSuchElementException(); // check to see if it hasNext before running method
	
		previous++;  //increment counters up
		next++;
		return (T) list.get(next - 1);		// return next-1 to avoid outOfBounds exception
	}

	@Override
	public void remove() { throw new UnsupportedOperationException(); }
	

}
