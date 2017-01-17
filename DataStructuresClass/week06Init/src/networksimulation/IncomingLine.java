package networksimulation;

import java.util.*;

public class IncomingLine
    implements EventHandler {
  private double interarrival;
  private int ID;
  private int routerID;
  private int totalMessages;
  private Random rand;
  private double clock;

  public IncomingLine(int ID, double interarrival, int routerID) {
    this.interarrival = interarrival;
    this.ID = ID;
    this.routerID = routerID;
    totalMessages = 0;
    rand = new Random(ID + 1); // each Random has different seed
    clock = 0;
  }

  // return the next arrival event
  public Event getNextArrival() {
    clock += 2 * interarrival * rand.nextDouble();
    totalMessages++;
    return new Event(ID, Event.MSG_ARRIVAL, clock, routerID);
  }

  // return average interarrival time
  public double getAverageInterarrival() {
    if (totalMessages == 0)
      return 0;
    return clock / totalMessages;
  }

  // return the first arrival event
  public Event initialEvent() {
    return getNextArrival();
  }

  // return the next arrival event if this event is the previous one
  public Event processEvent(Event event) {
    if (ID == event.getWho() &&
        Event.MSG_ARRIVAL == event.getWhat())
      return getNextArrival();
    return null;
  }

  public int getID() {
    return ID;
  }

  public double getClock() {
    return clock;
  }

  public int getTotalMessages() {
    return totalMessages;
  }

  public String toString() {
    return "Incoming: ID=" + ID +
        ", average interarrival time=" + interarrival +
        ", actual interarrival time=" + getAverageInterarrival() +
        ", current time=" + clock +
        ", messages generated=" + totalMessages;
  }
}
