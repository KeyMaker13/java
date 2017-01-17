package networksimulation;

import queues.*;

public class OutgoingLine
    implements EventHandler {
  private int ID;
  private int messagesSent;
  private int messagesLost;
  private double sendTime; // time to send a message
  private double whenDone;

  public OutgoingLine(int ID, double sendTime) {
    this.ID = ID;
    messagesSent = 0;
    messagesLost = 0;
    this.sendTime = sendTime;
    whenDone = 0.0;
  }

  // This has no initial event so return null
  public Event initialEvent() {
    return null;
  }

  // If a message is routed to this line, send it or drop it
  public Event processEvent(Event event) {
    if (ID == event.getWhom() &&
        Event.MSG_ROUTE == event.getWhat()) {
      if (event.getWhen() >= whenDone) {
        messagesSent++;
        whenDone = event.getWhen() + sendTime;
        return new Event(ID, Event.MSG_SENT, whenDone, event.getWho());
      } else {
        messagesLost++;
      }
    }
    return null;
  }

  public int getID() {
    return ID;
  }

  public int getMessagesSent() {
    return messagesSent;
  }

  public double getSendTime() {
    return sendTime;
  }

  public double getWhenDone() {
    return whenDone;
  }

  public double getUtilization() {
    return (messagesSent == 0) ? 0.0 : messagesSent * sendTime / whenDone;
  }

  public String toString() {
    String result = "Outgoing: ID=" + ID;
    result += ", line speed=" + sendTime;
    result += ", msgs sent=" + messagesSent;
    result += ", msgs lost=" + messagesLost;
    result += ", utilization=" + getUtilization();
    return result;
  }
}
