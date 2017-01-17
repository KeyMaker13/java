package hashedset;

import java.util.*;

import lib.EmptySetException;
import lib.SetADT;
import lib.SimpleLinkedList;

public class HashedSet<T> implements SetADT<T> {
	private static final int DEFAULT_SIZE = 11;
  private static boolean debug = false;

	protected SimpleLinkedList<T>[] table;
	protected int tableSize;
	protected int count;

  public static void setDebug(boolean t) {
    debug = t;
  }

  public HashedSet (){
    this(DEFAULT_SIZE);
  }  

	public HashedSet(int size) {
		tableSize = size;
		table = new SimpleLinkedList[tableSize];
		for (int i = 0; i< tableSize; i++) {
			table[i] = new SimpleLinkedList<T>();
		}
		count = 0;
    if (debug) {
      System.out.println("Create set: " + toString());
    }

	}

	public void add(T element) {
		// use a hash function
		int bucket = Math.abs(element.hashCode()) % tableSize;
		// handles collision with external chaining
		if (!table[bucket].contains(element)) { // check for duplicate
			table[bucket].add(element);
			count++;
		}
	}

	
	public T remove(T element) {
    if (isEmpty())
      throw new EmptySetException();

    int bucket = Math.abs(element.hashCode()) % tableSize;
    if (table[bucket].isEmpty() || !table[bucket].contains(element))
      throw new NoSuchElementException();

    T result = table[bucket].remove(element);
    count--;
    if (debug) {
      System.out.println("remove  " + result + "\n" + toString());
    }
		return result;
	}

	// Returns true if the element is in the collection
	public boolean contains(T element) {
		int bucket = Math.abs(element.hashCode()) % tableSize;
	  if (table[bucket].contains(element))
	  	return true;
	  else 
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
		String result = "{";
		if (count > 0) {
			Iterator<T> iter = iterator();
			for( int i = 0; i< count-1; i++) {
				result += iter.next() + ", ";
			}
			result += iter.next();
		} 
		result += "}";
		
		if (debug) {
			result += "\n";
			for (int i = 0; i < tableSize; i++) {
					result += "bucket " + i + ": " + table[i] + "\n";
			}			
		}
		return result;
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
    int item = rand.nextInt(count);
    Iterator<T> iter = iterator();
    for (int i =0; i<item; i++) {
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
   SetADT<T> newSet = new HashedSet<T>(tableSize);
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
