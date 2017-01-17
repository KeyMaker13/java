package sets.arrayset;

import java.lang.reflect.Array;
import java.util.*;
import sets.*;

/**
 * @author Prof. Weining Zhang
 *
 */
public class ArraySet<T> implements SetADT<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private static boolean debug = false;

	private int myCt;
	private T[] contents;

	public static void setDebug(boolean t) {
		debug = t;
	}

	public ArraySet() {
		this(DEFAULT_CAPACITY);
	}

	public ArraySet(int initialCapacity) {
		myCt = 0;
		contents = (T[]) (new Object[initialCapacity]);
		if (debug) {
			System.out.println("Create set: " + toString());
		}
	}

	public ArraySet(Class<T> type, int initialCapacity) {
		myCt = 0;
		contents = (T[]) Array.newInstance(type, initialCapacity);
		if (debug) {
			System.out.println("Create set: " + toString());
		}
	}

	public boolean contains(T target) {
		for (int i = 0; i < myCt; i++) {
			if (contents[i].equals(target))
				return true;
		}
		return false;
	}

	public void add(T element) {
		if (contains(element))
			return;
		if (myCt == contents.length) {
			expandCapacity();
		}
		contents[myCt] = element;
		myCt++;
		if (debug) {
			System.out.println("Added element " + element + "\n" + toString());
		}
	}

	public void addAll(SetADT<T> set) {
		if (debug) {
			System.out.println("Add all from " + set);
		}
		Iterator<T> iter = set.iterator();
		while (iter.hasNext())
			add(iter.next());
	}

	public T removeRandom() {
		if (debug) {
			System.out.println("removeRandom  ");
		}
		Random rand = new Random();
		int index = rand.nextInt(myCt);
		return remove(contents[index]);
	}

	public T remove(T element) {
		if (isEmpty())
			throw new EmptySetException();
		int index = -1;
		for (int i = 0; i < myCt; i++)
			if (contents[i].equals(element))
				index = i;
		if (index == -1)
			throw new NoSuchElementException();
		T toReturn = contents[index];
		contents[index] = contents[--myCt];
		if (debug) {
			System.out.println("removed element  " + toReturn + "\n" + toString());
		}
		return toReturn;
	}

	public SetADT<T> union(SetADT<T> set) {
		if (debug) {
			System.out.println(toString() + " union  " + set.toString());
		}
		SetADT<T> newSet = new ArraySet<T>();
		newSet.addAll(this);
		newSet.addAll(set);
		if (debug) {
			System.out.println("result = " + newSet.toString());
		}
		return newSet;
	}

	// test if set s2 is contained in this set
	public boolean contains(SetADT<T> s2) {
		// contains implemented as a new method of the class
		boolean isSubset = true;
		Iterator<T> iter = s2.iterator();
		while (iter.hasNext())
			if (!this.contains(iter.next()))
				isSubset = false;
		return isSubset;
	}

	public boolean equals(SetADT<T> set) {
		if (set.size() != size())
			return false;
		for (int i = 0; i < myCt; i++) {
			if (!set.contains(contents[i]))
				return false;
		}
		return true;
	}

	public boolean isEmpty() {
		return myCt == 0;
	}

	public int size() {
		return myCt;
	}

	public Iterator<T> iterator() {
		return new ArrayIterator<T>(contents, myCt);
	}

	public String toString() {
		String temp = "{";
		for (int i = 0; i < myCt - 1; i++) {
			temp = temp + contents[i] + ", ";
		}
		if (myCt > 0) {
			temp += contents[myCt - 1] + "";
		}
		temp += "}";
		return temp;
	}

	//-----Helper Methods ----------------------------------------
	private void expandCapacity() {
		T[] temp = (T[]) (new Object[myCt * 2]);
		for (int i = 0; i < myCt; i++) {
			temp[i] = contents[i];
		}
		contents = temp;
	}

	private void expandCapacity(Class<T> type) { // another way to do this
		T[] temp = (T[]) Array.newInstance(type, myCt * 2);
		for (int i = 0; i < myCt; i++) {
			temp[i] = contents[i];
		}
		contents = temp;
	}

}
