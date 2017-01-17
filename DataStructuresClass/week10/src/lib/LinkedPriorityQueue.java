package lib;
import java.util.*;

public class LinkedPriorityQueue<T extends Comparable>
    implements PriorityQueueADT<T>{
   private LinearNode<T> front;
   private int count;

   private static boolean debug = false;
   public static void setDebug(boolean t) {
     debug = t;
   }

   public LinkedPriorityQueue() {
     front = null;
     count = 0;
      if (debug) {
        System.out.println("Construct LinkedPriorityQueue" +
            "\n" + toString());
      }
   }

   public void add(T element) {
    LinearNode<T> node = new LinearNode<T>(element);
    count++;
    if (front == null ||
       element.compareTo( (T)front.getElement() ) <= 0) {
       // add as the first element
       node.setNext(front);
       front = node;
    } else {
      // search for the correct position
      LinearNode<T> next = front;
      // move to next position if it is not the end and
      // the element has a lower priority
      while (next.getNext()!=null &&
          element.compareTo(next.getNext().getElement())>0) {
        next = next.getNext();
      }
      // add the new element at this position
     node.setNext(next.getNext());
      next.setNext(node);


    }
    if (debug) {
      System.out.println("add " + element +
          "\n" + toString());
    }
   }

   public T removeMin() {
      if (front == null)
         throw new NoSuchElementException(
               "Tried to remove from empty priority queue");
      // remove the first element
      LinearNode<T> node = front;
      front = front.getNext();
      count--;
      if (debug) {
        System.out.println("removeMin " + node.getElement() +
            "\n" + toString());
      }
      return node.getElement();
   }

   public T findMin() {
     if (front == null)
         throw new NoSuchElementException(
               "Tried to remove from empty priority queue");
      return front.getElement();
   }

   public boolean isEmpty() {
      return count == 0;
   }

   public void makeEmpty() {
      front = null;
      count = 0;
      if (debug) {
        System.out.println("makeEmpty" +
            "\n" + toString());
      }
   }

   public int size() {
      return count;
   }

   public String toString() {
      StringBuffer buf = new StringBuffer(
            getClass().getName() + " size=" + count);
      LinearNode<T> next = front;
      buf.append("\nfront ------------>");
      while (next != null) {
         buf.append("\n" + next.getElement());
         next = next.getNext();
      }
      buf.append("\n<------------ rear");

      return buf.toString();
   }

}
