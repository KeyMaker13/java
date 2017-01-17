package sets.arrayset;

import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

import sets.*;

public class ArraySet<T> implements SetADT<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private int myCt;
  private T[] contents;
  private static boolean debug = false;

  public static void setDebug(boolean t) {
    debug = t;
  }

  public ArraySet (){
	  this(DEFAULT_CAPACITY);
	 

	//if (debug) {
   //   System.out.println("Create set. \n" + toString());
  //  }
  }
  public ArraySet (int initialCapacity){
	  myCt = 0;
	  contents = (T[])(new Object[initialCapacity]);
	if (debug) {
      System.out.println("Create set. \n" + toString());
    }
  }

  public void add(T element) {
	  if (contains(element)){// take care of duplicate
		  return;
	  }
	  if (myCt==contents.length)// take care of array size
	  {
		  expandCapacity();
	  }
	  contents[myCt]= element;
	  myCt++;
	  if (debug) {
      System.out.println("Add " + element+ "\n" + toString());
    }
  }

  public void addAll(SetADT<T> otherSet) {
	  Iterator<T> iter = otherSet.iterator();
	  while (iter.hasNext()){
		  add(iter.next());
	  }
	  

  }

  public T removeRandom() {
	  Random rand = new Random();
	  int index = rand.nextInt(myCt);
	    
    return remove(contents[index]);
  }

  public T remove(T element) {
	  if (isEmpty()){
		  throw new EmptySetException();
	  }
	  int index = -1;
	  for (int i = 0; i < myCt; i++){
		  if (element.equals(contents[i])){
			  index = i;
		  }
	  }
	  
	  if (index == -1){
		  throw new NoSuchElementException();
	  }
 
	 T toReturn = contents[index];
	 contents[index] = contents[myCt];
	 myCt--;
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
	  for (int i = 0; i< myCt; i++){
		  if (target.equals(contents[i])){
			  return true;
		  }
	  }
    return false;
  }

  // test if set s2 is contained in this set
  public Boolean contains ( SetADT<T> s2){
    // contains implemented as a new method of the class
    Boolean isSubset = true;
 
    return isSubset;
  }

  public boolean equals(SetADT<T> set) {
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
    for (int i = 0; i< myCt; i++)
    {
    	temp = temp+contents[i] + ", ";
    }
    if (myCt > 0){
    	temp += contents[myCt-1] + "";
    }
    temp = temp + "}";
    return temp;
  }

  @SuppressWarnings("unchecked")
private void expandCapacity(){
    T[] temp = (T[])(new Object[myCt*2]);
    for (int i = 0; i < myCt; i++){
      temp[i] = contents[i];
    }
    contents = temp;
  }

}
