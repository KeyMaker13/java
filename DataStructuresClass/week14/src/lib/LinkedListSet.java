package lib;

import java.util.*;

import lib.EmptySetException;
import lib.SetADT;


public class LinkedListSet<T> implements SetADT<T>{
  protected SimpleListADT<T> list;

  protected static boolean debug = false;
  public static void setDebug(boolean t) {
    debug = t;
  }

  public LinkedListSet(){
    list = new SimpleLinkedList<T>();
    if (debug) {
      System.out.println("Create set: " + toString());
    }
  }

  public boolean contains(T target) {
    return list.contains(target);
  }

  public void add(T element) {
    if (!list.contains(element)) {
    	list.add(element);
    }
    if (debug) {
      System.out.println("Add " + element+ "\n" + toString());
    }
  }

  public T remove(T element) {
    return list.remove(element);
  }

  public void addAll(SetADT<T> set) {

    if (debug) {
      System.out.println("Add all from " + set);
    }
    Iterator<T> iter = set.iterator();
    while (iter.hasNext()) {
      this.add(iter.next());
    }
  }

  public T removeRandom() {
  	return list.removeRandom();
  }

  public SetADT<T> union(SetADT<T> other) {
    if (debug) {
      System.out.println(toString() + " union  " +
                         other.toString());
    }

    LinkedListSet<T> newSet = new LinkedListSet<T>();
    newSet.addAll(this);
    newSet.addAll(other);
    if (debug) {
      System.out.println("result=  " +
                         newSet.toString());
    }
    return newSet;
  }


  public boolean contains( SetADT<T> other){
    Iterator<T> iter = other.iterator();
    while (iter.hasNext()) {
      if (!contains(iter.next())) {
        return false;
      }
    }
      return true;
  }

  public boolean equals(SetADT<T> otherSet) {
    if (size() != otherSet.size()) {
      return false;
    }
    Iterator<T> iter = this.iterator();
    while (iter.hasNext()) {
      if (!otherSet.contains(iter.next())) {
        return false;
      }
    }
    return true;
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int size() {
    return list.size();
  }

  public Iterator<T> iterator() {
    return list.iterator();
  }

  public String toString() {  
    return list.toString();
  }
}
