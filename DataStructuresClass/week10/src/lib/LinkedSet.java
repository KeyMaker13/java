package lib;

import java.util.*;

import lib.EmptySetException;
import lib.SetADT;


public class LinkedSet<T> implements SetADT<T>{
  private static Random rand = new Random();

  protected LinearNode<T> contents;
  protected int count;

  protected static boolean debug = false;
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
    while (temp != null && !temp.getElement().equals(target)) {
      temp = temp.getNext();
    }
    return (temp != null);
  }

  public void add(T element) {
    if (!contains(element)) {
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
    if (isEmpty()) {
      throw new EmptySetException();
    }
    if (!contains(element)) {
      throw new NoSuchElementException();
    }
    count--;
    LinearNode<T> curr = contents;
    if (contents.getElement().equals(element)) {
      contents = contents.getNext();
    } else {
      LinearNode<T> prev = null;
      while (!curr.getElement().equals(element)) {
        prev = curr;
        curr = curr.getNext();
      }
      prev.setNext(curr.getNext());
    }
     if (debug) {
      System.out.println("remove  " + curr.getElement() + "\n" + toString());
    }
    return curr.getElement();
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
    if (debug) {
      System.out.println("removeRandom  ");
    }
    if (isEmpty()) {
      throw new EmptySetException();
    }
    int choice = rand.nextInt(count);
    LinearNode<T> temp = contents;
    for (int i =0; i<choice; i++) {
      temp = temp.getNext();
    }
    return remove(temp.getElement());
  }

  public SetADT<T> union(SetADT<T> other) {
    if (debug) {
      System.out.println(toString() + " union  " +
                         other.toString());
    }

    LinkedSet<T> newSet = new LinkedSet<T>();
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
