package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import linkedlist.DoubleLinkedList;
import linkedlist.DoubleNode;
import linkedlist.LinkedList;

public class RIUsingLinkedList<T> implements ReversibleIterator<T> {
	
	
	private DoubleLinkedList<T> list = new DoubleLinkedList<T>();
	private int prev;
	private int next;
	private DoubleNode<T> current;
	
	
	public RIUsingLinkedList (Iterator<T> iter){ //O(n)			// initializes the global double linked list to be used for this class
		initializeList(iter);
		prev = -2;
		next = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	public void initializeList(Iterator<T> iter){ //O(n)	// grabs the iterator and reverses it into an arraylist
		ArrayList<T> reverseTheList = new ArrayList<T>();	// the arraylist will then store the reversed list

		while (iter.hasNext()){
			reverseTheList.add((T)iter.next());	
		}
		for (int i = reverseTheList.size() - 1; i >= 0 ; i--){		// the global list will be filled with the values in the arraylist in backwards order
			list.add(reverseTheList.get(i));
		}
		current =  list.getNode();							// the current node grabs the node from the global list
	}
	
	@Override
	public boolean hasNext() { //O(1)
		// TODO Auto-generated method stub
		return (next>=0 && next<list.size()); // checks to see if counters are within bounds to make the next method work	
	}
	
	@Override
	public boolean hasPrevious() { //O(1)
		// TODO Auto-generated method stub
		return (prev >=0 && prev <list.size());				// checks to see if counters are within bounds to make the previous method work	
	}

	@Override
	public T previous(){ //O(1)
		if (!hasPrevious())
			throw new NoSuchElementException();		// check to see that it has previous before executing method
	
		//System.out.println("hello : "+current.getElement());
		
		// Logically i think this is correct for the implementation of the previous method for the RIUsingLinkedList class
		// I have been stuck on it for a few days and have not found a solution
		// I will not be leaving the custom print command or the has previous command.
		//Pretty hard stuff here man 
		
		
		current = current.getPrevious();
		T ref = current.element;
		
		return ref;		
	}

	@Override
	public T next() { //O(1)
		if (!hasNext())			// if it does not haveNext then return  exception
			throw new NoSuchElementException();
		
		T ref;  	// T object to reference and grab object from node first before changing the node into the next one

		ref = (T) current.element;   			
		
		if (current.getNext()!=null)				// if the next one is not null then set current to next node
			current = current.getNext();
	
		prev++;						// increment counters
		next++;
		return ref;
		
	}

	@Override
	public void remove() { //O(1)
	}

}
