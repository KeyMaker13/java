package lib;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BasicLinkedList<T> implements ListADT<T> {
  protected DoubleNode<T> front;
  protected DoubleNode<T> rear;
  protected int count;
  protected static boolean debug = false;

  public static void setDebug(boolean t) {
    debug = t;
  }

public BasicLinkedList(){
  count = 0;
  front = null;
  rear = null;
  if (debug) {
    System.out.println("Create new list " + toString());
  }
}

  public T removeFirst() {
    if (count == 0)
      throw new EmptySetException();
    DoubleNode<T> temp = front;
    count--;
    front = front.getNext();
    if (front==null) {
      rear = null;
      return temp.getElement();
    }
    front.setPrevious(null);
    if (debug) {
     System.out.println("removeFirst \n" + toString());
   }

    return temp.getElement();
  }

  public T removeLast() {
    if (count == 0)
      throw new EmptySetException();
    DoubleNode<T> temp = rear;
    count--;
    rear = rear.getPrevious();
    if (rear==null) {
      front = null;
      return temp.getElement();
    }
    rear.setNext(null);

    if (debug) {
     System.out.println("removeLast \n" + toString());
   }

    return temp.getElement();
  }

  public T remove(T element) {
    if (count == 0)
      throw new EmptySetException();
    DoubleNode<T> current = front;
    while(current != null &&
       !current.getElement().equals(element) ) {
      current = current.getNext();
    }
    if (current == null) {
      throw new NoSuchElementException();
    }

    if (debug) {
      System.out.println("remove " + element + " \n" + toString());
    }

    if (current == front) {
      return removeFirst();
    } else {
      if (current == rear) {
        return removeLast();
      } else {
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        count--;
        return current.getElement();
      }
    }
  }

  public T first() {
    if (count == 0)
      throw new EmptySetException();
    return front.getElement();
  }

  public T last() {
    if (count == 0)
      throw new EmptySetException();
    return rear.getElement();
  }

  public boolean contains(T target) {
    DoubleNode<T> current = front;
    while(current != null)
      if (current.getElement().equals(target))
        return true;
    return false;
  }

  public boolean isEmpty() {
    return count==0;
  }

  public int size() {
    return count;
  }

  public Iterator<T> iterator() {
     return new DoubleIterator<T>(front, count);
  }  // method elements


  public String toString() {
    String toReturn = "List: [";
    DoubleNode<T> current = front;
    while(current != null){
      toReturn = toReturn + current.getElement() + " ";
      current = current.getNext();
    }
    toReturn = toReturn + "]";
    return toReturn;
  }
}
