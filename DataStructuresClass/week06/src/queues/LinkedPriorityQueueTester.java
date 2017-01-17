package queues;
import java.util.*;

public class LinkedPriorityQueueTester {
   public static void main(String[] args) {
      LinkedPriorityQueue.setDebug(true);

      PriorityQueueADT<Comparable> q = new LinkedPriorityQueue<Comparable>();
      Random rand = new Random();
      System.out.println("Is q empty? " + q.isEmpty() + "\n");

      for (int i = 0; i < 10; i++) {
         q.add(new Integer(rand.nextInt(1000) + 1));
      }
      System.out.println("\nFirst element is " + q.findMin());
      System.out.println("q size is " + q.size() + "\n");

      for (int i = 0; i < 5; i++){
        System.out.println("We got " + q.removeMin() + "\n");
      }
      //q.add("Oranges");
   }
}
