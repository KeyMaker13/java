package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import linkedlist.LinkedList;

public class RIForLinkedList<T> implements ReversibleIterator<T> {
	
	//private LinkedList list;								// I used an arrayList to achieve the reverseIteration   :/
	
	private ArrayList<T> list = new ArrayList<T>();			// made two list since the objects in the link list in reverse order
	private ArrayList<T> fixedList = new ArrayList<T>();	
	
	//private Node<T> previous;
	//private Node<T> current;
	
	private int next;
	private int prev;

	
	public RIForLinkedList (LinkedList<T> list){ //O(n)
		//this.list = list;
		next = 0;
		prev = -2;
	
		Iterator iter = list.iterator();			// this loop puts the reversed linklist into an arraylist
		while(iter.hasNext()){
			this.list.add((T)iter.next());
		}
		for (int i = this.list.size() - 1; i >= 0; i--){	// this loop fixes the linked list and it then corrects the order
			fixedList.add(this.list.get(i));
		}
		
	}

	@Override
	public boolean hasPrevious() {   //O(1)
	return prev >= 0 && prev <list.size();	// checks counters to be in correct range for the previous method to work
	}
	
	@Override
	public boolean hasNext() {			//O(1)
		return (next >= 0 && next < list.size());	// checks counters to be in correct range for the next method to work
	}
	@Override
	public T previous() {//O(1)		// returns the previous element of the list
		
		if (!hasPrevious())
			throw new NoSuchElementException(); // check it it hasPrevious first to then return previous element;
		
		T ref = (T) fixedList.get(prev);		// reference variable to catch element before incrementing
		
		next --;
		prev --;
			
		/*
		Node<T> ref =current;
		current = current.next;
		previous = previous.next;
		*/
	
		return ref;
	}

	@Override
	public T next() {		//O(1)		// returns the next element of the list
		if (!hasNext())			// if it does not haveNext then return  exception
			throw new NoSuchElementException();
											// reference variable to catch element before incrementing
		T ref = (T) fixedList.get(next);
		next++;
		prev++;
		/*
		Node<T> ref = previous;
		previous = previous.next;
		
		current = current.next;
		return ref.element;
		*/
		return ref;
	}

	@Override
	public void remove() { //O(1)
		// TODO Auto-generated method stub
		
	}
	
	
	
}

