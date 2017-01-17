package jss2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import jss2.exceptions.EmptySetException;

public class DoubleLinkedSet<T> implements SetADT<T> {
	private static Random rand = new Random();

	   private int count;  // the current number of elements in the set 

	   private DoubleNode<T> contents; 

	   //-----------------------------------------------------------------
	   //  Creates an empty set.
	   //-----------------------------------------------------------------
	   public DoubleLinkedSet()
	   {
	      count = 0;
	      contents = null;
	   }

	   //-----------------------------------------------------------------
	   //  Adds the specified element to the set if it's not already
	   //  present.
	   //-----------------------------------------------------------------
	   public void add (T element)
	   {
	      if (!(contains(element)))
	      {
	         DoubleNode<T> nodeN = new DoubleNode<T> (element);
	         nodeN.setNext(contents);
	         nodeN.setPrevious(nodeN);
	         contents = nodeN;
	         
	         count++;
	        
	      }
	   }

	   //-----------------------------------------------------------------
	   //  Adds the contents of the parameter to this set.
	   //-----------------------------------------------------------------
	   public void addAll (SetADT<T> set)
	   {
	      Iterator<T> scan = set.iterator();

	      while (scan.hasNext())
	         add (scan.next());
	   }

	   //-----------------------------------------------------------------
	   //  Removes a random element from the set and returns it. Throws
	   //  an EmptySetException if the set is empty.
	   //-----------------------------------------------------------------
	   public T removeRandom() throws EmptySetException
	   {
		    DoubleNode<T>  previous, current;
	      T result = null;
	      if (isEmpty())
	         throw new EmptySetException();
	      int choice = rand.nextInt(count) + 1;
	      if (choice == 1)
	      {
	         result = contents.getElement();
	         contents = contents.getNext();
	      }
	      else
	      {
	    	  previous = contents;
	          for (int skip=2; skip < choice; skip++)
	        	  previous = previous.getNext();
	          current = previous.getNext();
	          result = current.getElement();
	          previous.setNext(current.getNext());
	      }
	      
	      count--;
	 
	      return result;
	   }

	   //-----------------------------------------------------------------
	   //  Removes the specified element from the set and returns it.
	   //  Throws an EmptySetException if the set is empty and a
	   //  NoSuchElemetnException if the target is not in the set.
	   //-----------------------------------------------------------------
	   public T remove (T target) throws EmptySetException,
	                                     NoSuchElementException
	   {
	      boolean found = false;
	      DoubleNode<T> previous, current;
	      
	      T result = null;

	      if (isEmpty())
	         throw new EmptySetException();

	      if (contents.getElement().equals(target))
	      {
	         result = contents.getElement();
	         contents = contents.getNext();
	      }
	      else
	      {
	    	 previous = contents; 
	         current = contents.getNext();
	 
	         for (int look=0; look < count && !found; look++)
	         {
	            if (current.getElement().equals(target))
	        	
	               found = true;
	            else
	            {
	               previous = current;
	               current = current.getNext();
	            }
	         }

	         if (!found)
	            throw new NoSuchElementException();

	         result = current.getElement();
	         
	         previous.setNext(current.getNext()); 
	      }
	      count--;
	      return result;
	   }
	   
	   //-----------------------------------------------------------------
	   //  Returns a new set that is the union of this set and the
	   //  parameter.
	   //-----------------------------------------------------------------
	   public SetADT<T> union (SetADT<T> set)
	   {
		   DoubleLinkedSet<T> both = new DoubleLinkedSet<T>();

	      DoubleNode<T> current = contents;

	      while (current != null)
	      {
	         both.add (current.getElement());
	         current = current.getNext();
	      }

	      Iterator<T> scan = set.iterator();
	      while (scan.hasNext())
	         both.add (scan.next());

	      return both;
	   }

	   //-----------------------------------------------------------------
	   //  Returns true if this set contains the specified target
	   //  element.
	   //-----------------------------------------------------------------
	   public boolean contains (T target)
	   {
	      boolean found = false;

	      DoubleNode<T> current = contents;

	      for (int look=0; look < count && !found; look++)
	         if (current.getElement().equals(target))
	            found = true;
	         else
		    current = current.getNext();

	      return found;
	   }

	   //-----------------------------------------------------------------
	   //  Returns true if this set contains exactly the same elements
	   //  as the parameter.
	   //-----------------------------------------------------------------
	   public boolean equals (SetADT<T> set)
	   {
	      boolean result = false;
	      DoubleLinkedSet<T> temp1 = new DoubleLinkedSet<T>();
	      DoubleLinkedSet<T> temp2 = new DoubleLinkedSet<T>();
	      T obj;

	      if (size() == set.size())
	      { 
	         temp1.addAll(this);
	         temp2.addAll(set);

	         Iterator<T> scan = set.iterator();

	         while (scan.hasNext())
	         {
	            obj = scan.next();   
	            if (temp1.contains(obj))
	            {
	               temp1.remove(obj);
	               temp2.remove(obj);
	            }
	  
	         }
	         result = (temp1.isEmpty() && temp2.isEmpty());
	      }

	      return result;
	   }

	   //-----------------------------------------------------------------
	   //  Returns true if this set is empty and false otherwise. 
	   //-----------------------------------------------------------------
	   public boolean isEmpty()
	   {
	      return (size() == 0);
	   }
	 
	   //-----------------------------------------------------------------
	   //  Returns the number of elements currently in this set.
	   //-----------------------------------------------------------------
	   public int size()
	   {
	      return count;
	   }

	   //-----------------------------------------------------------------
	   //  Returns an iterator for the elements currently in this set.
	   //-----------------------------------------------------------------
	   public Iterator<T> iterator()
	   {
	      return new DoubleLinkedIterator<T> (contents);
	   }

	   //-----------------------------------------------------------------
	   //  Returns a string representation of this set. 
	   //-----------------------------------------------------------------
	   public String toString()
	   {
	      String result = "";

	      DoubleNode<T> current = contents;

	      while (current != null)
	      {
	         result += current.getElement().toString() + "\n";
	         current = current.getNext();
	      }

	      return result;
	   }
	   
	   public T test (){
		   return contents.getElement();
	   }
	   public T getNext(){
		   return contents.getNext().getElement();
	   }
	   public void setNext(){
		   contents = contents.getNext();
	   }
	   public T getPrevious(){
		   return contents.getPrevious().getElement();
	   }
	   

}
