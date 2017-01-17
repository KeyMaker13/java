package datastructures;
import java.util.*;

public class LinkedQueueTester {
  public static void main(String[] args) {
    QueueADT<Integer> q = new LinkedQueue<Integer>();
    System.out.println("q is " + q);
    q.enqueue(new Integer(4));
    q.enqueue(15);
    System.out.println("q after adding 2 items " + q);
    System.out.println("removing " + q.dequeue());
    System.out.println("q is now " + q);
    q.dequeue();
    System.out.println("q after removing another is " + q);
   try {
       q.dequeue();
       System.out.println("q is " + q);
  } catch (NoSuchElementException e) {
    System.err.println("Good, got exception " + e);
  }
  }
}
