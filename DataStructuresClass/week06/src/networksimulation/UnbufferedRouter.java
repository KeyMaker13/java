package networksimulation;

import queues.*;
import lib.*;
import java.util.*;

public class UnbufferedRouter
    implements EventHandler {
  private int ID;
  private int outgoingID;
  private int messagesRouted;

  // These two attributes are added for multiple output lines,
  // which is for the fourth bullet of Part VI.
  private int messagesLost;
  private ArraySet<Integer> available;

  public UnbufferedRouter(int ID, int outgoingID) {
    this.ID = ID;
    this.outgoingID = outgoingID;
    messagesRouted = 0;
  }

  // Constructor for multiple output lines (fourth bullet of Part VI)

  public UnbufferedRouter(int ID, int outgoingID, int numberOutputLines) {
    this.ID = ID;
    available = new ArraySet<Integer>();
    for (int i = 0; i < numberOutputLines; i++)
      available.add(outgoingID + i);
    messagesRouted = 0;
    messagesLost = 0;
  }

  // This has no initial event so return null
  public Event initialEvent() {
    return null;
  }

  // If a message arrived for the router, route it
  public Event processEvent(Event event) {
    if (available == null) {
      // original code before multiple output lines
      if (ID == event.getWhom() &&
          Event.MSG_ARRIVAL == event.getWhat()) {
        messagesRouted++;
        return new Event(ID, Event.MSG_ROUTE, event.getWhen(), outgoingID);
      }
      return null;
    }

    // code for multiple output lines (fourth bullet of Part VI)

    // Recognize arrivals for this router and route or lose message
    if (ID == event.getWhom() &&
        Event.MSG_ARRIVAL == event.getWhat()) {
      if (available.isEmpty()) {
        messagesLost++;
      } else {
        messagesRouted++;
        return new Event(ID, Event.MSG_ROUTE, event.getWhen(),
                         available.removeRandom());
      }
    }

    // need to recognize when an outgoing line becomes available
    // and add it to the ArraySet.
    if (ID == event.getWhom() &&
        Event.MSG_SENT == event.getWhat()) {
      available.add(event.getWho());
    }

    return null;
  }

  public int getID() {
    return ID;
  }

  public int getMessagesRouted() {
    return messagesRouted;
  }

  public String toString() {
    if (available == null) {
      // original code before multiple lines added
      return "Router: ID=" + ID +
          ", msgs routed=" + messagesRouted;
    }

    // code for multiple output lines (fourth bullet of Part VI)
    return "Router: ID=" + ID +
        ", msgs routed=" + messagesRouted +
        ", msgs lost=" + messagesLost;
  }
}
