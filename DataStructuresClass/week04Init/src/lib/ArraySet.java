package lib;

import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;



/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author Prof. Weining Zhang
 * @version 1.0
 */
public class ArraySet<T> implements SetADT<T> {
  private final int DEFAULT_CAPACITY = 10;
  private int myCt;
  private T[] contents;
  private static boolean debug = false;

  public static void setDebug(boolean t) {
    debug = t;
  }

  public ArraySet (){
    myCt = 0;
    contents = (T[])(new Object[DEFAULT_CAPACITY]);
    if (debug) {
      System.out.println("Create set. \n" + toString());
    }
  }
  public ArraySet (int initialCapacity){
    myCt = 0;
    contents = (T[])(new Object[initialCapacity]);
    if (debug) {
      System.out.println("Create set. \n" + toString());
    }
  }

  public void add(T element) {
    if (!contains(element)) {
      if (myCt == contents.length) {
        expandCapacity();
      }
      contents[myCt] = element;
      myCt++;
    }
    if (debug) {
      System.out.println("Add " + element+ "\n" + toString());
    }
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
    int index = rand.nextInt(myCt);
    if (debug) {
      System.out.println("removeRandom  ");
    }
    return remove(contents[index]);
  }

  public T remove(T element) {
    if (isEmpty())
      throw new EmptySetException();
    int index = -1;
    for (int i =0; i < myCt; i++)
      if (contents[i].equals(element))
        index = i;
    if (index == -1)
      throw new NoSuchElementException();
    T toReturn = contents[index];
    contents[index] = contents[--myCt];
    if (debug) {
       System.out.println("remove  " + toReturn + "\n" + toString());
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


  public boolean contains(T target) {
    for (int i=0; i < myCt; i++){
      if (contents[i].equals(target))
        return true;
    }
    return false;
  }

  // test if set s2 is contained in this set
  public boolean contains ( SetADT<T> s2){
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
    for (int i=0; i < myCt; i++){
      if (!set.contains(contents[i]))
        return false;
    }
    return true;
  }

  public boolean isEmpty() {
    return myCt==0;
  }

  public int size() {
    return myCt;
  }

  public Iterator<T> iterator() {
    return new ArrayIterator<T> (contents,myCt);
  }

  public String toString (){
    String temp = "{";
    for (int i = 0; i < myCt-1; i++) {
      temp = temp + contents[i]+", ";
    }
    if (myCt>0) {
      temp =temp + contents[myCt-1] + "";
    }
    temp = temp + "}";
    return temp;
  }

  private void expandCapacity(){
    T[] temp = (T[])(new Object[myCt*2]);
    for (int i = 0; i < myCt; i++){
      temp[i] = contents[i];
    }
    contents = temp;
  }

}
