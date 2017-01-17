package datastructures;
import java.util.*;

public class LinkedPriorityQueueTester {
   public static void main(String[] args) {
      PriorityQueueADT<Comparable> q = new LinkedPriorityQueue();
      Random rand = new Random();

      for (int i = 0; i < 100; i++) {
         q.add(new Integer(rand.nextInt(1000) + 1));
      }

      for (int i = 0; i < 100; i++)
         System.out.println("[" + i + "]:" + q.removeMin());

      q.add("Oranges");
      System.out.println("q after oranges is " + q);
      System.out.println("First element is " + q.findMin());
      System.out.println("q size is " + q.size());
      q.add("Apples");
      System.out.println("q after Apples " + q);
   }
}
