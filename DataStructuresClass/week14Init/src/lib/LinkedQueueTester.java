package lib;
import lib.*;

import java.util.*;

public class LinkedQueueTester {
  public static void main(String[] args) {
    LinkedQueue.setDebug(true);

    QueueADT<Integer> q = new LinkedQueue<Integer>();
    try {
      q.enqueue(new Integer(4));
      q.enqueue(15);
      Integer a = q.dequeue();
      Integer b = q.dequeue();
      System.out.println("Integers a=" + a + ", b=" + b);
      //q.dequeue();
    } catch (NoSuchElementException e) {
      System.err.println("Good, got exception " + e);
    }
  }
}
