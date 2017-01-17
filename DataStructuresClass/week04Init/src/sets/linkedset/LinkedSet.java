package sets.linkedset;

import java.util.*;

import lib.SetADT;
import sets.*;



public class LinkedSet<T> implements SetADT<T>{
  private static Random rand = new Random();

  protected LinearNode<T> contents;
  protected int count;

  private static boolean debug = false;
  public static void setDebug(boolean t) {
    debug = t;
  }

  public LinkedSet(){
	  count = 0;
	  contents = null;
    if (debug) {
      System.out.println("Create set: " + toString());
    }
  }

  public boolean contains(T target) {
    LinearNode<T> temp = contents;
    while(temp != null && !temp.getElement().equals(target)){
    	temp = temp.getNext();
    }
    return (temp != null);
  }

  public void add(T element) {
	  if (!contains(element)){
		  LinearNode<T> node = new LinearNode<T>(element);
		  node.setNext(contents);
		  contents = node;
		  count++;
	  }
     if (debug) {
      System.out.println("Add " + element+ "\n" + toString());
    }
  }

  public T remove(T element) {
     LinearNode<T> curr = contents;
      if (debug) {
      System.out.println("remove  " + curr.getElement() + "\n" + toString());
    }
    return curr.getElement();
  }

  public void addAll(SetADT<T> set) {

    if (debug) {
      System.out.println("Add all from " + set);
    }
  }

  public T removeRandom() {
    if (debug) {
      System.out.println("removeRandom  ");
    }
    LinearNode<T> temp = contents;
    return remove(temp.getElement());
  }

  public SetADT<T> union(SetADT<T> other) {
    if (debug) {
      System.out.println(toString() + " union  " +
                         other.toString());
    }

    LinkedSet<T> newSet = new LinkedSet<T>();
   if (debug) {
      System.out.println("result=  " +
                         newSet.toString());
    }
    return newSet;
  }


  public boolean contains( SetADT<T> other){
     return true;
  }

  public boolean equals(SetADT<T> otherSet) {
    return true;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public int size() {
    return count;
  }

  public Iterator<T> iterator() {
    return new LinkedIterator<T>(contents);
  }

  public String toString() {
    LinearNode<T> temp = contents;
    String toReturn = "{";
    // first count-1 elements
    for (int i=0; i<count-1; i++) {
      toReturn = toReturn + temp.getElement() + ", ";
      temp = temp.getNext();
    }
    // the last element
    if (count>0) {
      toReturn = toReturn + temp.getElement() + "";   	
    }
    return toReturn + "}";
  }
}
