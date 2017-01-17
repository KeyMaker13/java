package networksimulation;

public class UnbufferedNodeModel
    extends SimulationModel {
  private int receivedMessages;
  private int routedMessages;
  private int sentMessages;

  public UnbufferedNodeModel(double arrival, double sendtime) {
    super("UnbufferedNodeModel");
    addHandler(new IncomingLine(1, arrival, 2));
    addHandler(new UnbufferedRouter(2, 3));
    addHandler(new OutgoingLine(3, sendtime));
    receivedMessages = 0;
    routedMessages = 0;
    sentMessages = 0;
  }

  // This constructor is for the fourth bullet of Part VI
  // Other changes for this bullet are in the UnbufferedRouter class

  public UnbufferedNodeModel(double arrival, double sendtime,
                             int inLines, int outLines) {
    super("UnbufferedNodeModel");
    int routerID = inLines + 1;
    for (int i = 1; i <= inLines; i++)
      addHandler(new IncomingLine(i, arrival, routerID));
    addHandler(new UnbufferedRouter(routerID, routerID + 1, outLines));
    for (int i = 1; i <= outLines; i++)
      addHandler(new OutgoingLine(routerID + i, sendtime));
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
