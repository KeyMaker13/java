package datastructures;
import java.util.*;

public class LinkedPriorityQueue implements PriorityQueueADT{
   private LinearNode<Comparable> front;
   private int count;

   public LinkedPriorityQueue() {
      front = null;
      count = 0;
   }

   public void add(Comparable element) {
      LinearNode<Comparable> node = new LinearNode(element);
    count++;
    if (front == null ||
        element.compareTo( front.getElement() ) <= 0) {
       node.setNext(front);
       front = node;
       return;
    }
    LinearNode<Comparable> next = front;
    while (next.getNext() != null &&
           element.compareTo( next.getNext().getElement() ) > 0)
       next = next.getNext();
    node.setNext(next.getNext());
    next.setNext(node);
   }

   public Comparable removeMin() {
      if (front == null)
         throw new NoSuchElementException(
               "Tried to remove from empty priority queue");
      LinearNode<Comparable> node = front;
      front = node.getNext();
      count--;
      return node.getElement();
   }

   public Comparable findMin() {
      if (front == null)
         throw new NoSuchElementException(
               "Tried to peek empty queue");
      return front.getElement();
   }

   public boolean isEmpty() {
      return count == 0;
   }

   public void makeEmpty() {
      front = null;
      count = 0;
   }

   public int size() {
      return count;
   }

   public String toString() {
      StringBuffer buf = new StringBuffer(
            getClass().getName() + " size=" + count);
      LinearNode<Comparable> next = front;
      while (next != null) {
         buf.append("\n" + next.getElement());
         next = next.getNext();
      }
      return buf.toString();
   }

}
