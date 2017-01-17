package networksimulation;
import queues.*;
import java.util.*;

public class EventTester {
   public static void main(String[] args) {
      System.out.println("CS 1723 Lab 6 Part II: written by Tom Bylander");

      System.out.println("\nFirst bullet.  Create 4 events and print them out.\n");
      System.out.println(new Event(0, Event.STOP, 25, 0));
      System.out.println(new Event(1, Event.MSG_ARRIVAL, 13, 2));
      System.out.println(new Event(2, Event.MSG_ROUTE, 13, 3));
      System.out.println(new Event(3, Event.MSG_SENT, 23, 2));

      System.out.println("\nSecond bullet." +
                         "  100 events on, then off, the priority queue" +
                         " and average interarrival time.\n");
      Random rand = new Random();
      PriorityQueueADT<Event> p = new LinkedPriorityQueue<Event>();
      for (int i = 0; i < 100; i++) {
        p.add(new Event(i, Event.MSG_ARRIVAL, 1000*rand.nextDouble(), i));
      }
      double sum = 0;
      double lastTime = 0;
      int count = 0;
      while (! p.isEmpty()) {
        Event e = p.removeMin();
        sum += e.getWhen() - lastTime;
        lastTime = e.getWhen();
        count++;
      }
      System.out.println("Average interarrival time is " + (sum / count));

      System.out.println("\nThird bullet.  Creating a silly event.\n");
      System.out.println(new Event(-13, 6, 3.14156, 13));

      System.out.println("\nFourth and fifth bullet.  " +
                         "15 events on, then off, the priority queue.\n");
      for (int i = 0; i < 15; i++) {
        p.add(new Event(1, Event.MSG_ARRIVAL, 10 + i*10, 2));
      }
      lastTime = 0;
      while (! p.isEmpty()) {
        Event e = p.removeMin();
        System.out.println(e + " with interarrival time " +
                           (e.getWhen() - lastTime));
        lastTime = e.getWhen();
      }
   }
}
