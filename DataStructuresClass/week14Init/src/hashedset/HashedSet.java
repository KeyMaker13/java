package hashedset;

import java.util.*;

import lib.SetADT;
import lib.SimpleLinkedList;

public class HashedSet<T> implements SetADT<T> {
	private static final int DEFAULT_CAPACITY = 11;
  private static boolean debug = false;

	protected SimpleLinkedList<T>[] table;
	protected int size;
	protected int count;

  public static void setDebug(boolean t) {
    debug = t;
  }

  public HashedSet (){
    this(DEFAULT_CAPACITY);
  }  

	public HashedSet(int tableSize) {

		
		if (debug) {
      System.out.println("Create set: " + toString());
    }

	}

	public void add(T element) {

	}

	public T remove(T element) {

		
		
		if (debug) {
      System.out.println("remove  " + element + "\n" + toString());
    }
		return null;
	}

	// Returns true if the element is in the collection
	public boolean contains(T element) {

		return false;
	}

	// Returns the number of elements in the collection
	public int size() {
		return count;
	}

	// Returns an iterator over all the elements
	public Iterator<T> iterator() {
		return new HashedSetIterator(table);
	}

	// Returns a string representation of the collection
	public String toString() {
		String result = "{\n";
		for (int i = 0; i < size; i++) {
				result += "bucket" + i + ": " + table[i] + "\n";
		}
		return result + "}";
	}

	public void addAll(SetADT<T> set) {
    Iterator<T> iter = set.iterator();
    if (debug) {
      System.out.println("Add all from " + set);
    }
    while (iter.hasNext())
      add(iter.next());
	}


	public T removeRandom() {
    Random rand = new Random();
    int index = rand.nextInt(count);
    Iterator<T> iter = iterator();
    for (int i =0; i<index; i++) {
    	iter.next();
    }
    T element = iter.next();
    if (debug) {
      System.out.println("removeRandom  ");
    }
    return remove(element);
	}


	public SetADT<T> union(SetADT<T> set) {
    if (debug) {
      System.out.println(toString() + " union  " + set.toString());
    }
   SetADT<T> newSet = new HashedSet<T>(size);
   newSet.addAll(this);
   newSet.addAll(set);
  if (debug) {
     System.out.println("result = " + newSet.toString());
   }

   return newSet;

	}


	public boolean equals(SetADT<T> set) {
    if (set.size() != size())
      return false;
    Iterator<T> iter = iterator();
    while (iter.hasNext()) {
    	if (!set.contains(iter.next()))
    		return false;
    }
    return true;
	}


	public boolean isEmpty() {
		return count==0;
	}
	
  public boolean contains ( SetADT<T> s2){
    // contains implemented as a new method of the class
    boolean isSubset = true;
     Iterator<T> iter = s2.iterator();
     while (iter.hasNext())
       if (!this.contains(iter.next()))
         isSubset = false;
     return isSubset;
  }

}
