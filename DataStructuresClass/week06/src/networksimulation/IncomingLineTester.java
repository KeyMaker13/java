package networksimulation;
import queues.*;

public class IncomingLineTester {
  public static void main(String[] args) {
    System.out.println("CS 1723 Lab 6 Part III: written by Tom Bylander");

    System.out.println("\nFirst bullet." +
                       "  Generate 100 message arrival events" +
                       " and calculate interarrival time.\n");
    double sum = 0;
    double count = 0;
    double lastTime = 0;
    IncomingLine incoming = new IncomingLine(1, 30, 2);
    for (int i = 0; i < 100; i++) {
      Event e = incoming.getNextArrival();
      sum += e.getWhen() - lastTime;
      lastTime = e.getWhen();
      count++;
    }
    System.out.println("Average interarrival time is " + (sum / count));

    System.out.println("\nSecond through fourth bullets." +
                       "  Test toString method" +
                       " and (indirectly) getAverageInterarrival method.\n");
    sum = 0;
    count = 0;
    lastTime = 0;
    incoming = new IncomingLine(1, 30, 2);
    for (int i = 0; i < 100; i++) {
      Event e = incoming.getNextArrival();
      sum += e.getWhen() - lastTime;
      lastTime = e.getWhen();
      count++;
    }
    System.out.println(incoming);

    System.out.println("\nFifth bullet.  " +
                       "Generate events from two incoming lines.\n");
    IncomingLine incoming1 = new IncomingLine(1, 30, 3);
    IncomingLine incoming2 = new IncomingLine(2, 10, 3);
    PriorityQueueADT<Event> p = new LinkedPriorityQueue<Event>();
    for (int i = 0; i < 5; i++) {
      p.add(incoming1.getNextArrival());
      p.add(incoming2.getNextArrival());
    }
    sum = 0;
    count = 0;
    lastTime = 0;
    while (! p.isEmpty()) {
      Event e = p.removeMin();
      System.out.println(e);
      sum += e.getWhen() - lastTime;
      lastTime = e.getWhen();
      count++;
    }
    System.out.println("Average interarrival time is " + (sum / count));

    System.out.println("\nSixth bullet.  " +
                       "Generate events from ten incoming lines.\n");
    sum = 0;
    count = 0;
    lastTime = 0;
    IncomingLine[] incomings = new IncomingLine[10];
    for (int i = 0; i < 10; i++) {
      incomings[i] = new IncomingLine(i + 1, 5, 11);
    }
    p.makeEmpty();
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 10; j++) {
        p.add(incomings[j].getNextArrival());
      }
    }
    while (! p.isEmpty()) {
      Event e = p.removeMin();
      // System.out.println(e);
      sum += e.getWhen() - lastTime;
      lastTime = e.getWhen();
      count++;
    }
    System.out.println("Average interarrival time is " + (sum / count));
  }
}
