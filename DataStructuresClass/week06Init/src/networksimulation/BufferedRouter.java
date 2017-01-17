package networksimulation;

import queues.*;
import java.util.*;

public class BufferedRouter
    implements EventHandler {
  private int ID;
  private int outgoingID;
  private boolean outgoingReady;
  private int messagesRouted;
  private QueueADT<Event> messageBuffer;
  private double bufferTime;

  public BufferedRouter(int ID, int outgoingID) {
    this.ID = ID;
    this.outgoingID = outgoingID;
    outgoingReady = true;
    messagesRouted = 0;
    messageBuffer = new LinkedQueue<Event> ();
    bufferTime = 0;
  }

  // This has no initial event so return null
  public Event initialEvent() {
    return null;
  }

  // If a message arrived for the router, send it or queue it
  public Event processEvent(Event event) {
    if (ID == event.getWhom() &&
        Event.MSG_ARRIVAL == event.getWhat()) {
      if (outgoingReady) {
        messagesRouted++;
        outgoingReady = false;
        return new Event(ID, Event.MSG_ROUTE, event.getWhen(), outgoingID);
      }
      else {
        messageBuffer.enqueue(event);
      }
    } else if (ID == event.getWhom() &&
               Event.MSG_SENT == event.getWhat()) {
      outgoingReady = true;
      if (! messageBuffer.isEmpty()) {
        Event oldEvent = messageBuffer.dequeue();
        bufferTime += event.getWhen() - oldEvent.getWhen();
        messagesRouted++;
        outgoingReady = false;
        return new Event(ID, Event.MSG_ROUTE, event.getWhen(), outgoingID);
      }
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
    String result = "Router: ID=" + ID;
    result += ", msgs routed=" + messagesRouted;
    if (messagesRouted > 0) {
      result += ", avg wait time=" + bufferTime / messagesRouted;
    }
    return result;
  }
}
