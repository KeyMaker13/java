package networksimulation;
import queues.*;
import java.util.*;

public class OutgoingLineTester {
  public static void main(String[] args) {
    System.out.println("CS 1723 Lab 6 Part V: written by Tom Bylander");

    OutgoingLine outgoing = new OutgoingLine(2,5);
    PriorityQueueADT<Event> p = new LinkedPriorityQueue<Event>();
    Random rand = new Random();
    for (int i = 0; i < 20; i++)
      p.add(new Event(1, Event.MSG_ROUTE, 100*rand.nextDouble(), 2));
    while (! p.isEmpty())
      outgoing.processEvent(p.removeMin());
    System.out.println(outgoing);

  }
}
