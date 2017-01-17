package networksimulation;

public class IncomingOnlyModel
    extends SimulationModel {
  private int numberMessages;
  private double lastTime;

  public IncomingOnlyModel(String title, double arrival) {
    super(title); // do all of the general initialization first
    addHandler(new IncomingLine(1, arrival, 2));
    numberMessages = 0;
  }

  // This constructor is for fifth bullet of part IV

  public IncomingOnlyModel(String title, double arrival, int lines) {
     super(title); // do all of the general initialization first
     for (int line = 1; line <= lines; line++)
       addHandler(new IncomingLine(line, arrival, lines+1));
     numberMessages = 0;
  }

  public void processEvent(Event e) {
    super.processEvent(e);
    switch (e.getWhat()) {
      case Event.MSG_ARRIVAL:
        numberMessages++;
        lastTime = e.getWhen();
        break;
      case Event.STOP:
        break;
      default:
        System.err.println(e + " {unrecognized event}");
        break;
    }
  }

  // The next three methods are for the fourth bullet of part IV

  public int getTotalArrivals() {
    return numberMessages;
  }

  public double getAverageInterarrival() {
    if (numberMessages == 0) return 0;
    return lastTime / numberMessages;
  }

  public String toString() {
    return super.toString() +
        "\nNumber of arrivals = " + getTotalArrivals() +
        ", average interarrival = " + getAverageInterarrival();
  }
}
