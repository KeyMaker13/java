package networksimulation;

import queues.*;

public class BufferedNodeModel
    extends SimulationModel {
  private int receivedMessages;
  private int routedMessages;
  private int sentMessages;

  public BufferedNodeModel(double arrival, double sendtime) {
    super("BufferedNodeModel");
    addHandler(new IncomingLine(1, arrival, 2));
    addHandler(new BufferedRouter(2, 3));
    addHandler(new OutgoingLine(3, sendtime));
    receivedMessages = 0;
    routedMessages = 0;
    sentMessages = 0;
  }

  public void processEvent(Event e) {
    super.processEvent(e);
    switch (e.getWhat()) {
      case Event.MSG_ARRIVAL:
        receivedMessages++;
        break;
      case Event.MSG_ROUTE:
        routedMessages++;
        break;
      case Event.MSG_SENT:
        sentMessages++;
        break;
      case Event.STOP:
        break;
      default:
        System.err.println(e + " {unrecognized event}");
        break;
    }
  }

  public int getReceivedMessages() {
    return receivedMessages;
  }

  public int getSentMessages() {
    return sentMessages;
  }

  public int getRoutedMessages() {
    return routedMessages;
  }

  public String toString() {
    return super.toString()
        + "\nReceived Messages=" + getReceivedMessages()
        + ", Routed Messages=" + getRoutedMessages()
        + ", Sent Messages=" + getSentMessages();
  }
}
